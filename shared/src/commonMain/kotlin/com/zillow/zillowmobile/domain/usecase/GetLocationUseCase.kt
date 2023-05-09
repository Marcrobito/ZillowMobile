package com.zillow.zillowmobile.domain.usecase

import com.zillow.zillowmobile.domain.repository.LocationRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetLocationUseCase : KoinComponent {
    private val repository: LocationRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(query: String) = repository.getLocation(query)
}