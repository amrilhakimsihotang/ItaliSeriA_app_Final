package com.amrilhs.italiseria_app.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.amrilhs.italiaseria.core.domain.usecase.SeriAUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(seriAUseCase: SeriAUseCase) : ViewModel() {
    val italiSeriA = seriAUseCase.getAllSeriA().asLiveData()
}