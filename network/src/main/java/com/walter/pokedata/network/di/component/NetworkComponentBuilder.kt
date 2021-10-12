package com.walter.pokedata.network.di.component

import com.walter.pokedata.network.data.NetworkServiceFactory
import dagger.BindsInstance
import dagger.hilt.DefineComponent

@DefineComponent.Builder
interface NetworkComponentBuilder {
    fun networkServiceFactory(@BindsInstance networkServiceFactory: NetworkServiceFactory): NetworkComponentBuilder
    fun build(): NetworkComponent
}
