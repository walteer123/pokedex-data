package com.walter.pokedata.shared.di

import com.walter.pokedata.shared.data.datasource.local.PokemonLocalDataSource
import com.walter.pokedata.shared.data.datasource.remote.PokemonRemoteDataSource
import com.walter.pokedata.shared.data.repository.PokemonRepository
import com.walter.pokedata.shared.data.service.PokemonService
import com.walter.pokedata.shared.data.service.PokemonServiceImpl
import org.koin.dsl.module

val dataModule = module {
    single<PokemonService> { PokemonServiceImpl(get()) }
    single { PokemonRemoteDataSource(service = get()) }
    single { PokemonLocalDataSource(databaseServiceFactory = get()) }
    single {
        PokemonRepository(
            remoteDataSource = get(),
            localDataSource = get()
        )
    }
}