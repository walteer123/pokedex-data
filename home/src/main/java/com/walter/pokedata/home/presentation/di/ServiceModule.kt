package com.walter.pokedata.home.presentation.di

import com.walter.pokedata.home.data.service.PokemonService
import com.walter.pokedata.network.data.NetworkServiceFactory
import com.walter.pokedata.network.di.component.DefaultRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun providePokemonService(@DefaultRetrofit factory: NetworkServiceFactory) = factory.create(PokemonService::class.java)

}
