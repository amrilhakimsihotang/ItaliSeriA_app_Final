package com.amrilhs.italiseria_app.detail


import androidx.lifecycle.ViewModel
import com.amrilhs.italiaseria.core.domain.model.SeriAModel
import com.amrilhs.italiaseria.core.domain.usecase.SeriAUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailSeriaViewModel @Inject constructor(private val seriAUseCase: SeriAUseCase) :
    ViewModel() {
    fun setFavoriteItaliaSeriA(seriAModel: SeriAModel, newState: Boolean) =
        seriAUseCase.setFavoriteItaliaSeriA(seriAModel, newState)
}