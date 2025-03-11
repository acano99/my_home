package org.acano99.my_home.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.acano99.my_home.data.database.entity.FoodEntity
import org.acano99.my_home.data.models.DayMenuModel

const val DATABASE_NAME = "myHome.db"

interface FixRoomError {
    fun clearAllTables()
}

@Database(entities = [DayMenuModel::class, FoodEntity::class], version = 1)
abstract class MyHomeDatabase : RoomDatabase(), FixRoomError {
    abstract fun myHomeDao(): MyHomeDao

    //abstract fun foodDao(): FoodDao

    override fun clearAllTables() {}
}
