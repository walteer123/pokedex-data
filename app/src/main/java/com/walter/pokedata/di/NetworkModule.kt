package com.walter.pokedata.di

import com.walter.pokedata.data.service.PokemonService
import com.walter.pokedata.presentation.receiver.WifiStateReceiver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providePokemonService(retrofit: Retrofit) = retrofit.create(PokemonService::class.java)

    @Provides
    @Singleton
    fun provideWifiStateReceiver() = WifiStateReceiver()
}
