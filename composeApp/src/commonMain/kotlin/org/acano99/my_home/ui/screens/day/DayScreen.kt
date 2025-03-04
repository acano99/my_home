package org.acano99.my_home.ui.screens.day

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myhome.composeapp.generated.resources.Res
import myhome.composeapp.generated.resources.comidasPlanificadas
import myhome.composeapp.generated.resources.comprasPlanificadas
import myhome.composeapp.generated.resources.pagosPlanificados
import myhome.composeapp.generated.resources.planificado
import myhome.composeapp.generated.resources.presupuesto
import myhome.composeapp.generated.resources.restante
import org.acano99.my_home.ui.composables.HorizontalVerySmallSpacer
import org.acano99.my_home.ui.composables.ThemeCard
import org.acano99.my_home.ui.composables.ThemeElevatedButton
import org.acano99.my_home.ui.composables.ThemeFoodIcon
import org.acano99.my_home.ui.composables.ThemeIconHeader
import org.acano99.my_home.ui.composables.ThemeInvoice
import org.acano99.my_home.ui.composables.ThemeTopBar
import org.acano99.my_home.ui.composables.VerticalHigSpacer
import org.acano99.my_home.ui.composables.VerticalMediumSpacer
import org.acano99.my_home.ui.composables.VerticalSmallSpacer
import org.acano99.my_home.ui.theme.mediumPadding
import org.acano99.my_home.ui.theme.minPadding
import org.acano99.my_home.ui.theme.smallPadding
import org.acano99.my_home.ui.theme.veryHighPadding
import org.acano99.my_home.ui.theme.verySmallPadding
import org.jetbrains.compose.resources.stringResource


@Composable
fun DayScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ThemeTopBar(title = "Day") },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding).padding(mediumPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Presupuesto()
            VerticalHigSpacer()
            Comidas()
            VerticalHigSpacer()
            Compras()
            VerticalHigSpacer()
            Pagos()
            Spacer(Modifier.height(veryHighPadding * 3))
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
            ThemeElevatedButton()
        }
    }
}

@Composable
fun Compras() {
    ThemeCard {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = minPadding)) {
            ThemeIconHeader(
                imageVector = Icons.Rounded.ShoppingCart,
                title = stringResource(Res.string.comprasPlanificadas)
            )
            VerticalMediumSpacer()
            (1..2).map {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Yuca ($it lb)")
                    Text("${it * 35} Cup")
                }
            }
            HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp), color = Color.Black)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Total")
                Text("5500 Cup")
            }
            VerticalMediumSpacer()
            ThemeElevatedButton()
        }
    }
}

@Composable
fun Comidas() {
    ThemeCard {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = minPadding)) {
            ThemeIconHeader(
                imageVector = Icons.Rounded.ShoppingCart,
                title = stringResource(Res.string.comidasPlanificadas)
            )
            VerticalMediumSpacer()
            Row(
                modifier = Modifier.padding(bottom = verySmallPadding),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ThemeFoodIcon(icon = Icons.Rounded.ShoppingCart)
                HorizontalVerySmallSpacer()
                Text(text = buildAnnotatedString {
                    withStyle(style = ParagraphStyle(lineHeight = 24.sp)) {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.W500,
                                fontSize = 18.sp
                            )
                        ) {
                            append("Comida ")
                        }
                        append("\n")
                        append("Arroz congris, pollo frito, yuca")
                    }
                })
            }
            ThemeElevatedButton()
        }
    }
}

@Composable
private fun Presupuesto() {
    val presupuesto = stringResource(Res.string.presupuesto)
    val planificado = stringResource(Res.string.planificado)
    val restante = stringResource(Res.string.restante)

    ThemeCard {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = minPadding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(style = ParagraphStyle(lineHeight = 32.sp)) {
                        append(presupuesto)
                        append("\n")
                        withStyle(
                            style = SpanStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.W700
                            )
                        ) {
                            append("3500 Cup")
                        }
                    }
                    withStyle(style = ParagraphStyle(lineHeight = 32.sp)) {
                        append(planificado)
                        append("\n")
                        withStyle(
                            style = SpanStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.W700
                            )
                        ) {
                            append("3500 Cup")
                        }
                    }
                }
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(style = ParagraphStyle(lineHeight = 32.sp)) {
                        append(restante)
                        append("\n")
                        withStyle(
                            style = SpanStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.W700
                            )
                        ) {
                            append("3500 Cup")
                        }
                    }
                }
            )
        }
    }
}