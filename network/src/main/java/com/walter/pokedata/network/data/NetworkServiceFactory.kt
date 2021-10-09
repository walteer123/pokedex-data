package com.walter.pokedata.network.data

interface NetworkServiceFactory {
    fun <T> create(service: Class<T>) : T
}
