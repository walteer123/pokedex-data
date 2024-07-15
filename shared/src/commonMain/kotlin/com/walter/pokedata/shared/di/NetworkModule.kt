package com.walter.pokedata.shared.di

import com.walter.pokedata.shared.network.factory.DefaultServiceFactory
import com.walter.pokedata.shared.network.factory.NetworkServiceFactory
import org.koin.dsl.module

val networkModule = module {
    single <NetworkServiceFactory>{ DefaultServiceFactory() }
}