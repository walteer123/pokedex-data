package com.walter.pokedata.shared.data.datasource.remote

import com.walter.pokedata.shared.data.entity.PokemonListResponse
import com.walter.pokedata.shared.data.entity.PokemonRemote
import com.walter.pokedata.shared.data.service.PokemonService

class PokemonRemoteDataSource(private val service: PokemonService) {

    suspend fun getPokemonResponse(limit: Int = 50, offset: Int = 0): PokemonListResponse {
        return service.fetchPokemonList(limit, offset)
    }
}