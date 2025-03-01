package org.acano99.my_home.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.acano99.my_home.ui.composables.ThemeTopBar
import org.acano99.my_home.ui.screens.common.CommonScreen
import org.acano99.my_home.ui.theme.highPadding
import org.acano99.my_home.ui.theme.smallPadding
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun HomeScreen() {
    CommonScreen {
        val scroll = rememberScrollState()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { ThemeTopBar(title = "Home") }
        ) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                Header(title = "12 de febrero")
                Comidas()
                Text("Compras")
                Text("No hay compras planificadas para hoy")
                Text("Pagos")
                Text("No hay pagos planificados")
            }
        }
    }
}

@Composable
fun Header(title: String) {
    Text(
        title,
        fontSize = 32.sp,
        fontWeight = FontWeight.W700,
        modifier = Modifier.padding(start = smallPadding)
    )
    Spacer(Modifier.height(highPadding))
}

@Composable
fun Comidas() {
    Column(modifier = Modifier.padding(horizontal = smallPadding)) {
        Text("Comidas planificadas", fontSize = 24.sp, fontWeight = FontWeight.W500)
        Text("No hay comidas planificadas para hoy")
    }
}
