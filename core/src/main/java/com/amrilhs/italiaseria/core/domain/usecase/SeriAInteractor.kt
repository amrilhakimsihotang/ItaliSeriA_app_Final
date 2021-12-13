package com.amrilhs.italiaseria.core.domain.usecase

import com.amrilhs.italiaseria.core.domain.model.SeriAModel
import com.amrilhs.italiaseria.core.domain.repository.ISeriARepository
import javax.inject.Inject

class SeriAInteractor @Inject constructor(private val italiaserARepository: ISeriARepository) :
    SeriAUseCase {

    override fun getAllSeriA() = italiaserARepository.getAllSeriA()

    override fun getFavoriteSeriA() = italiaserARepository.getFavoriteSeriA()

    override fun setFavoriteItaliaSeriA(italiaSeria: SeriAModel, newState: Boolean) =
        italiaserARepository.setFavoriteItaliaSeriA(italiaSeria, newState)

}
