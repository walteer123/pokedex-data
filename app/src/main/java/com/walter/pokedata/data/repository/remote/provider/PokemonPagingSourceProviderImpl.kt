package com.walter.pokedata.data.repository.remote.provider

import com.walter.pokedata.data.repository.remote.PokemonPagingSource
import com.walter.pokedata.data.service.PokemonService
import javax.inject.Inject

class PokemonPagingSourceProviderImpl @Inject constructor(private val service: PokemonService) :
    PokemonPagingSourceProvider {
    override val instance: PokemonPagingSource
        get() = PokemonPagingSource(service)
}
