package com.walter.pokedata.network

import com.walter.pokedata.util.Status

interface SafeRequest {
    suspend operator fun <T> invoke(lambda: suspend () -> (T)): Status<T>
}
