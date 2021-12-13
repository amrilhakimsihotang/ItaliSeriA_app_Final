package com.amrilhs.italiaseria.core.data.source.local.room

import androidx.room.*
import com.amrilhs.italiaseria.core.data.source.local.entity.ItaliaSeriaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItalianSeriaDao {
    @Query("SELECT * FROM italiaseria")
    fun getAllSeriA(): Flow<List<ItaliaSeriaEntity>>

    @Query("SELECT * FROM italiaseria where isFavorite = 1")
    fun getFavoriteSeriA(): Flow<List<ItaliaSeriaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItaliaSeriA(italiaseria: List<ItaliaSeriaEntity>)

    @Update
    fun updateFavoriteTourism(italiaseria: ItaliaSeriaEntity)

}