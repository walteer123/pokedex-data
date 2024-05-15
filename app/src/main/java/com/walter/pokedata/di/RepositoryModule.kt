package com.walter.pokedata.di

import com.walter.pokedata.network.SafeRequest
import com.walter.pokedata.network.SafeRequestImpl
import org.koin.dsl.module

val appRepositoryModule = module {
    single<SafeRequest> { SafeRequestImpl() }
}
