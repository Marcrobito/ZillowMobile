package com.zillow.zillowmobile.data.repository

import com.zillow.zillowmobile.domain.Location
import com.zillow.zillowmobile.domain.datasource.HomeListDataSource
import com.zillow.zillowmobile.domain.repository.HomeListRepository

class HomeListRepositoryImpl(private val dataSource: HomeListDataSource) : HomeListRepository {
    override suspend fun getHomeList(location: Location) = dataSource.getHomeList(location)
}