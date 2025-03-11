package org.acano99.my_home.domain.usecases

import org.acano99.my_home.data.database.repositoryImplement.DayMenuRepository
import org.acano99.my_home.domain.model.Food

class InsertFoodUseCase(private val dayMenuRepository: DayMenuRepository) {
    suspend operator fun invoke(food: Food) = dayMenuRepository.insertFood(food)
}