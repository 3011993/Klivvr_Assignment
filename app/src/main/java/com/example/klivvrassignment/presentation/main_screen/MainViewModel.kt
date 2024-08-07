package com.example.klivvrassignment.presentation.main_screen

import androidx.lifecycle.ViewModel
import com.example.klivvrassignment.domain.model.CityModel
import com.example.klivvrassignment.domain.repo.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: CityRepository) : ViewModel() {
    private val _cities = MutableStateFlow<List<CityModel>>(emptyList())
    val cities = _cities.asStateFlow()

    init {
        getCities()
    }

    private fun getCities() {
        _cities.value = repo.getCities()
    }
}
