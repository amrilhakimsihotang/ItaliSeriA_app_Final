package com.amrilhs.italiaseria.core.di

import com.amrilhs.italiaseria.core.data.ItaliaSeriRepository
import com.amrilhs.italiaseria.core.domain.repository.ISeriARepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(italiaSeriRepository: ItaliaSeriRepository): ISeriARepository
}