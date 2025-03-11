package org.acano99.my_home.domain.model

import org.acano99.my_home.data.database.entity.DayMenuEntity

data class DayMenu(
    val id: Int,
    val foods: List<Food>,
    val date: String
)

fun DayMenuEntity.toDomain() = DayMenu(
    id = id,
    foods = foods.map { it.toDomain() },
    date = date
)
