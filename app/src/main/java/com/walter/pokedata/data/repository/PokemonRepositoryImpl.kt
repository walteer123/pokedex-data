package com.walter.pokedata.data.repository

import com.walter.pokedata.domain.PokemonRepository
import com.walter.pokedata.network.SafeRequest
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
        private val pokemonService: PokemonService,
        private val safeRequest: SafeRequest
): PokemonRepository {
    override suspend fun fetchPokemonList(limit: Int, offset: Int) = safeRequest {
        pokemonService.fetchPokemonList(limit, offset).results.map { it.transform() }
    }
}
