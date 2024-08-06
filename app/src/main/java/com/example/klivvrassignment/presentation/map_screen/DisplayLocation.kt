package com.example.klivvrassignment.presentation.map_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.klivvrassignment.domain.model.CityModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun DisplayLocation(city : CityModel,modifier: Modifier = Modifier){
    val location = LatLng(city.location.lat, city.location.lon)
    val cameraPositionState = rememberCameraPositionState{
        position = CameraPosition.fromLatLngZoom(location,12f)
    }
    GoogleMap(
        modifier = modifier,
        cameraPositionState = cameraPositionState
    ){
        Marker(
            state = MarkerState(position = location),
            title = "${city.city},${city.country}"
        )
    }

}