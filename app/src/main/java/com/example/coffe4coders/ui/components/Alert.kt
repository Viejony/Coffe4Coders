package com.example.coffe4coders.ui.components

import android.content.res.Configuration
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme

@Composable
fun Alert(title: String, message: String?, onClose: () -> Unit) {
    if (message != null) {
        AlertDialog(
            onDismissRequest = { onClose() },
            title = {
                Text(text = title, style = MaterialTheme.typography.h5)
            },
            text = {
                Text(text = message)
            },
            confirmButton = {
                Button(onClick = { onClose() }) {
                    Text(text = "OK")
                }
            }
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun AlertPreview() {
    Coffe4CodersTheme {
        Alert("Test Title", "This is a test message", {})
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun AlertDarkPreview() {
    Coffe4CodersTheme {
        Alert("Test Title", "This is a test message", {})
    }
}