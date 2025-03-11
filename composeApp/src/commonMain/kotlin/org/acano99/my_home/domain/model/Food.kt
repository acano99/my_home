package org.acano99.my_home.domain.model

import org.acano99.my_home.data.database.entity.FoodEntity
import org.acano99.my_home.data.database.entity.MenuType

data class Food(
    val id: Int,
    val food: String,
    val menuType: MenuType
)

fun FoodEntity.toDomain() = Food(id = id, food = food, menuType = menuType)
