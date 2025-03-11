package org.acano99.my_home.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import org.acano99.my_home.domain.model.DayMenu
import org.acano99.my_home.domain.model.Food

@Entity(tableName = "DayMenu")
data class DayMenuEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "menu_day_id") val dayMenuId: Int?,
    @ColumnInfo(name = "date") val date: String?
)

enum class MenuType {
    Desayuno, Merienda, Almuerzo, Comida
}

@Entity(tableName = "Food")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "menu_day_id_parent") val dayMenuIdParent: Int,
    @ColumnInfo(name = "food") val food: String,
    @ColumnInfo(name = "menu_type") val menuType: MenuType
)

data class FoodsWithMenuDay(
    @Embedded val menu: DayMenuEntity,
    @Relation(
        parentColumn = "menu_day_id",
        entityColumn = "menu_day_id_parent"
    ) val foods:List<FoodEntity>
)

