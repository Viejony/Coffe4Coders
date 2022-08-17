package com.example.coffe4coders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.components.CountryIso
import com.example.coffe4coders.ui.screens.CheckoutScreen
import com.example.coffe4coders.ui.screens.DetailsScreen
import com.example.coffe4coders.ui.screens.FeedScreen
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationHost()
        }
    }
}

@Composable
fun NavigationHost() {
    val navController = rememberNavController()
    Coffe4CodersTheme() {
        Column {
            Surface(color = MaterialTheme.colors.background) {
                NavHost(navController = navController, startDestination = "feed") {
                    composable(route = "feed") {
                        FeedScreen(navController)
                    }
                    composable(route = "detail/{countryIso}") { backStackEntry ->
                        val countryIsoString =
                            backStackEntry.arguments?.getString("countryIso") ?: "COL"
                        val countryIso = CountryIso.valueOf(countryIsoString)
                        DetailsScreen(navController, countryIso)
                    }
                    composable(route = "checkout/{countryIso}") { backStackEntry ->
                        val countryIsoString =
                            backStackEntry.arguments?.getString("countryIso") ?: "COL"
                        val countryIso = CountryIso.valueOf(countryIsoString)
                        CheckoutScreen(navController, countryIso)
                    }
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun MainPreview() {
    NavigationHost()
}