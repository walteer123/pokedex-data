package com.walter.pokedata.shared.data.service

import com.walter.pokedata.shared.data.entity.PokemonListResponse

interface PokemonService {
    suspend fun fetchPokemonList(
        limit: Int = 20,
         offset: Int = 0
    ): PokemonListResponse
}