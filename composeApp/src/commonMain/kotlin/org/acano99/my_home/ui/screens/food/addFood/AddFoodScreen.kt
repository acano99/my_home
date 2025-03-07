package org.acano99.my_home.ui.screens.food.addFood

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
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import org.acano99.my_home.data.models.MenuType
import org.acano99.my_home.data.models.dayMenu
import org.acano99.my_home.ui.composables.HorizontalVerySmallSpacer
import org.acano99.my_home.ui.composables.ThemeCard
import org.acano99.my_home.ui.composables.ThemeElevatedButton
import org.acano99.my_home.ui.composables.ThemeFoodIcon
import org.acano99.my_home.ui.composables.ThemeIconHeader
import org.acano99.my_home.ui.composables.ThemeTopBar
import org.acano99.my_home.ui.composables.VerticalHigSpacer
import org.acano99.my_home.ui.theme.mediumPadding
import org.acano99.my_home.ui.theme.smallPadding
import org.acano99.my_home.ui.theme.veryHighPadding
import org.acano99.my_home.ui.theme.verySmallPadding
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class, KoinExperimentalAPI::class)
@Composable
fun AddFoodHome(viewModel: AddFoodViewModel = koinViewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = 1578096000000,
        initialDisplayMode = DisplayMode.Input
    )
    val foodTypeList = listOf("Desayuno", "Almuerzo", "Comida", "Merienda")

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
            SelectedDate(datePickerState)
            VerticalHigSpacer()
            AddNewFood(foodTypeList = foodTypeList, menu = uiState.menu, onMenuChange = {
                viewModel.onMenuChange(
                    it
                )
            })
            VerticalHigSpacer()
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
                    Spacer(Modifier.weight(1f))
                    IconButton(onClick = {}) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = Icons.Rounded.Delete,
                            contentDescription = "",
                        )
                    }
                }
            }
            ThemeElevatedButton()
            Spacer(Modifier.height(veryHighPadding * 3))
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun AddNewFood(foodTypeList: List<String>, menu: String, onMenuChange: (String) -> Unit) {
    var foodSelected by remember { mutableIntStateOf(0) }
    ThemeCard {
        ThemeIconHeader(icon = Icons.Rounded.DateRange, title = "Agregue una comida")
        VerticalHigSpacer()
        FlowRow {
            repeat(foodTypeList.size) { index ->
                FilterChip(
                    selected = foodSelected == index,
                    onClick = { foodSelected = index },
                    label = {
                        Text(text = foodTypeList[index])
                    }, modifier = Modifier.padding(end = smallPadding)
                )
            }
        }
        VerticalHigSpacer()
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = menu, onValueChange = { onMenuChange(it) }, label = { Text("Menu") })
        VerticalHigSpacer()
        ThemeElevatedButton()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SelectedDate(datePickerState: DatePickerState) {
    ElevatedCard(modifier = Modifier.fillMaxWidth()) {
        DatePicker(
            state = datePickerState
        )
    }
}

@Composable
fun Foods() {

}