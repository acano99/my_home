package org.acano99.my_home.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class MenuType {
    Desayuno, Merienda, Almuerzo, Comida
}

enum class WeekDay {
    Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo
}

@Entity
data class DayMenuModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val type: MenuType? = null,
    val food: String = "",
    val weekDay: WeekDay? = null,
    val date: String = ""
)

val dayMenu = listOf<DayMenuModel>(
    DayMenuModel(
        id = 0,
        type = MenuType.Desayuno,
        food = "Pan con tomate",
        weekDay = WeekDay.Lunes,
        date = ""
    ),
    DayMenuModel(
        id = 0,
        type = MenuType.Almuerzo,
        food = "Arroz, chicharos, hambuerguesa",
        weekDay = WeekDay.Lunes,
        date = ""
    ),
    DayMenuModel(
        id = 0,
        type = MenuType.Merienda,
        food = "Pan con mayonesa, refresco de guanabana",
        weekDay = WeekDay.Lunes,
        date = ""
    ),
    DayMenuModel(
        id = 0,
        type = MenuType.Comida,
        food = "Spaguetti",
        weekDay = WeekDay.Lunes,
        date = ""
    ),
)