package com.gemasr.composeada.core.util

import com.gemasr.composeada.data.remote.response.toPokemonError

suspend fun <T>httpRequest(content: suspend () -> T): Resource<T> {
    return try {
        Resource.Success(
            data = content()
        )
    } catch (e: Exception) {
        Resource.Error(e.toPokemonError())
    }
}