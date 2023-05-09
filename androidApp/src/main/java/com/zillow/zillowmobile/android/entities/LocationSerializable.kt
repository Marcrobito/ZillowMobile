package com.zillow.zillowmobile.android.entities

import com.zillow.zillowmobile.domain.Location

@kotlinx.serialization.Serializable
data class LocationSerializable(
    val regionId: Int,
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

fun Location.mapToLocationSerializable() = LocationSerializable(
    regionId, name, type, regionType, city, countyFIPS, county, state, country, lat, lng
)

fun LocationSerializable.mapToLocation() = Location(
    regionId, name, type, regionType, city, countyFIPS, county, state, country, lat, lng
)