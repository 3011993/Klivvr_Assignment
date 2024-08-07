package com.example.klivvrassignment.presentation.main_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.klivvrassignment.data.node_trie.Trie
import com.example.klivvrassignment.domain.model.CityModel
import com.example.klivvrassignment.domain.model.Location
import com.example.klivvrassignment.presentation.main_screen.components.CityItem
import com.example.klivvrassignment.presentation.main_screen.components.SearchBar

@Composable
fun MainScreen(
    cityList: List<CityModel>,
    onItemClicked: (CityModel) -> Unit,
    modifier: Modifier = Modifier,
) {
    val trie = remember { Trie.preprocessCities(cityList) }
    var displayedCities by remember { mutableStateOf(cityList) }
    var searchText by remember { mutableStateOf("") }
    Scaffold { innerPadding ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            item {
                SearchBar(
                    searchText = searchText,
                    onSearchTextChange = { newText ->
                        searchText = newText
                        displayedCities = if (newText.isBlank()) {
                            cityList
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
        MainScreen(cityList = cities, {})
    }
}