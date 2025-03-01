package org.acano99.my_home

import android.app.Application
import org.acano99.my_home.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level


class MyHomeApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin{
            androidLogger(Level.DEBUG)
            androidContext(this@MyHomeApp)
        }
    }
}