package com.walter.pokedata.shared.data.service

import com.walter.pokedata.shared.data.entity.PokemonListResponse

interface PokemonService {
    suspend fun fetchPokemonList(
        limit: Int = 50,
         offset: Int = 0
    ): PokemonListResponse
}