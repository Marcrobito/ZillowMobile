package com.zillow.zillowmobile.android.di

import com.zillow.zillowmobile.android.presentation.homes.HomeListViewModel
import com.zillow.zillowmobile.android.presentation.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SearchViewModel(get()) }
    viewModel { HomeListViewModel(get()) }
}