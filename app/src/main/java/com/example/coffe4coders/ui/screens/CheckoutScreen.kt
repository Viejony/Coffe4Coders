package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.components.*
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme
import com.example.coffe4coders.utils.MockDataProvider

@Composable
fun CheckoutScreen(navController: NavController, countryIso: CountryIso) {
    val cities = MockDataProvider.getListOfCities()
    var city by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            CustomAppBar(title = null, navigationIcon = Icons.Filled.ArrowBack) {
                navController.navigate("detail/${countryIso.iso}")
            }
        },
        content = {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                ProductCard(
                    name = "Café de Colombia",
                    summary = "Café de las montañas",
                    price = 35.0,
                    currency = "USD",
                    country = countryIso
                ) {}

                Column(modifier = Modifier.padding(16.dp)) {
                    CustomTextField(value = name, placeholder = "Nombre completo") {
                        name = it
                    }
                    CustomTextField(value = email, placeholder = "Correo electrónico") {
                        email = it
                    }
                    CustomTextField(value = phone, placeholder = "Número telefónico") {
                        phone = it
                    }
                    CustomTextField(value = address, placeholder = "Dirección de residencia") {
                        address = it
                    }
                    DropdownTextField(cities, city, "Ciudad") {
                        city = it
                    }
                }

                Column(modifier = Modifier.padding(16.dp)) {
                    Row {
                        Text("Subtotal", style = MaterialTheme.typography.caption)
                        Text(
                            "$ 35 USD",
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        "$ 45 USD",
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Start
                    )
                    CustomButton(label = "Finalizar pedido") {
                        
                    }
                }
            }
        })
}

@Preview(
    showBackground = true
)
@Composable
fun CheckoutScreenPreview() {
    val navController = rememberNavController()
    Coffe4CodersTheme {
        CheckoutScreen(navController, CountryIso.COL)
    }
}