package com.zillow.zillowmobile.data.remote

import com.zillow.zillowmobile.data.remote.entities.queries.SearchQueryState
import com.zillow.zillowmobile.data.remote.entities.responses.HomeListResponse
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://www.zillow.com/"

class ZillowApiService : KtorApi(BASE_URL) {

    suspend fun getHomesAtLocation(query: SearchQueryState) = client.get {
        pathUrl("search/GetSearchPageState.htm")
        parameter("searchQueryState", Json.encodeToString(query))
        parameter(
            "wants",
            "{\"cat1\":[\"listResults\"],\"cat2\":[\"total\"],\"regionResults\":[\"regionResults\"]}"
        )
    }.body<HomeListResponse>()

}