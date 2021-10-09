package com.walter.pokedata.di

import com.walter.pokedata.data.service.PokemonService
import com.walter.pokedata.network.data.DefaultServiceFactory
import com.walter.pokedata.network.data.NetworkServiceFactory
import com.walter.pokedata.presentation.receiver.WifiStateReceiver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun providePokemonService(
        factory: NetworkServiceFactory
    ): PokemonService = factory.create(PokemonService::class.java)

    @Provides
    @Singleton
    fun provideWifiStateReceiver() = WifiStateReceiver()

    @Provides
    @Singleton
    fun provideServiceFactory(): NetworkServiceFactory = DefaultServiceFactory()
}
