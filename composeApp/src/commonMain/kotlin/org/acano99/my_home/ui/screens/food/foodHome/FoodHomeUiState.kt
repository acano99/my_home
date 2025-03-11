package org.acano99.my_home.ui.screens.food.foodHome

import org.acano99.my_home.domain.model.FoodsWithDayMenu


data class FoodHomeUiState(
    val loading: Boolean = true,
    val error: String = "",
    val dayMenu: FoodsWithDayMenu? = null,
    val testdata: String = "",
    val date: String = ""
)
