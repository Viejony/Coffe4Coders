package com.example.coffe4coders.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.R
import com.example.coffe4coders.ui.components.CustomAppBar
import com.example.coffe4coders.ui.components.ProductCard
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme
import com.example.coffe4coders.utils.MockDataProvider

@Composable
fun FeedScreen(navController: NavController) {
    val context = LocalContext.current
    val list = MockDataProvider.getListOfProducts(context)

    Scaffold(
        topBar = {
            CustomAppBar(
                title = stringResource(id = R.string.app_name),
                navigationIcon = null,
                navigationAction = null
            )
        },
        content = {
            Surface(color = MaterialTheme.colors.background) {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    item {
                        Column(modifier = Modifier.padding(8.dp)) {
                            TitleText(title = stringResource(id = R.string.welcome))
                            BodyText(body = stringResource(id = R.string.welcome_msg))
                        }
                    }
                    items(list) { product ->
                        ProductCard(
                            product = product
                        ) {
                            navController.navigate("detail/${product.id}") {
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