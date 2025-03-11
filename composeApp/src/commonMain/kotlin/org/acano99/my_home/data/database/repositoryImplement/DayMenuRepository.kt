package org.acano99.my_home.data.database.repositoryImplement

import org.acano99.my_home.data.database.dao.DayMenuDao
import org.acano99.my_home.data.database.entity.toEntity
import org.acano99.my_home.domain.model.DayMenu
import org.acano99.my_home.domain.model.Food
import org.acano99.my_home.domain.model.FoodsWithDayMenu
import org.acano99.my_home.domain.model.toDomain
import org.acano99.my_home.domain.repository.IDayMenuRepository

class DayMenuRepository(private val dayMenuDao: DayMenuDao) : IDayMenuRepository {
    override suspend fun getDayMenus(): List<FoodsWithDayMenu> =
        dayMenuDao.getDayMenus().map {
            it.toDomain()
        }

    override suspend fun getDayMenuByDate(date: String): FoodsWithDayMenu =
        dayMenuDao.getDayMenuByDate(date = date).toDomain()


    override suspend fun insertDayMenu(dayMenu: DayMenu) {
        dayMenuDao.insertDayMenu(dayMenuEntity = dayMenu.toEntity())
    }

    override suspend fun insertFood(food: Food) {
        TODO("Not yet implemented")
    }
}