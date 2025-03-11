package org.acano99.my_home.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

enum class MenuType {
    Desayuno, Merienda, Almuerzo, Comida
}

@Entity(tableName = "DayMenu")
data class DayMenuEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "menu_day_id") val dayMenuId: Int?,
    @ColumnInfo(name = "date") val date: String?
)

@Entity(tableName = "Food")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "menu_day_id_parent") val dayMenuIdParent: Int,
    @ColumnInfo(name = "food") val food: String,
    @ColumnInfo(name = "menu_type") val menuType: MenuType
)

/**
 * Esta entidad represenra la relacion entre ambas tablas
 * Cuando se hace una peticion para obtener el menu del dia con
 * todas las comidas se debe devolver esta entidad
**/
data class FoodsWithDayMenu(
    @Embedded val menu: DayMenuEntity,
    @Relation(
        parentColumn = "menu_day_id",
        entityColumn = "menu_day_id_parent"
    ) val foods:List<FoodEntity>
)

