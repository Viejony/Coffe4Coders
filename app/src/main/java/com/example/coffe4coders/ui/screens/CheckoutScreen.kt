package com.example.coffe4coders.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.R
import com.example.coffe4coders.models.Product
import com.example.coffe4coders.ui.components.*
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme
import com.example.coffe4coders.utils.MockDataProvider

@Composable
fun CheckoutScreen(navController: NavController, product: Product) {

    val successOrderMsg = stringResource(id = R.string.finished_order_msg)
    val errorRequiredFieldsMsg = stringResource(id = R.string.error_not_complete_fields_msg)

    val cities = MockDataProvider.getListOfCities()
    var city by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var message by remember { mutableStateOf<String?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            CustomAppBar(
                title = stringResource(id = R.string.buy),
                navigationIcon = Icons.Filled.ArrowBack
            ) {
                navController.navigate("detail/${product.id}")
            }
        },
        content = {

            // Alert dialog for finished order
            Alert(
                title = stringResource(id = R.string.congratulations),
                message = message
            ) {
                navController.navigate("feed") {
                    launchSingleTop = true
                    popUpTo("feed")
                }
            }

            // Alert dialog for wrong fields
            Alert(
                title = stringResource(id = R.string.error_not_complete_fields_title),
                message = errorMessage
            ) {
                errorMessage = null
            }

            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

                // Product card header
                ProductCard(
                    product = product!!
                ) {}

                // Inputs
                Column(modifier = Modifier.padding(16.dp)) {
                    CustomTextField(
                        value = name,
                        placeholder = stringResource(id = R.string.complete_name)
                    ) {
                        name = it
                    }
                    CustomTextField(
                        value = email,
                        placeholder = stringResource(id = R.string.email)
                    ) {
                        email = it
                    }
                    CustomTextField(
                        value = phone,
                        placeholder = stringResource(id = R.string.phone_number)
                    ) {
                        phone = it
                    }
                    CustomTextField(
                        value = address,
                        placeholder = stringResource(id = R.string.residence_address)
                    ) {
                        address = it
                    }
                    DropdownTextField(cities, city, stringResource(id = R.string.city)) {
                        city = it
                    }
                }

                // Subtotal
                Column(modifier = Modifier.padding(16.dp)) {
                    Row {
                        Text(
                            stringResource(id = R.string.subtotal),
                            style = MaterialTheme.typography.caption
                        )
                        Text(
                            "$${product.price} ${product.currency}",
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.End,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                // Total
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "\$${product.price + 10} ${product.currency}",
                        style = MaterialTheme.typography.h5,
                        textAlign = TextAlign.Start
                    )
                    CustomButton(label = stringResource(id = R.string.finish_order)) {
                        // Validate all data
                        val inputFieldsVars = listOf(name, email, phone, address, city)
                        var correctFields = true
                        inputFieldsVars.forEach {
                            if(it.isEmpty()){
                                errorMessage = errorRequiredFieldsMsg
                                correctFields = false
                                return@CustomButton
                            }
                        }

                        // Put a text in message val will show the Alert component
                        if(correctFields) {
                            message = successOrderMsg
                        }
                    }
                }
            }
        })
}

private fun checkInputFieldAndShowAlert(
    inputString: String,
    errorRequiredFieldsMsg: String
): String? {
    if (inputString.isEmpty()) {
        return errorRequiredFieldsMsg
    }
    return null
}

@Preview(
    showBackground = true
)
@Composable
fun CheckoutScreenPreview() {
    val navController = rememberNavController()
    val productID = 0
    val product = MockDataProvider.getProductByID(0)
    Coffe4CodersTheme {
        if (product != null) {
            CheckoutScreen(navController, product = product)
        }
        else {
            NotFoundProduct(id = productID)
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun CheckoutScreenDarkPreview() {
    val navController = rememberNavController()
    val productID = 0
    val product = MockDataProvider.getProductByID(0)
    Coffe4CodersTheme {
        if (product != null) {
            CheckoutScreen(navController, product = product)
        }
        else {
            NotFoundProduct(id = productID)
        }
    }
}