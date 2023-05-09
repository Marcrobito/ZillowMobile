package com.zillow.zillowmobile.android.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zillow.zillowmobile.android.model.SearchLocationState
import com.zillow.zillowmobile.domain.Response
import com.zillow.zillowmobile.domain.interactors.SearchInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel(private val searchInteractor: SearchInteractor) : ViewModel() {

    private val _state = MutableStateFlow<SearchLocationState>(SearchLocationState())
    val state: StateFlow<SearchLocationState> get() = _state

    fun searchLocation(query: String) {
        viewModelScope.launch {
            val result = searchInteractor.getLocation(query)
            if (result is Response.Success)
                _state.value = _state.value.copy(locations = result.data)
        }
    }
}