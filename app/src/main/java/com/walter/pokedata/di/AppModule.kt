package com.walter.pokedata.di

import org.koin.core.module.Module

val appModules: List<Module> = listOf(
    databaseModule,
    appRepositoryModule,
)