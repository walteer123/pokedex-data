package com.walter.pokedata.shared.network.factory

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class DefaultServiceFactory : NetworkServiceFactory {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }

        defaultRequest {
            contentType(ContentType.Application.Json)
            url("https://pokeapi.co/api/v2/")
        }
    }

    override fun client(): HttpClient = client
}
