package org.acano99.my_home.ui.screens.day

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.acano99.my_home.ui.composables.ThemeTopBar

@Composable
fun DayScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ThemeTopBar(title = "Day") },
    ) { }
}