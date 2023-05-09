package com.zillow.zillowmobile.domain.usecase

import com.zillow.zillowmobile.domain.Location
import com.zillow.zillowmobile.domain.repository.HomeListRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetHomeListUseCase : KoinComponent {
    private val repository: HomeListRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(location: Location) = repository.getHomeList(location)
}