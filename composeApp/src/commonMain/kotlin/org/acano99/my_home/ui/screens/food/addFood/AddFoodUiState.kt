package org.acano99.my_home.ui.screens.food.addFood

import org.acano99.my_home.domain.model.Food


data class AddFoodUiState(
    val menu: String = "",
    val foods: MutableList<Food> = mutableListOf()
)
