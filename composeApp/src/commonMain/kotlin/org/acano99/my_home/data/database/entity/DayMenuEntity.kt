package org.acano99.my_home.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import org.acano99.my_home.data.enums.MenuType
import org.acano99.my_home.domain.model.DayMenu
import org.acano99.my_home.domain.model.Food

@Entity(tableName = "DayMenu")
data class DayMenuEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "menu_day_id") val dayMenuId: Int? = null,
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
data class FoodsWithDayMenuRelation(
    @Embedded val menu: DayMenuEntity,
    @Relation(
        parentColumn = "menu_day_id",
        entityColumn = "menu_day_id_parent"
    ) val foods: List<FoodEntity>
)

fun DayMenu.toEntity() = DayMenuEntity(dayMenuId = dayMenuId, date = date)

fun Food.toEntity() =
    FoodEntity(id = id, dayMenuIdParent = dayMenuIdParent, food = food, menuType = menuType)

