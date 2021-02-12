package com.walter.pokedata.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface PokemonUseCase {
    fun getPokemonData() : Flow<PagingData<Pokemon>>
}
