package org.acano99.my_home.ui.screens.food.foodHome

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
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import myhome.composeapp.generated.resources.Res
import myhome.composeapp.generated.resources.comidasPlanificadas
import myhome.composeapp.generated.resources.pagosPlanificados
import org.acano99.my_home.ui.composables.HorizontalVerySmallSpacer
import org.acano99.my_home.ui.composables.ThemeBottomNavigationBar
import org.acano99.my_home.ui.composables.ThemeCard
import org.acano99.my_home.ui.composables.ThemeDateHeader
import org.acano99.my_home.ui.composables.ThemeDialogDatePicker
import org.acano99.my_home.ui.composables.ThemeFoodIcon
import org.acano99.my_home.ui.composables.ThemeIconHeader
import org.acano99.my_home.ui.composables.ThemeInvoice
import org.acano99.my_home.ui.composables.ThemeTopBar
import org.acano99.my_home.ui.composables.VerticalHigSpacer
import org.acano99.my_home.ui.composables.VerticalMediumSpacer
import org.acano99.my_home.ui.composables.VerticalSmallSpacer
import org.acano99.my_home.ui.screens.common.ErrorScreen
import org.acano99.my_home.ui.screens.common.LoadingScreen
import org.acano99.my_home.ui.theme.mediumPadding
import org.acano99.my_home.ui.theme.minPadding
import org.acano99.my_home.ui.theme.smallPadding
import org.acano99.my_home.ui.theme.veryHighPadding
import org.acano99.my_home.ui.theme.verySmallPadding
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class, ExperimentalMaterial3Api::class)
@Composable
fun FoodHomeScreen(
    navController: NavController? = null,
    viewModel: FoodHomeViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = 1578096000000,
    )
    var showSelectedDatePicker by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ThemeTopBar(title = "Comidas") },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.let {
                    navController?.navigate("addFood")
                }
            }) {
                Icon(imageVector = Icons.Default.AddCircle, contentDescription = "")
            }
        },
        bottomBar = { ThemeBottomNavigationBar() }
    ) { innerPadding ->
        when {
            uiState.loading -> LoadingScreen(
                modifier = Modifier.fillMaxSize().padding(innerPadding)
            )

            uiState.error.isNotEmpty() -> ErrorScreen(
                modifier = Modifier.fillMaxSize().padding(innerPadding), error = uiState.error
            )

            else -> Column(
                modifier = Modifier.fillMaxSize().padding(innerPadding)
                    .padding(mediumPadding)
                    .verticalScroll(rememberScrollState())
            ) {
                ThemeDateHeader(
                    modifier = Modifier.fillMaxWidth().padding(start = smallPadding),
                    title = "12 de febrero",
                    onClick = { showSelectedDatePicker = true }
                )
                VerticalHigSpacer()
                //Foods(dayMenu = uiState.dayMenu)
                VerticalHigSpacer()
                Text(uiState.testdata, fontSize = 24.sp)
                Spacer(Modifier.height(veryHighPadding * 3))
                if (showSelectedDatePicker)
                    ThemeDialogDatePicker(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = smallPadding),
                        state = datePickerState,
                        onDismissRequest = { showSelectedDatePicker = false },
                        onAcceptRequest = { viewModel.setDate(it) }
                    )
            }
        }
    }
}


@Composable
fun Foods(modifier: Modifier = Modifier) {
    ThemeCard(modifier = modifier) {
        ThemeIconHeader(
            icon = Icons.Default.ShoppingCart,
            title = stringResource(Res.string.comidasPlanificadas)
        )
        VerticalMediumSpacer()
        /*if (dayMenu.isNotEmpty()) {
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
        }*/
    }
}

@Composable
fun Pagos() {
    ThemeCard {
        Column(modifier = Modifier.padding(horizontal = smallPadding)) {
            ThemeIconHeader(
                icon = Icons.Default.ShoppingCart,
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
