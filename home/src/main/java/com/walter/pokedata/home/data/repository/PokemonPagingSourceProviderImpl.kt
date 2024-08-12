package com.walter.pokedata.home.data.repository

import com.walter.pokedata.home.domain.repository.PokemonPagingSourceProvider
import com.walter.pokedata.shared.data.datasource.remote.PokemonPagingDataSource
import com.walter.pokedata.shared.data.service.PokemonService

class PokemonPagingSourceProviderImpl(private val service: PokemonService) :
    PokemonPagingSourceProvider {
    override val instance: PokemonPagingDataSource
        get() = PokemonPagingDataSource(service)
}
