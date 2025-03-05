package org.acano99.my_home.di

import org.acano99.my_home.ui.screens.food.foodHome.HomeViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::HomeViewModel)
}