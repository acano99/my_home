package org.acano99.my_home.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class MenuType {
    Desayuno, Merienda, Almuerzo, Comida
}

@Entity(tableName = "Food")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val food: String,
    val menuType: MenuType
)
