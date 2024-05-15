package com.walter.pokedata.home.presentation.di

import com.walter.pokedata.home.data.repository.PokemonPagingSourceProviderImpl
import com.walter.pokedata.home.data.service.PokemonService
import com.walter.pokedata.home.domain.repository.PokemonPagingSourceProvider
import com.walter.pokedata.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val homeModule get()  = listOf(
    dataModule
)
private val dataModule = module {
    single<PokemonService> { get<Retrofit>().create(PokemonService::class.java)  }
    single<PokemonPagingSourceProvider> { PokemonPagingSourceProviderImpl(service = get())  }
    viewModel{ HomeViewModel(pokemonPagingSource = get()) }
}