package com.walter.pokedata.di

import com.walter.pokedata.presentation.receiver.WifiStateReceiver
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
    fun provideWifiStateReceiver() = WifiStateReceiver()

}
