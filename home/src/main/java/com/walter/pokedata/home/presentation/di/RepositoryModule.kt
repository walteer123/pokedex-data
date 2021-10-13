package com.walter.pokedata.home.presentation.di

import com.walter.pokedata.home.data.repository.PokemonPagingSourceProviderImpl
import com.walter.pokedata.home.domain.repository.PokemonPagingSourceProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun providePagingSourceProvider(provider: PokemonPagingSourceProviderImpl): PokemonPagingSourceProvider

}
