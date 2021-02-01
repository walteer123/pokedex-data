package com.walter.pokedata.domain

interface PokemonRepository {

    suspend fun fetchPokemonList() : List<Pokemon>

}
