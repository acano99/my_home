package org.acano99.my_home.domain.usecases

import kotlinx.coroutines.delay
import org.acano99.my_home.data.models.DayMenuModel
import org.acano99.my_home.data.models.dayMenu

class GetFoodsUseCase {
    suspend operator fun invoke(): List<DayMenuModel> {
        delay(3000)
        return dayMenu
    }
}