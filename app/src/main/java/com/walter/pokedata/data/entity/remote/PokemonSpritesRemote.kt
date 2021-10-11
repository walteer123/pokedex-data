package com.walter.pokedata.data.entity.remote

import com.squareup.moshi.Json

data class PokemonSpritesRemote(
    @field:Json(name = "front_default") val frontDefault: String?
)
