package com.example.klivvrassignment.presentation.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.klivvrassignment.domain.model.CityModel
import com.example.klivvrassignment.domain.model.Location
import com.example.klivvrassignment.ui.theme.KlivvrAssignmentTheme

@Composable
fun CityItem(cityModel: CityModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(2.dp)
    ) {
        Text(
            text = "${cityModel.city},${cityModel.country}",
            modifier = modifier.fillMaxWidth(),
            fontSize = 20.sp,
        )
        Text(
            text = "Lon: ${cityModel.location.lon},Lat:${cityModel.location.lat}",
            modifier = modifier.fillMaxWidth(),
            fontSize = 14.sp
        )
    }

}

@Preview
@Composable
fun CityItemPreview() {
    KlivvrAssignmentTheme {
        CityItem(
            CityModel(
                "Au", "Sydney",
                id = 0,
                location = Location(
                    999993.00 ,999032.00
                )
            )
        )

    }
}