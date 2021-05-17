package com.walter.pokedata.di

import com.squareup.moshi.Moshi
import com.walter.pokedata.data.service.PokemonService
import com.walter.pokedata.presentation.receiver.WifiStateReceiver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi) = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Provides
    @Singleton
    fun providePokemonService(retrofit: Retrofit) = retrofit.create(PokemonService::class.java)

    @Provides
    @Singleton
    fun provideWifiStateReceiver() = WifiStateReceiver()
}
