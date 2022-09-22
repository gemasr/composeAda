package com.gemasr.composeada.domain

import com.gemasr.composeada.core.util.Resource
import com.gemasr.composeada.domain.model.Pokemon

interface PokemonRepository {

    suspend fun getPokemon(name: String): Resource<Pokemon>

    suspend fun getPokemons(limit: Int, offset: Int): Resource<List<Pokemon>>

}