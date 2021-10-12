package com.walter.pokedata.network.di.component

import com.walter.pokedata.network.data.DefaultServiceFactory
import com.walter.pokedata.network.data.NetworkServiceFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideDefaultNetworkServiceFactory(): NetworkServiceFactory = DefaultServiceFactory()
}
