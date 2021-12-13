package com.amrilhs.italiaseria.core.domain.usecase

import com.amrilhs.italiaseria.core.data.Resource
import com.amrilhs.italiaseria.core.domain.model.SeriAModel
import kotlinx.coroutines.flow.Flow

interface SeriAUseCase {

    fun getAllSeriA(): Flow<Resource<List<SeriAModel>>>
    fun getFavoriteSeriA(): Flow<List<SeriAModel>>
    fun setFavoriteItaliaSeriA(italiaSeria: SeriAModel, newState: Boolean)
}