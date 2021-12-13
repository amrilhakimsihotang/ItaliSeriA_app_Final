package com.amrilhs.italiaseria.core.data.source.local

import com.amrilhs.italiaseria.core.data.source.local.entity.ItaliaSeriaEntity
import com.amrilhs.italiaseria.core.data.source.local.room.ItalianSeriaDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val italianSeriaDao: ItalianSeriaDao) {

    fun getAllSeriA(): Flow<List<ItaliaSeriaEntity>> = italianSeriaDao.getAllSeriA()

    fun getFavoriteSeriA(): Flow<List<ItaliaSeriaEntity>> = italianSeriaDao.getFavoriteSeriA()

    suspend fun insertItaliaSeriA(italiaList: List<ItaliaSeriaEntity>) =
        italianSeriaDao.insertItaliaSeriA(italiaList)

    fun setFavoriteItaliaSeriA(italiaSeria: ItaliaSeriaEntity, newState: Boolean) {
        italiaSeria.isFavorite = newState
        italianSeriaDao.updateFavoriteTourism(italiaSeria)
    }
}