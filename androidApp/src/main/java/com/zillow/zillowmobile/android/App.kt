package com.zillow.zillowmobile.android

import android.app.Application
import com.zillow.zillowmobile.android.di.appModule
import com.zillow.zillowmobile.data.datasource.RemoteHomeListDataSourceImpl
import com.zillow.zillowmobile.data.remote.ZillowApiService
import com.zillow.zillowmobile.data.repository.HomeListRepositoryImpl
import com.zillow.zillowmobile.di.getSharedModules
import com.zillow.zillowmobile.domain.repository.HomeListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}
