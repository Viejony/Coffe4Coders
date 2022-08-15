package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.components.CountryIso

@Composable
fun DetailsScreen(navController: NavController, countryIso: CountryIso) {
    Column() {
        Text("Hola soy un producto de ${countryIso.iso}", style = MaterialTheme.typography.h3)
        Button(onClick = {
            navController.navigate("feed"){
                popUpTo("feed")
            }
        }) {
            Text(text = "Volver")
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun DetailsScreenPreview() {
    val navController = rememberNavController()
    DetailsScreen(navController, CountryIso.COL)
}