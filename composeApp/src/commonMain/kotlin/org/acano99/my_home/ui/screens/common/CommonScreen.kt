package org.acano99.my_home.ui.screens.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CommonScreen(content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        content = content)
}