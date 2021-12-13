package com.amrilhs.italiseria.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.amrilhs.italiaseria.core.domain.usecase.SeriAUseCase


class FavoriteViewModel(seriAUseCase: SeriAUseCase) : ViewModel() {
    val favoriteTeam = seriAUseCase.getFavoriteSeriA().asLiveData()
}