package org.acano99.my_home.ui.screens.food.addFood

import org.acano99.my_home.data.models.DayMenuModel

data class AddFoodUiState(
    val menu: String = "",
    val dayMenu: List<DayMenuModel> = listOf()
)
