package com.walter.pokedata.data.repository

import com.walter.pokedata.domain.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
        private val pokemonService: PokemonService
): PokemonRepository {
    override suspend fun fetchPokemonList(limit: Int, offset: Int) = withContext(Dispatchers.IO){
        pokemonService.fetchPokemonList(limit, offset).results.map { it.transform() }
    }




}
