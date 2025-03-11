package org.acano99.my_home.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import org.acano99.my_home.data.database.entity.DayMenuEntity
import org.acano99.my_home.data.database.entity.FoodEntity
import org.acano99.my_home.data.database.entity.FoodsWithDayMenuRelation

@Dao
interface DayMenuDao {
    @Transaction
    @Query("SELECT * From DayMenu")
    fun getDayMenus(): List<FoodsWithDayMenuRelation>

    @Transaction
    @Query("SELECT * From DayMenu WHERE date=:date")
    fun getDayMenuByDate(date:String): FoodsWithDayMenuRelation

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDayMenu(dayMenuEntity: DayMenuEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(foodEntity: FoodEntity)
}