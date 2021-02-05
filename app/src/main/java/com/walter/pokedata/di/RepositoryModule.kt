package com.walter.pokedata.di

import com.walter.pokedata.data.repository.PokemonRepositoryImpl
import com.walter.pokedata.domain.PokemonRepository
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
    abstract fun providePokemonRepository(impl: PokemonRepositoryImpl): PokemonRepository

}
