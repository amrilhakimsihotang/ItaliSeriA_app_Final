package com.amrilhs.italiseria_app.di

import com.amrilhs.italiaseria.core.domain.usecase.SeriAInteractor
import com.amrilhs.italiaseria.core.domain.usecase.SeriAUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideItaliaSeriAUseCase(seriAInteractor: SeriAInteractor): SeriAUseCase
}