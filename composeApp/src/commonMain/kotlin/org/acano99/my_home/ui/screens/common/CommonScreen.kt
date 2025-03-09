package org.acano99.my_home.ui.screens.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.acano99.my_home.ui.composables.ThemeBottomNavigationBar
import org.acano99.my_home.ui.composables.ThemeTopBar
import org.acano99.my_home.ui.theme.mediumPadding

@Composable
fun CommonScreen(content: @Composable ColumnScope.() -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ThemeTopBar(title = "Comidas") },
        floatingActionButton = {},
        bottomBar = { ThemeBottomNavigationBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
                .padding(mediumPadding)
                .verticalScroll(rememberScrollState()), content = content
        )
    }
}

