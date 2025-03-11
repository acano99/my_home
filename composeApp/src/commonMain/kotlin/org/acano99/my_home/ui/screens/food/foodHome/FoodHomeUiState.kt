package org.acano99.my_home.ui.screens.food.foodHome


data class FoodHomeUiState(
    val loading: Boolean = true,
    val error: String = "",
    //val dayMenu: List<DayMenuModel> = listOf(),
    val testdata: String = "",
    val date: String = ""
)
