package com.zillow.zillowmobile.android.entities

import com.zillow.zillowmobile.domain.Home

data class HomeListState(
    val isLoading:Boolean = false,
    val error:String? = null,
    val data:List<Home> = emptyList()
)
