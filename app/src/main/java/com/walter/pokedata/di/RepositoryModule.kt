package com.walter.pokedata.di

import com.walter.pokedata.data.repository.local.ConnectionStatusRepositoryImpl

import com.walter.pokedata.domain.repository.ConnectionStatusRepository
import com.walter.pokedata.network.SafeRequest
import com.walter.pokedata.network.SafeRequestImpl
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
    abstract fun provideSafeRequest(impl: SafeRequestImpl): SafeRequest

    @Binds
    abstract fun provideConnectionStatusRepository(repository: ConnectionStatusRepositoryImpl): ConnectionStatusRepository

}
