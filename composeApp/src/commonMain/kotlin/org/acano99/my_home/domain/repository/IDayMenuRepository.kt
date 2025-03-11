package org.acano99.my_home.domain.repository

import org.acano99.my_home.domain.model.DayMenu
import org.acano99.my_home.domain.model.Food
import org.acano99.my_home.domain.model.FoodsWithDayMenu

interface IDayMenuRepository {
    suspend fun getDayMenus():List<FoodsWithDayMenu>

    suspend fun getDayMenuByDate(date:String):FoodsWithDayMenu

    suspend fun insertDayMenu(dayMenu: DayMenu)

    suspend fun insertFood(food: Food)
}