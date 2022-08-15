package com.example.coffe4coders.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coffe4coders.R

@Composable
fun ProductCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { }
            .size(480.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.co),
            contentDescription = null)
    }
}

@Preview(
    showBackground = true
)
@Composable
fun ProductCardPreview(){
    ProductCard()
}