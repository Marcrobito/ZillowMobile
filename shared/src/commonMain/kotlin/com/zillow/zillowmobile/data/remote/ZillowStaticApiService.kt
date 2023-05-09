package com.zillow.zillowmobile.data.remote

import com.zillow.zillowmobile.data.remote.entities.responses.SuggestionsResponse
import io.ktor.client.call.*
import io.ktor.client.request.*

private const val BASE_URL = "https://www.zillowstatic.com/"

class ZillowStaticApiService : KtorApi(BASE_URL) {

    suspend fun queryLocations(query: String) = client.get {
        pathUrl("autocomplete/v3/suggestions")
        parameter("q", query)
    }.body<SuggestionsResponse>()

}
