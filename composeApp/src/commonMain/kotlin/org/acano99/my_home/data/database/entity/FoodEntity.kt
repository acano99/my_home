package org.acano99.my_home.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.acano99.my_home.domain.model.Food

enum class MenuType {
    Desayuno, Merienda, Almuerzo, Comida
}

@Entity(tableName = "Food")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val food: String,
    val menuType: MenuType
)

fun Food.toData() = FoodEntity(id = id, food = food, menuType = menuType)
