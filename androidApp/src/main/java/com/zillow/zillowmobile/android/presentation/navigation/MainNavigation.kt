package com.zillow.zillowmobile.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zillow.zillowmobile.android.entities.LocationSerializable
import com.zillow.zillowmobile.android.entities.mapToLocation
import com.zillow.zillowmobile.android.presentation.homes.HomeListView
import com.zillow.zillowmobile.android.presentation.search.SearchView
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString


const val SEARCH_LOCATION_ROUTE_STRING = "search_location"
const val PROPERTY_LIST_ROUTE_STRING = "property_list"

@Composable
fun MainNavigation(mainNavController: NavHostController? = null) {
    val navController = mainNavController ?: rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SEARCH_LOCATION_ROUTE_STRING
    ) {
        composable(SEARCH_LOCATION_ROUTE_STRING) {
            SearchView(navController)
        }
        composable("$PROPERTY_LIST_ROUTE_STRING/{json}") {
            val json = it.arguments?.getString("json")
            json?.let { locationJson ->
                val location =
                    Json.decodeFromString<LocationSerializable>(locationJson).mapToLocation()
                HomeListView(navController = navController, location = location)
            }

        }
    }
}