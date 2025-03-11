package org.acano99.my_home.di

import androidx.room.RoomDatabase
import org.acano99.my_home.data.database.MyHomeDatabase
import org.acano99.my_home.data.database.dao.DayMenuDao
import org.koin.dsl.module

val databaseModule = module {
    single<DayMenuDao> {
        val dbBuilder = get<RoomDatabase.Builder<MyHomeDatabase>>()
        dbBuilder.build().dayMenuDao()
    }
}