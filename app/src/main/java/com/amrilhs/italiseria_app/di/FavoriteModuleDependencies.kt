package com.amrilhs.italiseria_app.di

import com.amrilhs.italiaseria.core.domain.usecase.SeriAUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {
    fun seriAUseCase(): SeriAUseCase
}