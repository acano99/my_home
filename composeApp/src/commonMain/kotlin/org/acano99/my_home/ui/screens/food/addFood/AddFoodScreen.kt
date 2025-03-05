package org.acano99.my_home.ui.screens.food.addFood

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import myhome.composeapp.generated.resources.Res
import myhome.composeapp.generated.resources.comidasPlanificadas
import org.acano99.my_home.data.models.MenuType
import org.acano99.my_home.data.models.dayMenu
import org.acano99.my_home.ui.composables.HorizontalVerySmallSpacer
import org.acano99.my_home.ui.composables.ThemeCard
import org.acano99.my_home.ui.composables.ThemeElevatedButton
import org.acano99.my_home.ui.composables.ThemeFoodIcon
import org.acano99.my_home.ui.composables.ThemeIconHeader
import org.acano99.my_home.ui.composables.ThemeTopBar
import org.acano99.my_home.ui.composables.VerticalHigSpacer
import org.acano99.my_home.ui.composables.VerticalMinSpacer
import org.acano99.my_home.ui.theme.mediumPadding
import org.acano99.my_home.ui.theme.verySmallPadding
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun AddFoodHome() {
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = 1578096000000,
        initialDisplayMode = DisplayMode.Input
    )

    Scaffold(
        topBar = { ThemeTopBar("Agregar Comida") },
        floatingActionButton = {
            FloatingActionButton(onClick = {

            }) {}
        })
    { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
                .padding(mediumPadding)
                .verticalScroll(rememberScrollState())
        ) {
            DatePicker(
                state = datePickerState, title = null,
            )
            VerticalHigSpacer()
            ThemeCard {
                Text(text = "Tipo de Comida")
                FlowRow {
                    repeat(4) {
                        FilterChip(selected = false, onClick = {}, label = {
                            Text(text = "Desayuno")
                        })
                    }
                }
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "", onValueChange = {}, label = { Text("Comida") })
                ThemeElevatedButton()
            }
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
        }
    }
}

@Composable
fun Foods() {
    ThemeCard {
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