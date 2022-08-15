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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffe4coders.R
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme
import com.example.coffe4coders.ui.theme.PlatziBlue
import com.example.coffe4coders.ui.theme.PlatziGreen

enum class CountryIso(val backgroundImage: Int, val flagImage: Int, val surfaceColor: Color) {
    COL(R.drawable.co, R.drawable.flagco, PlatziBlue),
    BRA(R.drawable.br, R.drawable.flagbr, PlatziBlue),
    CRI(R.drawable.ri, R.drawable.flagri, PlatziGreen),
    NIC(R.drawable.ni, R.drawable.flagni, PlatziGreen)
}

@Composable
fun ProductCard(
    name: String,
    summary: String,
    price: Double,
    currency: String,
    country: CountryIso,
    selected: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                selected()
            }
            .size(480.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.small
    ) {
        Image(
            painter = painterResource(id = country.backgroundImage),
            contentDescription = null
        )
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = country.surfaceColor.copy(alpha = 0.2f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                Text("$name", style = MaterialTheme.typography.h4)
                Text("$summary", style = MaterialTheme.typography.body1)
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
                            "$$price $currency",
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
    Coffe4CodersTheme() {
        ProductCard(
            "Cafe de Colombia",
            "Cafe de la montaña",
            35.0,
            "USD",
            CountryIso.COL
        ){}
    }
}