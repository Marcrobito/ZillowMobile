package com.zillow.zillowmobile.domain

data class Location(
    val regionId:Int,
    val name: String,
    val type: String,
    val regionType: String,
    val city: String? = null,
    val countyFIPS: String? = null,
    val county: String? = null,
    val state: String,
    val country: String,
    val lat: Double,
    val lng: Double
)

