package com.zillow.zillowmobile.domain.datasource

import com.zillow.zillowmobile.domain.Home
import com.zillow.zillowmobile.domain.Location

interface HomeListDataSource {
    suspend fun getHomeList(location: Location): List<Home>
}