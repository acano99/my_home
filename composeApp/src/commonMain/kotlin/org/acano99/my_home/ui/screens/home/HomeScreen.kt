package org.acano99.my_home.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import androidx.navigation.NavController
import myhome.composeapp.generated.resources.Res
import myhome.composeapp.generated.resources.comidasPlanificadas
import myhome.composeapp.generated.resources.comprasPlanificadas
import myhome.composeapp.generated.resources.pagosPlanificados
import myhome.composeapp.generated.resources.today
import org.acano99.my_home.data.models.MenuType
import org.acano99.my_home.data.models.buyModel
import org.acano99.my_home.data.models.dayMenu
import org.acano99.my_home.ui.composables.HorizontalVerySmallSpacer
import org.acano99.my_home.ui.composables.ThemeCard
import org.acano99.my_home.ui.composables.ThemeFoodIcon
import org.acano99.my_home.ui.composables.ThemeIconHeader
import org.acano99.my_home.ui.composables.ThemeInvoice
import org.acano99.my_home.ui.composables.ThemeTopBar
import org.acano99.my_home.ui.composables.VerticalHigSpacer
import org.acano99.my_home.ui.composables.VerticalMinSpacer
import org.acano99.my_home.ui.composables.VerticalSmallSpacer
import org.acano99.my_home.ui.theme.mediumPadding
import org.acano99.my_home.ui.theme.minPadding
import org.acano99.my_home.ui.theme.smallPadding
import org.acano99.my_home.ui.theme.veryHighPadding
import org.acano99.my_home.ui.theme.verySmallPadding
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeScreen(navController: NavController? = null) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ThemeTopBar(title = "Home") },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.let {
                    navController?.navigate("day")
                }
            }) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = "")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
                .padding(mediumPadding)
                .verticalScroll(rememberScrollState())
        ) {
            ThemeCard(modifier = Modifier.fillMaxWidth()) {
                Header(
                    modifier = Modifier.fillMaxWidth().padding(start = smallPadding),
                    title = "12 de febrero"
                )
            }
            VerticalHigSpacer()
            ThemeCard(modifier = Modifier.fillMaxWidth()) {
                Foods()
            }
            VerticalHigSpacer()
            BuyList()
            VerticalHigSpacer()
            Pagos()
            Spacer(Modifier.height(veryHighPadding * 3))
        }
    }
}

@Composable
fun Header(modifier: Modifier = Modifier, title: String) {
    val header = stringResource(Res.string.today)
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier.size(48.dp),
            imageVector = Icons.Default.DateRange,
            contentDescription = null
        )
        HorizontalVerySmallSpacer()
        Text(text = buildAnnotatedString {
            withStyle(style = ParagraphStyle(lineHeight = 34.sp)) {
                withStyle(style = SpanStyle(fontWeight = FontWeight.W500)) {
                    append(header)
                }
                append("\n")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W700,
                        fontSize = 32.sp
                    )
                ) {
                    append(title)
                }
            }

        })
    }
}

@Composable
fun Foods() {
    Column(modifier = Modifier.padding(horizontal = smallPadding)) {
        ThemeIconHeader(
            imageVector = Icons.Default.ShoppingCart,
            title = stringResource(Res.string.comidasPlanificadas)
        )
        VerticalMinSpacer()
        if (dayMenu.isNotEmpty()) {
            dayMenu.map { menu ->
                Row(
                    modifier = Modifier.padding(bottom = verySmallPadding),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    when (menu.type) {
                        MenuType.Desayuno -> ThemeFoodIcon(
                            icon = Icons.Default.ShoppingCart,
                            backgroundColor = Color.Yellow
                        )

                        MenuType.Merienda -> ThemeFoodIcon(
                            icon = Icons.Default.ShoppingCart,
                            backgroundColor = Color.Cyan
                        )

                        MenuType.Almuerzo -> ThemeFoodIcon(
                            icon = Icons.Default.ShoppingCart,
                            backgroundColor = Color.Red
                        )

                        MenuType.Comida -> ThemeFoodIcon(icon = Icons.Default.ShoppingCart)
                        null -> ThemeFoodIcon(icon = Icons.Default.ShoppingCart)
                    }
                    HorizontalVerySmallSpacer()
                    Text(text = buildAnnotatedString {
                        withStyle(style = ParagraphStyle(lineHeight = 24.sp)) {
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.W500,
                                    fontSize = 18.sp
                                )
                            ) {
                                append("${menu.type}")
                            }
                            append("\n")
                            append(menu.food)
                        }
                    })
                }
            }
        } else {
            Text("No hay comidas planificadas")
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun BuyList() {
    ThemeCard {
        Column(modifier = Modifier.padding(horizontal = smallPadding)) {
            ThemeIconHeader(
                imageVector = Icons.Default.ShoppingCart,
                title = stringResource(Res.string.comprasPlanificadas)
            )
            VerticalMinSpacer()

            if (buyModel.items.isNotEmpty()) {
                FlowRow(modifier = Modifier.fillMaxWidth()) {

                    repeat(buyModel.items.size) { item ->
                        ElevatedCard(modifier = Modifier.padding(minPadding)) {
                            Text(
                                text = buyModel.items[item].name,
                                textDecoration = if (buyModel.items[item].comprado) TextDecoration.LineThrough else null,
                                fontWeight = FontWeight.W500,
                                fontSize = 18.sp,
                                lineHeight = 24.sp,
                                modifier = Modifier.padding(
                                    vertical = minPadding,
                                    horizontal = verySmallPadding
                                )
                            )
                        }
                    }
                }
            } else {
                Text("No hay compras planificadas")
            }
        }
    }
}

@Composable
fun Pagos() {
    ThemeCard {
        Column(modifier = Modifier.padding(horizontal = smallPadding)) {
            ThemeIconHeader(
                imageVector = Icons.Default.ShoppingCart,
                title = stringResource(Res.string.pagosPlanificados)
            )
            VerticalSmallSpacer()
            (1..3).map {
                ThemeInvoice(modifier = Modifier.fillMaxWidth().padding(horizontal = minPadding))
                VerticalSmallSpacer()
            }
        }
    }
}
