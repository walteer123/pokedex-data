package com.walter.pokedata.shared.data.service

import com.walter.pokedata.shared.data.entity.PokemonListResponse
import com.walter.pokedata.shared.network.factory.NetworkServiceFactory
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.parameters

class PokemonServiceImpl(private val serviceFactory: NetworkServiceFactory): PokemonService {
    override suspend fun fetchPokemonList(limit: Int, offset: Int): PokemonListResponse {
         val teste = serviceFactory.client().get("pokemon"){
            parameters {
                append("limit", limit.toString())
                append("offset", offset.toString())
            }
        }
        return teste.body()
    }
}
