package com.zillow.zillowmobile.android.presentation.homes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zillow.zillowmobile.android.entities.HomeListState
import com.zillow.zillowmobile.domain.Location
import com.zillow.zillowmobile.domain.Response
import com.zillow.zillowmobile.domain.interactors.HomeListInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeListViewModel(private val interactor: HomeListInteractor) : ViewModel() {

    private val _state = MutableStateFlow(HomeListState())
    val state: StateFlow<HomeListState> get() = _state

    fun fetchHomeList(location: Location) {
        _state.value = _state.value.copy(isLoading = true)
        viewModelScope.launch {
            val result = interactor.getHomeList(location)
            _state.value = _state.value.copy(isLoading = false)
            _state.value = when (result) {
                is Response.Success -> _state.value.copy(data = result.data)
                is Response.Error -> _state.value.copy(error = result.error.message ?: "Error")
            }
        }
    }
}