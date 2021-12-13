package com.amrilhs.italiaseria.core.domain.repository

import com.amrilhs.italiaseria.core.data.Resource
import com.amrilhs.italiaseria.core.domain.model.SeriAModel
import kotlinx.coroutines.flow.Flow

interface ISeriARepository {

    fun getAllSeriA(): Flow<Resource<List<SeriAModel>>>

    fun getFavoriteSeriA(): Flow<List<SeriAModel>>

    fun setFavoriteItaliaSeriA(seriAModel: SeriAModel, state: Boolean)
}