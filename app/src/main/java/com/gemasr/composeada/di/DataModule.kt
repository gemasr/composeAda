package com.gemasr.composeada.di

import com.gemasr.composeada.data.remote.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Named("PokeApiURL")
    fun provideURL(): String {
        return "https://pokeapi.co/api/v2/"
    }

    @Provides
    @Singleton
    fun providePokemonApi(
        @Named("PokeApiURL") apiUrl: String
    ): PokemonApi {
        return Retrofit.Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)
    }
}