package com.walter.pokedata.data.repository

import com.walter.pokedata.domain.PokemonRepository
import javax.inject.Inject

class PokemonPagingSourceProviderImpl @Inject constructor(private val repository: PokemonRepository): PokemonPagingSourceProvider {
    override val instance: PokemonPagingSource
        get() = PokemonPagingSource(repository)

}
