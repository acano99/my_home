package org.acano99.my_home.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

expect val nativeModule:Module

fun initKoin(config:KoinAppDeclaration? = null){
    startKoin{
        config?.invoke(this)
        modules(nativeModule, viewModelModule)
    }
}