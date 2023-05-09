package com.zillow.zillowmobile.domain.interactors

import com.zillow.zillowmobile.domain.Home
import com.zillow.zillowmobile.domain.Location
import com.zillow.zillowmobile.domain.Response
import com.zillow.zillowmobile.domain.usecase.GetHomeListUseCase

class HomeListInteractor(
    private val getHomeListUseCase: GetHomeListUseCase
) {
    suspend fun getHomeList(location: Location): Response<List<Home>> = try {
        Response.Success(getHomeListUseCase.invoke(location))
    } catch (e: Exception) {
        Response.Error(e)
    }
}