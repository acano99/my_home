package org.acano99.my_home.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DayMenu")
data class DayMenuEntity(
    @PrimaryKey(autoGenerate = true) val id: Boolean,
    val foods: List<FoodEntity>,
    val date: String
)
