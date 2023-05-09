package com.zillow.zillowmobile.data.dao

@kotlinx.serialization.Serializable
data class HomeDao(
    val id: String? = null,
    val imgSrc: String? = null,
    val carouselPhotos: List<PhotoDao>? = emptyList(),
    val price: String? = null,
    val beds: Int? = null,
    val baths: Double? = null,
    val statusText: String? = null,
    val address: String? = null,
    val brokerName: String? = null
)

@kotlinx.serialization.Serializable
data class PhotoDao(
    val url: String
)
