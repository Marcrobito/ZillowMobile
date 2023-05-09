package com.zillow.zillowmobile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform