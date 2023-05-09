package com.zillow.zillowmobile.data.dao

@kotlinx.serialization.Serializable
data class LocationDAO(
    val display: String,
    val resultType: String,
    val metaData: MetaDataDAO
)

@kotlinx.serialization.Serializable
data class MetaDataDAO(
    val regionId: Int,
    val regionType: String,
    val city: String? = null,
    val county: String? = null,
    val countyFIPS: String? = null,
    val state: String,
    val country: String,
    val lat: Double,
    val lng: Double
)
