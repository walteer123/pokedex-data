package com.walter.pokedata.shared.data.datasource.remote

import com.walter.pokedata.shared.data.entity.PokemonRemote
import com.walter.pokedata.shared.data.service.PokemonService

class PokemonRemoteDataSource(private val service: PokemonService) {

    suspend fun getPokemons(): List<PokemonRemote> {
        return service.fetchPokemonList()
            .results
    }
}