package org.acano99.my_home.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.acano99.my_home.data.database.entity.DayMenuEntity
import org.acano99.my_home.data.database.entity.FoodEntity

@Dao
interface FoodDao {
    @Query("SELECT * From Food")
    fun getFoods(): Flow<List<FoodEntity>>

    @Query("SELECT * From Food WHERE id = :id")
    fun getFoodById(id: Int): Flow<FoodEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun newFood(dayMenu: DayMenuEntity)
}