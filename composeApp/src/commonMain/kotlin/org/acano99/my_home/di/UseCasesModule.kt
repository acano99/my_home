package org.acano99.my_home.di

import org.acano99.my_home.domain.usecases.GetDayMenuByDateUseCase
import org.acano99.my_home.domain.usecases.GetDayMenusUseCase
import org.acano99.my_home.domain.usecases.InsertDayMenuUseCase
import org.acano99.my_home.domain.usecases.InsertFoodUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::GetDayMenusUseCase)
    factoryOf(::GetDayMenuByDateUseCase)
    factoryOf(::InsertDayMenuUseCase)
    factoryOf(::InsertFoodUseCase)
}