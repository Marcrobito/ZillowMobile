package com.zillow.zillowmobile.util

import kotlinx.coroutines.CoroutineDispatcher

interface Dispatcher {
    val io: CoroutineDispatcher
}


expect fun providesDispatcher(): Dispatcher