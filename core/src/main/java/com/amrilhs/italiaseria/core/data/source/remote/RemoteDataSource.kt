package com.amrilhs.italiaseria.core.data.source.remote

import android.util.Log
import com.amrilhs.italiaseria.core.data.source.remote.network.ApiResponse
import com.amrilhs.italiaseria.core.data.source.remote.network.ApiService
import com.amrilhs.italiaseria.core.data.source.remote.response.TeamsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllSeriA(): Flow<ApiResponse<List<TeamsResponse>>> {
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.team
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.team))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}