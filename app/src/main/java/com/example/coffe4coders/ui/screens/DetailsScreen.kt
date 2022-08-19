package com.example.coffe4coders.ui.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.R
import com.example.coffe4coders.models.Product
import com.example.coffe4coders.ui.components.CountryIso
import com.example.coffe4coders.ui.components.CustomAppBar
import com.example.coffe4coders.ui.components.CustomButton
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme
import com.example.coffe4coders.utils.MockDataProvider

@Composable
fun DetailsScreen(navController: NavController, product: Product) {
    val countryIso = CountryIso.valueOf(product.countryISO)
    Scaffold(
        topBar = {
            CustomAppBar(title = product.name, navigationIcon = Icons.Filled.ArrowBack) {
                navController.navigate("feed") {
                    popUpTo("feed")
                }
            }
        },
        content = {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                ) {
                    Image(
                        painter = painterResource(id = countryIso.backgroundImage),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                    Surface(
                        modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                        color = countryIso.surfaceColor.copy(alpha = 0.2f),
                        content = {}
                    )
                }

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    TitleText(title = product.name)
                    Text(text = product.summary, style = MaterialTheme.typography.caption)
                    Spacer(modifier = Modifier.height(24.dp))
                    BodyText(body = product.description)
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "$${product.price} ${product.currency}",
                            style = MaterialTheme.typography.h5,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxHeight()
                        )
                        CustomButton(label = stringResource(id = R.string.continue_title)) {
                            navController.navigate("checkout/${product.id}") {
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
fun DetailsScreenPreview() {
    val context = LocalContext.current

    Coffe4CodersTheme() {
        val navController = rememberNavController()
        val productID = 0
        val product = MockDataProvider.getProductByID(context, productID)

        if (product != null) {
            DetailsScreen(navController, product = product)
        }
        else{
            NotFoundProduct(id = productID)
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES,
    locale = "es"
)
@Composable
fun DetailsScreenDarkPreview() {
    val context = LocalContext.current

    Coffe4CodersTheme {
        val navController = rememberNavController()
        val productID = 2
        val product = MockDataProvider.getProductByID(context, productID)

        if (product != null) {
            DetailsScreen(navController, product = product)
        }
        else{
            NotFoundProduct(id = productID)
        }
    }
}