package org.acano99.my_home.data.database.repositoryImplement

import org.acano99.my_home.data.database.dao.DayMenuDao
import org.acano99.my_home.data.database.entity.DayMenuEntity
import org.acano99.my_home.data.database.entity.FoodsWithDayMenu
import org.acano99.my_home.domain.repository.IDayMenuRepository

class DayMenuRepository(private val dayMenuDao: DayMenuDao):IDayMenuRepository {
    override suspend fun getDayMenus(): List<FoodsWithDayMenu> {
        return dayMenuDao.getDayMenus()
    }

    override suspend fun getDayMenuByDate(date: String): FoodsWithDayMenu {
        TODO("Not yet implemented")
    }

    override suspend fun insertDayMenu(dayMenuEntity: DayMenuEntity) {
        dayMenuDao.insertDayMenu(dayMenuEntity)
    }
}