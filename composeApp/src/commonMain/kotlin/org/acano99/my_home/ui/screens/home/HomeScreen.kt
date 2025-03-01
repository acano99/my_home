package org.acano99.my_home.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.acano99.my_home.data.models.buyModel
import org.acano99.my_home.data.models.dayMenu
import org.acano99.my_home.ui.composables.MinSpacer
import org.acano99.my_home.ui.composables.SmallSpacer
import org.acano99.my_home.ui.composables.ThemeTopBar
import org.acano99.my_home.ui.composables.VeryHigSpacer
import org.acano99.my_home.ui.screens.common.CommonScreen
import org.acano99.my_home.ui.theme.mediumPadding
import org.acano99.my_home.ui.theme.smallPadding
import org.acano99.my_home.ui.theme.verySmallPadding

@Composable
fun HomeScreen() {
    CommonScreen {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { ThemeTopBar(title = "Home") },
            floatingActionButton = {
                FloatingActionButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.AddCircle, contentDescription = "")
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                Header(title = "12 de febrero")
                VeryHigSpacer()
                Foods()
                VeryHigSpacer()
                BuyList()
                VeryHigSpacer()
                Pagos()
                VeryHigSpacer()
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
}

@Composable
fun Foods() {
    Column(modifier = Modifier.padding(horizontal = smallPadding)) {
        Text("Comidas planificadas", fontSize = 24.sp, fontWeight = FontWeight.W500)
        MinSpacer()
        if (dayMenu.isNotEmpty()) {
            dayMenu.map { menu ->
                Text(text = buildAnnotatedString {
                    withStyle(style = ParagraphStyle(lineHeight = 24.sp)) {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.W500,
                                fontSize = 18.sp
                            )
                        ) {
                            append("${menu.type}: ")
                        }
                        append(menu.food)
                    }
                })
            }
        } else {
            Text("No hay comidas planificadas")
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BuyList() {
    Column(modifier = Modifier.padding(horizontal = smallPadding)) {
        Text("Compras planificadas", fontSize = 24.sp, fontWeight = FontWeight.W500)
        MinSpacer()

        if (buyModel.items.isNotEmpty()) {
            FlowRow(modifier = Modifier.fillMaxWidth()) {
                repeat(buyModel.items.size) {
                    Text(
                        text = buyModel.items[it].name,
                        textDecoration = if (buyModel.items[it].comprado) TextDecoration.LineThrough else null,
                        fontWeight = FontWeight.W500,
                        fontSize = 18.sp,
                        lineHeight = 24.sp,
                        modifier = Modifier.padding(end = mediumPadding)
                    )
                }
            }
        } else {
            Text("No hay compras planificadas")
        }
    }
}

@Composable
fun Pagos() {
    Column(modifier = Modifier.padding(horizontal = smallPadding)) {
        Text("Pagos planificados", fontSize = 24.sp, fontWeight = FontWeight.W500)
        SmallSpacer()
        (1..3).map {
            Box(
                modifier = Modifier.fillMaxWidth().border(
                    BorderStroke(width = 1.dp, color = Color.Black),
                    shape = RoundedCornerShape(verySmallPadding)
                )
            ) {
                Column(modifier = Modifier.padding(verySmallPadding)) {
                    Text("Factura XXXXX", fontSize = 18.sp, fontWeight = FontWeight.W500)
                    MinSpacer()
                    Text("150.00 Cup")
                }
            }
            SmallSpacer()
        }
    }
}
