package com.walter.pokedata.shared.di

import com.walter.pokedata.shared.data.service.PokemonService
import com.walter.pokedata.shared.data.service.PokemonServiceImpl
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object KoinDependencies: KoinComponent {
    
    val pokemonService by inject<PokemonService>()
}