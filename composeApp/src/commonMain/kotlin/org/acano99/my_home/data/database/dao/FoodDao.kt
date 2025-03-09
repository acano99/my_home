package org.acano99.my_home.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.acano99.my_home.data.database.entity.FoodEntity

@Dao
interface FoodDao {
    @Query("SELECT * From Food")
    fun getFoods(): Flow<List<FoodEntity>>
}