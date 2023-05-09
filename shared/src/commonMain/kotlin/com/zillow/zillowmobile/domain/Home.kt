package com.zillow.zillowmobile.domain

data class Home(
    val id: String? = null,
    val imgSrc: String? = null,
    val carouselPhotos: List<String>? = emptyList(),
    val price: String? = null,
    val beds: Int? = null,
    val baths: Double? = null,
    val statusText: String? = null,
    val address: String? = null,
    val brokerName: String? = null
)
