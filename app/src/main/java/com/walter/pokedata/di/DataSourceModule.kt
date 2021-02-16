package com.walter.pokedata.di

import com.walter.pokedata.data.repository.PokemonPagingSource
import com.walter.pokedata.domain.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DataSourceModule {

    @Provides
    @ViewModelScoped
    fun providePokemonPagingSource(
        repository: PokemonRepository
    ): PokemonPagingSource {
        return PokemonPagingSource(repository)
    }

}
