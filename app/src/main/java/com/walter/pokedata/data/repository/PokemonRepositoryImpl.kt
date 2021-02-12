package com.walter.pokedata.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.walter.pokedata.domain.Pokemon
import com.walter.pokedata.domain.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
        private val pokemonService: PokemonService
): PokemonRepository {
    override suspend fun fetchPokemonList(limit: Int, offset: Int) = withContext(Dispatchers.IO){
        pokemonService.fetchPokemonList(limit, offset).results.map { it.transform() }
    }

}
