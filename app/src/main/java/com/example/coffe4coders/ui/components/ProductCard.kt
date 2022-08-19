package com.example.coffe4coders.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffe4coders.R
import com.example.coffe4coders.models.Product
import com.example.coffe4coders.ui.screens.NotFoundProduct
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme
import com.example.coffe4coders.ui.theme.PlatziBlue
import com.example.coffe4coders.ui.theme.PlatziGreen
import com.example.coffe4coders.utils.MockDataProvider

enum class CountryIso(
    val iso: String,
    val backgroundImage: Int,
    val flagImage: Int,
    val surfaceColor: Color
) {
    COL("COL", R.drawable.co, R.drawable.flagco, PlatziBlue),
    BRA("BRA", R.drawable.br, R.drawable.flagbr, PlatziBlue),
    CRI("CRI", R.drawable.ri, R.drawable.flagri, PlatziGreen),
    NIC("NIC", R.drawable.ni, R.drawable.flagni, PlatziGreen)
}

@Composable
fun ProductCard(
    product: Product,
    selected: () -> Unit
) {
    val country = CountryIso.valueOf(product.countryISO) ?: CountryIso.COL
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                selected()
            }
            .size(480.dp, 320.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Image(
            painter = painterResource(id = country.backgroundImage),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = country.surfaceColor.copy(alpha = 0.2f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text("${product.name}", style = MaterialTheme.typography.h4)
                Text(
                    "${product.summary}",
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Justify
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row() {
                        Image(
                            painter = painterResource(id = country.flagImage),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                        Text(
                            "$${product.price} ${product.currency}",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.h4
                        )
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
fun ProductCardPreview() {
    val context = LocalContext.current
    val productID = 0
    val product = MockDataProvider.getProductByID(context, productID)

    Coffe4CodersTheme() {
        if (product != null) {
            ProductCard(product!!) {}
        }
        else {
            NotFoundProduct(id = productID)
        }
    }
}