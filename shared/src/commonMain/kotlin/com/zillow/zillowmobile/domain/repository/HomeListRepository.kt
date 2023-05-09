package com.zillow.zillowmobile.domain.repository

import com.zillow.zillowmobile.domain.Home
import com.zillow.zillowmobile.domain.Location

interface HomeListRepository {
    suspend fun getHomeList(location: Location): List<Home>
}