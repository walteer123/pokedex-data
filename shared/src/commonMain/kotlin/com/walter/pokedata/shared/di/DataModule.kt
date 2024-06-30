package com.walter.pokedata.shared.di

import com.walter.pokedata.shared.data.service.PokemonService
import com.walter.pokedata.shared.data.service.PokemonServiceImpl
import org.koin.dsl.module

val dataModule = module {
    single<PokemonService> { PokemonServiceImpl(get()) }
}