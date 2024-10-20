package com.bemos.filedrop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform