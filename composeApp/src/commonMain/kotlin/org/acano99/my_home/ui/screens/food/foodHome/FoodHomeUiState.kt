package org.acano99.my_home.ui.screens.food.foodHome

import org.acano99.my_home.data.models.DayMenuModel

data class FoodHomeUiState(
    val loading: Boolean = true,
    val error: String = "",
    val dayMenu: List<DayMenuModel> = listOf(),
    val testdata: String = "",
    val date: String = ""
)
