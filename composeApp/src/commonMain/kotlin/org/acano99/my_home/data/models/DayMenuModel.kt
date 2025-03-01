package org.acano99.my_home.data.models

enum class MenuType {
    Desayuno, Merienda, Almuerzo, Comida
}

enum class WeekDay {
    Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo
}

data class DayMenuModel(
    val id: Int?,
    val type: MenuType?,
    val food: List<String>,
    val weekDay: WeekDay?
)
