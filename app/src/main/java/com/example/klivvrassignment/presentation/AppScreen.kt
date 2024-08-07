package com.example.klivvrassignment.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.klivvrassignment.domain.model.CityModel
import com.example.klivvrassignment.presentation.main_screen.MainScreen
import com.example.klivvrassignment.presentation.main_screen.MainViewModel
import com.example.klivvrassignment.presentation.map_screen.DisplayLocation
import com.example.klivvrassignment.ui.theme.KlivvrAssignmentTheme

@Composable
fun AppScreen() {
    KlivvrAssignmentTheme {

        Surface(color = MaterialTheme.colorScheme.background) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.CitiesScreen.route,
            ) {
                composable(Screen.CitiesScreen.route) {
                    val viewModel: MainViewModel = hiltViewModel()
                    val cities by viewModel.cities.collectAsState()
                    MainScreen(cityList = cities, onItemClicked = { city ->
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            key = "city",
                            value = city
                        )
                        navController.navigate(Screen.DisplayMapScreen.route)
                    })
                }
                composable(
                    Screen.DisplayMapScreen.route
                ) {
                    val specificCity =
                        navController.previousBackStackEntry?.savedStateHandle?.get<CityModel>("city")
                    specificCity?.let {
                        DisplayLocation(specificCity)
                    }
                }
            }
        }
    }

}
