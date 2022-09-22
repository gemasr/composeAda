package com.gemasr.composeada.core.util

typealias SimpleResource = Resource<Unit>

sealed class Resource<T>(val data: T? = null, val error: Throwable? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(error: Throwable? = null, data: T? = null) : Resource<T>(data, error)
}
