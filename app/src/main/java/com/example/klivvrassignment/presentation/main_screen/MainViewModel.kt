package com.example.klivvrassignment.presentation.main_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.klivvrassignment.common.Resources
import com.example.klivvrassignment.data.Trie
import com.example.klivvrassignment.domain.model.CityModel
import com.example.klivvrassignment.domain.repo.CityRepository
import com.example.klivvrassignment.presentation.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for the main screen, responsible for fetching and managing the list of cities.
 *
 * @param repo The [CityRepository] used to fetch city data.
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val repo: CityRepository) : ViewModel() {
    private val _cityList = MutableStateFlow<UiState<List<CityModel>>>(UiState.Loading())
    val cityList = _cityList.asStateFlow()

    private var trie: Trie? = null

    init {
        getCities()
    }
    /**
     * Fetches the list of cities from the repository and updates the [_cityList] state accordingly.
     */
    private fun getCities() {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getCities().collect { result ->
                when (result) {
                    is Resources.Error -> {
                        _cityList.value = UiState.Error(message = result.message)
                    }

                    is Resources.Loading -> {
                        _cityList.value = UiState.Loading()
                    }

                    is Resources.Success -> {
                        _cityList.value = UiState.Success(data = result.data ?: emptyList())
                        trie = Trie.preprocessCities(result.data?: emptyList())
                    }
                }
            }
        }
    }
    fun searchCities(prefix: String): List<CityModel> {
        return trie?.searchPrefix(prefix) ?: emptyList()
    }
}
