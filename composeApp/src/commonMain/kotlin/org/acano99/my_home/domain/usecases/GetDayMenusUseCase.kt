package org.acano99.my_home.domain.usecases

import org.acano99.my_home.data.database.repositoryImplement.DayMenuRepository
import org.acano99.my_home.domain.model.FoodsWithDayMenu

class GetDayMenusUseCase (private val dayMenuRepository: DayMenuRepository){
    suspend operator fun invoke():List<FoodsWithDayMenu> = dayMenuRepository.getDayMenus()
}