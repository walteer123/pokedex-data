package com.walter.pokedata.home.domain.repository

import com.walter.pokedata.shared.data.datasource.remote.PokemonPagingDataSource

interface PokemonPagingSourceProvider {
    val instance: PokemonPagingDataSource
}
