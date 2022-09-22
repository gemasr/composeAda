package com.gemasr.composeada.data.remote.response

import com.gemasr.composeada.domain.model.Pokemon
import com.gemasr.composeada.domain.model.PokemonThrowable
import java.io.IOException

data class PokemonResponse(
    val height: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val sprites: Sprites,
    val types: List<PokemonType>,
    val weight: Int
)

fun PokemonResponse.toPokemon(): Pokemon {
    return Pokemon(
        name = name,
        imageUrl = sprites.frontDefault,
        height = height,
        types = types.map { it.type.name },
        weight = weight,
        id = id
    )
}

fun Throwable?.toPokemonError(): PokemonThrowable {
    return when(this) {
        is IOException -> PokemonThrowable.Connection
        else -> PokemonThrowable.Other
    }
}