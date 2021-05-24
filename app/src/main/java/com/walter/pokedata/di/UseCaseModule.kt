package com.walter.pokedata.di

import com.walter.pokedata.data.usecase.ConnectionStatusUseCaseImpl
import com.walter.pokedata.domain.usecase.ConnectionStatusUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun provideConnectionStatusUseCase(
        connectionStatusUseCase: ConnectionStatusUseCaseImpl
    ): ConnectionStatusUseCase
}
