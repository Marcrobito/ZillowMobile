package com.zillow.zillowmobile.data.remote.entities.queries

@kotlinx.serialization.Serializable
data class SearchQueryState(
    val usersSearchTerm: String,
    val mapBounds: MapBounds,
    /*val isMapVisible: Boolean = false,
    val filterState: FilterState = FilterState(),
    val isListVisible: Boolean = true*/
)

@kotlinx.serialization.Serializable
data class MapBounds(
   val west: Double,
   val east: Double,
   val south: Double,
   val north: Double,
)
/*
@kotlinx.serialization.Serializable
data class FilterState(
   val sortSelection: SortSelection = SortSelection(),
   val isAllHomes: IsAllHomes = IsAllHomes()
)

@kotlinx.serialization.Serializable
data class SortSelection(val value: String = "globalrelevanceex")

@kotlinx.serialization.Serializable
data class IsAllHomes(val value: Boolean = true)

//"west":-95.920533,"east":-95.683221,"south":29.694508,"north":29.95063}
0.237312
0.118656
0.256122
0.128061
*/