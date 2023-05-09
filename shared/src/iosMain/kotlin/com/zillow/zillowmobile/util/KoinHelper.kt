package com.zillow.zillowmobile.util

import com.zillow.zillowmobile.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(getSharedModules())
    }
}
