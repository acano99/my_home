package org.acano99.my_home.domain.model

import org.acano99.my_home.data.database.entity.DayMenuEntity
import org.acano99.my_home.data.database.entity.FoodEntity
import org.acano99.my_home.data.database.entity.FoodsWithDayMenuRelation
import org.acano99.my_home.data.enums.MenuType


data class DayMenu(
    val dayMenuId: Int? = null,
    val date: String?
)

data class Food(
    val id: Int? = null,
    val dayMenuIdParent: Int,
    val food: String,
    val menuType: MenuType
)

/**
 * Esta clase representa la respuesta que proviene de la base de datos
 **/
data class FoodsWithDayMenu(
    val menu: DayMenu,
    val foods: List<Food>
)

fun DayMenuEntity.toDomain() = DayMenu(dayMenuId = dayMenuId, date = date)

fun FoodEntity.toDomain() =
    Food(id = id, dayMenuIdParent = dayMenuIdParent, food = food, menuType = menuType)

fun FoodsWithDayMenuRelation.toDomain() =
    FoodsWithDayMenu(menu = menu.toDomain(), foods = foods.map { it.toDomain() })



