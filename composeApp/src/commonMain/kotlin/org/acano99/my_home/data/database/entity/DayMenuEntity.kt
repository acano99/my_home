package org.acano99.my_home.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.acano99.my_home.domain.model.DayMenu

@Entity(tableName = "DayMenu")
data class DayMenuEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
//    val foods: List<FoodEntity>,
    val date: String
)

fun DayMenu.toData() = DayMenuEntity(
    id = id,
    //foods = foods.map { it.toData() },
    date = date
)
