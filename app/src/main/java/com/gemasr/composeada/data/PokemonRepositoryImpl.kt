package com.gemasr.composeada.data

import com.gemasr.composeada.core.util.Resource
import com.gemasr.composeada.core.util.httpRequest
import com.gemasr.composeada.data.remote.PokemonApi
import com.gemasr.composeada.data.remote.response.toPokemon
import com.gemasr.composeada.domain.PokemonRepository
import com.gemasr.composeada.domain.model.Pokemon
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi
): PokemonRepository {

    override suspend fun getPokemon(name: String): Resource<Pokemon> {
        return httpRequest {
            api.getPokemonByName(name).toPokemon()
        }
    }

    override suspend fun getPokemons(limit: Int, offset: Int): Resource<List<Pokemon>> {
        return httpRequest {
            val pokemons = api.getPokemons(limit, offset)
            pokemons.results.map {
                api.getPokemonByName(it.name).toPokemon()
            }
        }
    }
}