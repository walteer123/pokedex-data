package com.walter.pokedata

import android.app.Application
import com.walter.pokedata.di.appModules
import com.walter.pokedata.home.presentation.di.homeModule
import com.walter.pokedata.shared.di.injectAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin


class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            modules(appModules + homeModule + injectAppModule())
        }
    }
}
