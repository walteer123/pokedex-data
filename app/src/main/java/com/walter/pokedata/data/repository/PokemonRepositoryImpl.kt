package com.walter.pokedata.data.repository

import com.walter.pokedata.domain.Pokemon
import com.walter.pokedata.domain.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
        private val pokemonService: PokemonService
): PokemonRepository {
    override suspend fun fetchPokemonList(): List<Pokemon> {
        val teste = pokemonService.fetchPokemonList(20,0).results.map { it.transform() }
        return teste
    }

}
