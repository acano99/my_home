package org.acano99.my_home.data.database.repositoryImplement

import org.acano99.my_home.data.database.dao.DayMenuDao
import org.acano99.my_home.data.database.entity.DayMenuEntity
import org.acano99.my_home.data.database.entity.FoodsWithDayMenuRelation
import org.acano99.my_home.data.database.entity.toEntity
import org.acano99.my_home.domain.model.DayMenu
import org.acano99.my_home.domain.model.FoodsWithDayMenu
import org.acano99.my_home.domain.model.toDomain
import org.acano99.my_home.domain.repository.IDayMenuRepository

class DayMenuRepository(private val dayMenuDao: DayMenuDao) : IDayMenuRepository {
    override suspend fun getDayMenus(): List<FoodsWithDayMenu> {
        return dayMenuDao.getDayMenus().map {
            FoodsWithDayMenu(
                menu = it.menu.toDomain(),
                foods = it.foods.map { food -> food.toDomain() })
        }
    }

    override suspend fun getDayMenuByDate(date: String): FoodsWithDayMenu {
        TODO("Not yet implemented")
    }

    override suspend fun insertDayMenu(dayMenu: DayMenu) {
        dayMenuDao.insertDayMenu(dayMenuEntity = dayMenu.toEntity())
    }
}