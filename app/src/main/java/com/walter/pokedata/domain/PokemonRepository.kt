package com.walter.pokedata.domain


interface PokemonRepository {
    suspend fun fetchPokemonList(limit: Int, offset: Int) : List<Pokemon>
}
