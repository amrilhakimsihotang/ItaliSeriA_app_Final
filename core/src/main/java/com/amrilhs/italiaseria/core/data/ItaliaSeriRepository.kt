package com.amrilhs.italiaseria.core.data

import com.amrilhs.italiaseria.core.data.source.local.LocalDataSource
import com.amrilhs.italiaseria.core.data.source.remote.RemoteDataSource
import com.amrilhs.italiaseria.core.data.source.remote.network.ApiResponse
import com.amrilhs.italiaseria.core.data.source.remote.response.TeamsResponse
import com.amrilhs.italiaseria.core.domain.model.SeriAModel
import com.amrilhs.italiaseria.core.domain.repository.ISeriARepository
import com.amrilhs.italiaseria.core.utils.AppExcecutors
import com.amrilhs.italiaseria.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItaliaSeriRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExcecutors: AppExcecutors

) : ISeriARepository {
    override fun getAllSeriA(): Flow<Resource<List<SeriAModel>>> =
        object : NetworkBoundResource<List<SeriAModel>, List<TeamsResponse>>() {
            override fun loadFromDB(): Flow<List<SeriAModel>> {
                return localDataSource.getAllSeriA().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<SeriAModel>?): Boolean =
                true

            override suspend fun createCall(): Flow<ApiResponse<List<TeamsResponse>>> =
                remoteDataSource.getAllSeriA()


            override suspend fun saveCallResult(data: List<TeamsResponse>) {
                val italiaSeriaEntityList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertItaliaSeriA(italiaSeriaEntityList)
            }

        }.asFlow()

    override fun getFavoriteSeriA(): Flow<List<SeriAModel>> {
        return localDataSource.getFavoriteSeriA().map { DataMapper.mapEntitiesToDomain(it) }
    }

    override fun setFavoriteItaliaSeriA(seriAModel: SeriAModel, state: Boolean) {
        val italiaSeriaEntity = DataMapper.mapDomainToEntity(seriAModel)
        appExcecutors.diskIO()
            .execute { localDataSource.setFavoriteItaliaSeriA(italiaSeriaEntity, state) }
    }
}