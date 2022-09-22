package com.gemasr.composeada.presentation.list

import com.gemasr.composeada.domain.model.Pokemon
import com.gemasr.composeada.domain.model.PokemonThrowable


data class PokemonListState(
    val pokemons: List<Pokemon> = emptyList(),
    val isLoading: Boolean = false,
    val error: PokemonThrowable? = null
)
