package com.walter.pokedata.domain.repository

import com.walter.pokedata.data.entity.remote.PokemonListResponse
import com.walter.pokedata.domain.entity.Pokemon
import com.walter.pokedata.util.Status

interface PokemonRepository {
    suspend fun fetchPokemonList(limit: Int, offset: Int) : Status<PokemonListResponse>
}
