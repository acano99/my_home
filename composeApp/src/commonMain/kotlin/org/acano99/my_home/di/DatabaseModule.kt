package org.acano99.my_home.di

import androidx.room.RoomDatabase
import org.acano99.my_home.data.database.MyHomeDao
import org.acano99.my_home.data.database.MyHomeDatabase
import org.acano99.my_home.data.database.dao.FoodDao
import org.koin.dsl.module

val databaseModule = module {
    single<MyHomeDao> {
        val dbBuilder = get<RoomDatabase.Builder<MyHomeDatabase>>()
        dbBuilder.build().myHomeDao()
    }
    single<FoodDao> {
        val dbBuilder = get<RoomDatabase.Builder<MyHomeDatabase>>()
        dbBuilder.build().foodDao()
    }
}

//val dataModule