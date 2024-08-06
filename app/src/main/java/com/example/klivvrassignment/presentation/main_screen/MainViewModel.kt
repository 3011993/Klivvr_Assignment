package com.example.klivvrassignment.presentation.main_screen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.klivvrassignment.data.repo.CityRepositoryImpl
import com.example.klivvrassignment.domain.model.CityModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(private val context: Context) : ViewModel() {
    val _cities = MutableStateFlow<List<CityModel>>(emptyList())
    val cities = _cities.asStateFlow()

    private val repo = CityRepositoryImpl()
    init {
        getCities()
    }
    private fun getCities() {
        _cities.value = repo.getCities(context = context)
    }
}
class MainViewModelFactory(private val context: Context) : ViewModelProvider.Factory {override fun <T : ViewModel> create(modelClass: Class<T>): T {
    if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
        @Suppress("UNCHECKED_CAST")
        return MainViewModel(context) as T
    }
    throw IllegalArgumentException("Unknown ViewModel class")
}
}