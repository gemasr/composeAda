package com.gemasr.composeada.di

import com.gemasr.composeada.data.PokemonRepositoryImpl
import com.gemasr.composeada.domain.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPokemonRepository(
        repositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository
}