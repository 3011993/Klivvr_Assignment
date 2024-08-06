package com.example.klivvrassignment.presentation

sealed class Screen(val route : String){
    object CitiesScreen : Screen("cities_screen")
    object DisplayMapScreen : Screen("display_map_screen")
}
