package com.zillow.zillowmobile.domain.datasource

import com.zillow.zillowmobile.domain.Location

interface LocationDataSource {
    suspend fun getLocation(query:String):List<Location>
}