package com.walter.pokedata

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun createRetrofit() = Retrofit.Builder()
    .baseUrl("https://api.github.com/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()