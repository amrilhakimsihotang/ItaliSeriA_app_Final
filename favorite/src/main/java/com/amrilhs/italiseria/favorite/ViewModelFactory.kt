package com.amrilhs.italiseria.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amrilhs.italiaseria.core.domain.usecase.SeriAUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val seriaUseCase: SeriAUseCase) :
    ViewModelProvider.NewInstanceFactory() {
    //recommendation from the reviewer team -
    // avoid the @supprise that really does not necessary anymore
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(seriaUseCase) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}