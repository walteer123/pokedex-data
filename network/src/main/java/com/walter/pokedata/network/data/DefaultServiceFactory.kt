package com.walter.pokedata.network.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DefaultServiceFactory: NetworkServiceFactory {

    private val okHttpClient by lazy { OkHttpClient.Builder().build() }

    private val retrofit by lazy { Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        }

    private val moshi by lazy {
         Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()
    }

    override fun <T> create(service: Class<T>): T = retrofit.create(service)

}
