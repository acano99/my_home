package org.acano99.my_home.domain.usecases

import org.acano99.my_home.data.database.repositoryImplement.DayMenuRepository
import org.acano99.my_home.domain.model.DayMenu

class InsertDayMenuUseCase (private val dayMenuRepository: DayMenuRepository){
    suspend operator fun invoke(dayMenu: DayMenu) = dayMenuRepository.insertDayMenu(dayMenu)
}