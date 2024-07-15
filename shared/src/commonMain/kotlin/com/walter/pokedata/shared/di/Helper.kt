package com.walter.pokedata.shared.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(injectAppModule())
    }
}