package com.zillow.zillowmobile.data.remote

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

abstract class KtorApi(private val baseURL: String) {

    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })

        }
    }

    fun HttpRequestBuilder.pathUrl(path: String) {
        url {
            takeFrom(baseURL)
            path(path)
        }
    }
}