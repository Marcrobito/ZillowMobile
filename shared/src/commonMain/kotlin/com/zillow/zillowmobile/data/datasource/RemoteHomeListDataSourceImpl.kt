package com.zillow.zillowmobile.data.datasource

import com.zillow.zillowmobile.data.dao.mapToHome
import com.zillow.zillowmobile.data.dao.mapToSearchQueryState
import com.zillow.zillowmobile.data.remote.ZillowApiService
import com.zillow.zillowmobile.domain.Home
import com.zillow.zillowmobile.domain.Location
import com.zillow.zillowmobile.domain.datasource.HomeListDataSource
import com.zillow.zillowmobile.util.Dispatcher
import kotlinx.coroutines.withContext

class RemoteHomeListDataSourceImpl(
    private val service: ZillowApiService,
    private val dispatcher: Dispatcher
) : HomeListDataSource {
    override suspend fun getHomeList(location: Location): List<Home> = withContext(dispatcher.io) {
        service.getHomesAtLocation(location.mapToSearchQueryState()).cat1.searchResults.listResults.mapToHome()
    }
}