package com.example.klivvrassignment.presentation
/**
 * Represents the different screens in the application.
 *
 * @property route The route associated with the screen, used for navigation.*/
sealed class Screen(val route : String){
    object CitiesScreen : Screen("cities_screen")
    object DisplayMapScreen : Screen("display_map_screen")
}
