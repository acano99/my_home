package org.acano99.my_home.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable

@Composable
fun ThemeBottomNavigationBar() {
    NavigationBar() {
        NavigationBarItem(
            onClick = {},
            icon = { Icon(imageVector = Icons.Rounded.Home, contentDescription = null) },
            selected = true
        )
        NavigationBarItem(
            onClick = {},
            icon = { Icon(imageVector = Icons.Rounded.Home, contentDescription = null) },
            selected = false
        )
        NavigationBarItem(
            onClick = {},
            icon = { Icon(imageVector = Icons.Rounded.Home, contentDescription = null) },
            selected = false
        )
        NavigationBarItem(
            onClick = {},
            icon = { Icon(imageVector = Icons.Rounded.Home, contentDescription = null) },
            selected = false
        )
    }
}