package com.walter.pokedata.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.walter.pokedata.domain.Pokemon
import com.walter.pokedata.domain.PokemonRepository
import com.walter.pokedata.domain.PokemonUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonUseCaseImpl @Inject constructor(private val repository: PokemonRepository) : PokemonUseCase {

    override fun getPokemonData(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PokemonPagingSource(repository)}
        ).flow
    }

}
