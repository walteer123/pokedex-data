package com.walter.pokedata.data.repository.remote.provider

import com.walter.pokedata.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonPagingSourceProviderImpl @Inject constructor(private val repository: PokemonRepository):
    PokemonPagingSourceProvider {
    override val instance: PokemonPagingSource
        get() = PokemonPagingSource(repository)

}
