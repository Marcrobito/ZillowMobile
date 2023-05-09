package com.zillow.zillowmobile.data.dao

import com.zillow.zillowmobile.data.remote.entities.queries.MapBounds
import com.zillow.zillowmobile.data.remote.entities.queries.SearchQueryState
import com.zillow.zillowmobile.domain.Home
import com.zillow.zillowmobile.domain.Location

private const val DISTANCE = 0.128061
fun LocationDAO.mapToLocation() = Location(
    regionId = metaData.regionId,
    name = display,
    type = resultType,
    regionType = metaData.regionType,
    city = metaData.city,
    county = metaData.county,
    state = metaData.state,
    country = metaData.country,
    lat = metaData.lat,
    lng = metaData.lng
)
fun List<LocationDAO>.mapToLocation() = map { it.mapToLocation() }


fun Location.mapToSearchQueryState() = SearchQueryState(
    usersSearchTerm = name,
    MapBounds(
        west = lng - DISTANCE,
        east = lng + DISTANCE,
        north = lat + DISTANCE,
        south = lat - DISTANCE
    )
)

fun HomeDao.mapToHome() = Home(
    id,
    imgSrc,
    carouselPhotos?.mapToPhoto(),
    price,
    beds,
    baths,
    statusText,
    address,
    brokerName
)
fun List<HomeDao>.mapToHome() = map { it.mapToHome() }

fun PhotoDao.mapToPhoto() = url
fun List<PhotoDao>.mapToPhoto() = map { it.mapToPhoto() }
