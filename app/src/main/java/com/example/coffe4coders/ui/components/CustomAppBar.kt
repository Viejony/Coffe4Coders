package com.example.coffe4coders.ui.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.coffe4coders.ui.theme.Coffe4CodersTheme

typealias NavigationAction = () -> Unit

@Composable
fun CustomAppBar(
    title: String?,
    navigationIcon: ImageVector? = null,
    navigationAction: NavigationAction? = null
) {
    val titleText = title ?: ""
    TopAppBar(
        title = { Text(titleText) },
        navigationIcon = navigationIcon?.let {
            {
                IconButton(onClick = {
                    navigationAction?.let { it() }
                }) {
                    Icon(navigationIcon, contentDescription = "")
                }
            }
        },
        backgroundColor = MaterialTheme.colors.primary
    )
}

@Preview(
    showBackground = true
)
@Composable
fun CustomAppBarPreview() {
    Coffe4CodersTheme {
        CustomAppBar("Coffe4Coders", null, null)
    }
}