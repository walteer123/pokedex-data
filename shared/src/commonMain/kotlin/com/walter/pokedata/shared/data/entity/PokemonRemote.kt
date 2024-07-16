package com.walter.pokedata.shared.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonRemote(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String?
)