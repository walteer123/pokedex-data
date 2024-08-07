package com.walter.pokedata.shared.data.entity

import com.walter.pokedata.shared.data.extensions.getImageUrl
import com.walter.pokedata.sql.PokemonEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonRemote(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String?
)

fun PokemonRemote.toLocalEntity() = PokemonEntity(
    name = name,
    imageUrl = getImageUrl(this),
    isFavorite = 0L,
    url = url.orEmpty()
)