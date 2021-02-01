package com.walter.pokedata.data.repository

import com.walter.pokedata.domain.Pokemon
import com.walter.pokedata.domain.PokemonRepository

class PokemonRepositoryImpl: PokemonRepository {
    override suspend fun fetchPokemonList(): List<Pokemon> {
        TODO("Injection and return list from repo")
    }


}