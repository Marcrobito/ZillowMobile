package com.zillow.zillowmobile.data.remote.entities.responses

import com.zillow.zillowmobile.data.dao.LocationDAO
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class SuggestionsResponse(@SerialName("results") val results: ArrayList<LocationDAO>)
