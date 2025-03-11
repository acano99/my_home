package org.acano99.my_home.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.acano99.my_home.data.database.dao.DayMenuDao
import org.acano99.my_home.data.database.entity.DayMenuEntity
import org.acano99.my_home.data.database.entity.FoodEntity

const val DATABASE_NAME = "myHome.db"

interface FixRoomError {
    fun clearAllTables()
}

@Database(entities = [FoodEntity::class, DayMenuEntity::class], version = 1)
abstract class MyHomeDatabase : RoomDatabase(), FixRoomError {
    abstract fun dayMenuDao(): DayMenuDao

    override fun clearAllTables() {}
}
