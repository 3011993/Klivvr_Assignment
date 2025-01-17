package com.example.klivvrassignment.presentation.main_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
fun CityItem(cityModel: CityModel, onItemClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()
        .padding(7.dp)
        .clickable { onItemClick() },
        elevation = CardDefaults.cardElevation(2.dp)){
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Text(
                text = "${cityModel.city},${cityModel.country}",
                modifier = modifier.fillMaxWidth(),
                fontSize = 20.sp,
            )
            Text(
                text = "Lon: ${cityModel.location.lon},Lat:${cityModel.location.lat}",
                modifier = modifier.fillMaxWidth().offset(x = 4.dp),
                fontSize = 14.sp
            )
        }
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
                    999993.00, 999032.00
                )
            ), {}
        )

    }
}