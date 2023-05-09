package com.zillow.zillowmobile.data.repository

import com.zillow.zillowmobile.domain.datasource.LocationDataSource
import com.zillow.zillowmobile.domain.repository.LocationRepository

class LocationRepositoryImpl(private val dataSource: LocationDataSource):LocationRepository {

    override suspend fun getLocation(query: String) = dataSource.getLocation(query)

}