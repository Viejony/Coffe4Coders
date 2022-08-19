package com.example.coffe4coders.ui.components

import android.content.res.Configuration
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
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
    val titleText = if(title == null || title.isEmpty()) "Coffe4Coders" else title
    TopAppBar(
        title = { Text(titleText) },
        navigationIcon = navigationIcon?.let {
            {
                IconButton(onClick = {
                    navigationAction?.let { it() }
                }) {
                    Icon(navigationIcon, contentDescription = "", tint = Color.White)
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

@Preview(
    showBackground = true
)
@Composable
fun CustomAppBarPreview2() {
    Coffe4CodersTheme {
        CustomAppBar("Cafe de Colombia", navigationIcon = Icons.Filled.ArrowBack, navigationAction = null)
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CustomAppBarPreview3() {
    Coffe4CodersTheme {
        CustomAppBar(null, navigationIcon = Icons.Filled.ArrowBack, navigationAction = null)
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CustomAppBarPreview4() {
    Coffe4CodersTheme {
        CustomAppBar("", navigationIcon = Icons.Filled.ArrowBack, navigationAction = null)
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun CustomAppBarDarkPreview5() {
    Coffe4CodersTheme {
        CustomAppBar("DarkMode", navigationIcon = Icons.Filled.ArrowBack, navigationAction = null)
    }
}