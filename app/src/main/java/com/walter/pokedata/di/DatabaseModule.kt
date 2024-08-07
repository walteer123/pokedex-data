package com.walter.pokedata.di

import com.walter.pokedata.shared.factory.DatabaseServiceFactory
import com.walter.pokedata.shared.factory.DatabaseServiceFactoryImpl
import com.walter.pokedata.shared.factory.DriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val databaseModule = module {
    single { DriverFactory(context = androidContext()) }
    single<DatabaseServiceFactory> { DatabaseServiceFactoryImpl(driverFactory = get())  }

}