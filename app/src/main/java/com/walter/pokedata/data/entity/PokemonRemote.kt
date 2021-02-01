package com.walter.pokedata.data.entity

import com.squareup.moshi.Json

data class PokemonRemote(
        @field:Json(name = "name") val name: String,
        @field:Json(name = "url") val details: String
)
