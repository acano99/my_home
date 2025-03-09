package org.acano99.my_home.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.acano99.my_home.data.models.DayMenuModel

@Dao
interface MyHomeDao {
    @Query("SELECT * FROM DayMenuModel")
    fun getFoods(): Flow<List<DayMenuModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDayMenu(dayMenu: DayMenuModel)
}