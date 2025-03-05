package org.acano99.my_home.ui.screens.common

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ErrorScreen(modifier: Modifier, error: String) =
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(error)
    }