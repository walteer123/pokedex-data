package com.walter.pokedata.home.data.repository

import com.walter.pokedata.home.data.service.PokemonService
import com.walter.pokedata.home.domain.repository.PokemonPagingSourceProvider
import javax.inject.Inject

class PokemonPagingSourceProviderImpl @Inject constructor(private val service: PokemonService) :
    PokemonPagingSourceProvider {
    override val instance: PokemonPagingSource
        get() = PokemonPagingSource(service)
}
