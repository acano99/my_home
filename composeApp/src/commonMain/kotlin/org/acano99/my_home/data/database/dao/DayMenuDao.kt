package org.acano99.my_home.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import org.acano99.my_home.data.database.entity.DayMenuEntity
import org.acano99.my_home.data.database.entity.FoodEntity
import org.acano99.my_home.data.database.entity.FoodsWithDayMenu

@Dao
interface DayMenuDao {
    @Transaction
    @Query("SELECT * From DayMenu")
    fun getDayMenus(): List<FoodsWithDayMenu>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDayMenu(dayMenuEntity: DayMenuEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(foodEntity: FoodEntity)

    /*@Query("SELECT * From Food WHERE id = :id")
    fun getDayMenuById(id: Int): Flow<FoodEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun newDayMenu(dayMenu: DayMenuEntity)*/
}