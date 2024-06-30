package com.walter.pokedata.home.data.repository

import com.walter.pokedata.home.domain.repository.PokemonPagingSourceProvider
import com.walter.pokedata.shared.data.service.PokemonService

class PokemonPagingSourceProviderImpl(private val service: PokemonService) :
    PokemonPagingSourceProvider {
    override val instance: PokemonPagingSource
        get() = PokemonPagingSource(service)
}
