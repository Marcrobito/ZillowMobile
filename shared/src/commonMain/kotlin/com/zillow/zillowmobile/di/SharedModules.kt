package com.zillow.zillowmobile.di

import com.zillow.zillowmobile.data.datasource.RemoteHomeListDataSourceImpl
import com.zillow.zillowmobile.data.datasource.RemoteLocationDataSourceImpl
import com.zillow.zillowmobile.data.remote.ZillowApiService
import com.zillow.zillowmobile.data.remote.ZillowStaticApiService
import com.zillow.zillowmobile.data.repository.HomeListRepositoryImpl
import com.zillow.zillowmobile.data.repository.LocationRepositoryImpl
import com.zillow.zillowmobile.domain.datasource.HomeListDataSource
import com.zillow.zillowmobile.domain.interactors.SearchInteractor
import com.zillow.zillowmobile.domain.datasource.LocationDataSource
import com.zillow.zillowmobile.domain.interactors.HomeListInteractor
import com.zillow.zillowmobile.domain.repository.HomeListRepository
import com.zillow.zillowmobile.domain.repository.LocationRepository
import com.zillow.zillowmobile.domain.usecase.GetHomeListUseCase
import com.zillow.zillowmobile.domain.usecase.GetLocationUseCase
import com.zillow.zillowmobile.util.providesDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory<LocationDataSource> { RemoteLocationDataSourceImpl(get(), get()) }
    factory<HomeListDataSource> { RemoteHomeListDataSourceImpl(get(), get()) }
    factory { ZillowStaticApiService() }
    factory { ZillowApiService() }
}

private val utilityModule = module {
    factory { providesDispatcher() }
}

private val domainModule = module {
    single<LocationRepository> { LocationRepositoryImpl(get()) }
    single<HomeListRepository> { HomeListRepositoryImpl(get()) }
    factory { GetLocationUseCase() }
    factory { GetHomeListUseCase() }
    factory { SearchInteractor(get()) }
    factory { HomeListInteractor(get()) }
}

private val sharedModules = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModules