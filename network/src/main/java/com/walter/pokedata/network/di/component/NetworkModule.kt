package com.walter.pokedata.network.di.component

import com.walter.pokedata.network.data.DefaultServiceFactory
import com.walter.pokedata.network.data.NetworkServiceFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    @DefaultRetrofit
    abstract fun provideDefaultNetworkServiceFactory(factory: DefaultServiceFactory): NetworkServiceFactory
}

@Qualifier
annotation class DefaultRetrofit
