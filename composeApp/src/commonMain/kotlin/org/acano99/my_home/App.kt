package org.acano99.my_home

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.acano99.my_home.ui.screens.navigation.NavigationScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationScreen()
    }
}