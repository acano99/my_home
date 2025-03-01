package org.acano99.my_home.di

import org.koin.core.module.Module
import org.koin.dsl.module

actual val nativeModule: Module = module {
    //single { getDatabaseBuilder(get()) }
}