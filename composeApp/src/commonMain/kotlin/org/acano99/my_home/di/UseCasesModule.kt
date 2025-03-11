package org.acano99.my_home.di

import org.acano99.my_home.domain.usecases.GetDayMenusUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::GetDayMenusUseCase)
}