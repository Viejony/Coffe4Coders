package com.example.coffe4coders.ui.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun NotFoundProduct(id: Int){
    Text(text = "No se puede encontrar el producto con el ID $id", style = MaterialTheme.typography.h3)
}

@Preview(
    showBackground = true
)
@Composable
fun NotFoundProductPreview(){
    Coffe4CodersTheme {
        NotFoundProduct(69)
    }
}