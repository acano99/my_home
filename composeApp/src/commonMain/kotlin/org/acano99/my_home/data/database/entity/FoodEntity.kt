package org.acano99.my_home.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Food")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val food: String
)
