package com.example.klivvrassignment.presentation.main_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.klivvrassignment.data.Trie
import com.example.klivvrassignment.domain.model.CityModel
import com.example.klivvrassignment.domain.model.Location
import com.example.klivvrassignment.presentation.UiState
import com.example.klivvrassignment.presentation.main_screen.components.CityItem
import com.example.klivvrassignment.presentation.main_screen.components.SearchBar

@Composable
fun MainScreen(
    cityList: UiState<List<CityModel>>,
    onItemClicked: (CityModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    var trie by remember { mutableStateOf(Trie()) }
    var displayedCities by remember { mutableStateOf<List<CityModel>>(emptyList()) }
    var searchText by remember { mutableStateOf("") }
    LaunchedEffect(cityList) {
        if (cityList is UiState.Success){
            trie = Trie.preprocessCities(cityList.data)
            displayedCities = cityList.data
        }
    }
    Scaffold { innerPadding ->
        Box(modifier = modifier.fillMaxSize()) {
            when(cityList){
                is UiState.Error -> {
                    Text(
                        text = cityList.message?: "An unexpected error occurred",
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)

                    )
                }
                is UiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
                is UiState.Success -> {
                    LazyColumn(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        Log.d("MainScreen", " Lazy received")

                        item {
                            SearchBar(
                                searchText = searchText,
                                onSearchTextChange = { newText ->
                                    searchText = newText
                                    displayedCities = if (newText.isBlank()) {
                                        cityList.data
                                    } else {
                                        trie.searchPrefix(newText)
                                    }
                                }
                            )
                        }
                        items(displayedCities) { city ->
                            CityItem(cityModel = city,
                                onItemClick = { onItemClicked(city) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    val cities = mutableListOf<CityModel>()
    val firstCity = CityModel(
        id = 0, city = "Cairo", country = "Eg", location = Location(
            lon = 993.00, lat = 933.00
        )
    )
    val secondCity = CityModel(
        id = 1, city = "Giza", country = "Eg", location = Location(
            lon = 556.00, lat = 55.003
        )
    )
    val thirdCity = CityModel(
        id = 0, city = "Mansoura", country = "Eg", location = Location(
            lon = 332.00, lat = 212.00
        )
    )
    cities.add(firstCity)
    cities.add(secondCity)
    cities.add(thirdCity)

    MaterialTheme {
        MainScreen(cityList = UiState.Success(cities), {})
    }
}