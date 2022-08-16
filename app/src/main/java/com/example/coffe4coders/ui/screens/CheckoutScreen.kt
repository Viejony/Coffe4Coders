package com.example.coffe4coders.ui.screens

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffe4coders.ui.components.CustomTextField
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun CheckoutScreen(){
    var name by remember{ mutableStateOf("")}
    CustomTextField(value = name, placeholder = "Nombre"){
        name = it
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CheckoutScreenPreview(){
    Coffe4CodersTheme {
        CheckoutScreen()
    }
}