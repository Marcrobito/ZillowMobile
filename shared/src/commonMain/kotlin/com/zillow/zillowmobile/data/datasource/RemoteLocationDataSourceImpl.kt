package com.zillow.zillowmobile.data.datasource

import com.zillow.zillowmobile.data.dao.mapToLocation
import com.zillow.zillowmobile.data.remote.ZillowStaticApiService
import com.zillow.zillowmobile.domain.Location
import com.zillow.zillowmobile.domain.datasource.LocationDataSource
import com.zillow.zillowmobile.util.Dispatcher
import kotlinx.coroutines.withContext

class RemoteLocationDataSourceImpl(
    private val apiService: ZillowStaticApiService,
    private val dispatcher: Dispatcher
) : LocationDataSource {

    override suspend fun getLocation(query: String): List<Location> = withContext(dispatcher.io) {
        apiService.queryLocations(query).results.mapToLocation()
    }

}
