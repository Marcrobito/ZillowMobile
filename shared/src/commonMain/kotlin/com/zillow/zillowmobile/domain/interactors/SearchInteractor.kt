package com.zillow.zillowmobile.domain.interactors

import com.zillow.zillowmobile.domain.Location
import com.zillow.zillowmobile.domain.Response
import com.zillow.zillowmobile.domain.usecase.GetLocationUseCase

class SearchInteractor(
    private val getLocationUseCase: GetLocationUseCase
) {
    suspend fun getLocation(query: String): Response<List<Location>> = try {
        Response.Success(getLocationUseCase(query))
    } catch (e: Exception) {
        Response.Error(e)
    }
}