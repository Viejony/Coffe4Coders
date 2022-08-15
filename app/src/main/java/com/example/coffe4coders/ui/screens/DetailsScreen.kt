package com.example.coffe4coders.ui.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailsScreen(navController: NavController){
    Text("Hola soy un detalle", style = MaterialTheme.typography.body1)
}

@Preview(
    showBackground = true
)
@Composable
fun DetailsScreenPreview() {
    val navController = rememberNavController()
    DetailsScreen(navController)
}