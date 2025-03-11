package org.acano99.my_home.domain.repository

import org.acano99.my_home.data.database.entity.DayMenuEntity
import org.acano99.my_home.data.database.entity.FoodsWithDayMenu

interface IDayMenuRepository {
    suspend fun getDayMenus():List<FoodsWithDayMenu>

    suspend fun getDayMenuByDate(date:String):FoodsWithDayMenu

    suspend fun insertDayMenu(dayMenuEntity: DayMenuEntity)
}