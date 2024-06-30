package com.walter.pokedata.shared.network.factory

import io.ktor.client.HttpClient

interface NetworkServiceFactory {
    fun client(): HttpClient
}
