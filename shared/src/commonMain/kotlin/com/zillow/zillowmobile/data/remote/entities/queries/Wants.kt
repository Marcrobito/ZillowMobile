package com.zillow.zillowmobile.data.remote.entities.queries

@kotlinx.serialization.Serializable
data class Wants (
    val cat1:List<String> = listOf("listResults"),
    val cat2:List<String> = listOf("total"),
    val regionResults:List<String> = listOf("regionResults")
)