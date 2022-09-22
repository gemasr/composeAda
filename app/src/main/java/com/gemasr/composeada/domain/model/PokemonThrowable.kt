package com.gemasr.composeada.domain.model

sealed class PokemonThrowable: Throwable() {
    object Connection: PokemonThrowable()
    object Other: PokemonThrowable()
}