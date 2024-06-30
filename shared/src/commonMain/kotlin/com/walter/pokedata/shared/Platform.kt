package com.walter.pokedata.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform