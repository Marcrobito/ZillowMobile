package com.zillow.zillowmobile.domain.repository

import com.zillow.zillowmobile.domain.Location

interface LocationRepository {
    suspend fun getLocation(query:String):List<Location>
}