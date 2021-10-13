package com.walter.pokedata.home.domain.repository

import com.walter.pokedata.home.data.repository.PokemonPagingSource

interface PokemonPagingSourceProvider {
    val instance: PokemonPagingSource
}
