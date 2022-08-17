package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.components.CountryIso
import com.example.coffe4coders.ui.components.CustomAppBar
import com.example.coffe4coders.ui.components.ProductCard
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun FeedScreen(navController: NavController) {
    val list: List<CountryIso> = listOf(
        CountryIso.COL,
        CountryIso.CRI,
        CountryIso.NIC,
        CountryIso.BRA
    )
    Scaffold(
        topBar = {
            CustomAppBar(title = "Coffe4Codders", navigationIcon = null, navigationAction = null)
        },
        content = {
            Surface(color = MaterialTheme.colors.background) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    item {
                        Column(modifier = Modifier.padding(8.dp)) {
                            TitleText(title = "Bienvenido")
                            BodyText(body = "Este es un texto de prueba")
                        }
                    }
                    items(list) { country ->
                        ProductCard(
                            name = "Cafe premium",
                            summary = "Cafe de alta calidad",
                            price = 18.0,
                            currency = "USD",
                            country = country
                        ) {
                            navController.navigate("detail/${country.iso}") {
                                launchSingleTop = true
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview(
    showBackground = true
)
@Composable
fun FeedScreenPreview() {
    val navController = rememberNavController()
    Coffe4CodersTheme() {
        FeedScreen(navController)
    }
}