package com.walter.pokedata.domain

import com.walter.pokedata.util.Status

interface PokemonRepository {
    suspend fun fetchPokemonList(limit: Int, offset: Int) : Status<List<Pokemon>>
}
