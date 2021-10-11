package com.walter.pokedata.data.repository.remote.provider

import com.walter.pokedata.data.repository.remote.PokemonPagingSource

interface PokemonPagingSourceProvider {
    val instance: PokemonPagingSource
}
