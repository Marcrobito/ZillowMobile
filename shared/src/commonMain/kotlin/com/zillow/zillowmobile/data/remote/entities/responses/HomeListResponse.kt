package com.zillow.zillowmobile.data.remote.entities.responses

import com.zillow.zillowmobile.data.dao.HomeDao

@kotlinx.serialization.Serializable
data class HomeListResponse(val cat1: SearchResults)

@kotlinx.serialization.Serializable
data class SearchResults(val searchResults: ListResults)

@kotlinx.serialization.Serializable
data class ListResults(val listResults: List<HomeDao>)

