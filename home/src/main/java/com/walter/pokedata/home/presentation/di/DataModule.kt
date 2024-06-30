package com.walter.pokedata.home.presentation.di

import com.walter.pokedata.home.data.repository.PokemonPagingSourceProviderImpl
import com.walter.pokedata.home.domain.repository.PokemonPagingSourceProvider
import com.walter.pokedata.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule get()  = listOf(
    dataModule
)
private val dataModule = module {
    single<PokemonPagingSourceProvider> { PokemonPagingSourceProviderImpl(service = get())  }
    viewModel{ HomeViewModel(pokemonPagingSource = get()) }
}