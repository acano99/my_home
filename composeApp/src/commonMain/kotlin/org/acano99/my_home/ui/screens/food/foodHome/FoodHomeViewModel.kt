package org.acano99.my_home.ui.screens.food.foodHome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.acano99.my_home.data.database.dao.DayMenuDao
import org.acano99.my_home.data.database.entity.DayMenuEntity
import org.acano99.my_home.data.database.entity.FoodEntity
import org.acano99.my_home.data.enums.MenuType

class FoodHomeViewModel(
    private val dayMenuDao: DayMenuDao
) : ViewModel() {
    private val _uiState = MutableStateFlow<FoodHomeUiState>(FoodHomeUiState())
    var uiState: StateFlow<FoodHomeUiState> = _uiState

    init {
        loadData()
    }

    private fun loadData() {
        _uiState.update { state ->
            state.copy(loading = true)
        }
        viewModelScope.launch(Dispatchers.IO) {
            dayMenuDao.insertDayMenu(dayMenuEntity = DayMenuEntity(dayMenuId = 2, date = "151515"))
            dayMenuDao.insertDayMenu(dayMenuEntity = DayMenuEntity(dayMenuId = 3, date = "151515"))
            dayMenuDao.insertDayMenu(dayMenuEntity = DayMenuEntity(dayMenuId = 4, date = "151515"))
            dayMenuDao.insertFood(
                foodEntity = FoodEntity(
                    id = 12,
                    dayMenuIdParent = 4,
                    food = "Food",
                    menuType = MenuType.Desayuno
                )
            )
            dayMenuDao.insertFood(
                foodEntity = FoodEntity(
                    id = 4,
                    dayMenuIdParent = 4,
                    food = "Food dos",
                    menuType = MenuType.Desayuno
                )
            )
            runCatching {
                dayMenuDao.getDayMenus()
            }.onSuccess { response ->

                _uiState.update { state ->
                    state.copy(
                        loading = false,
                        //dayMenu = listOf(),
                        testdata = response[0].toString(),
                        error = ""
                    )
                }
            }.onFailure { error ->
                _uiState.update { state ->
                    state.copy(
                        loading = false,
                        //dayMenu = listOf(),
                        error = error.let { it.message ?: "Error desconocido" })
                }
            }
        }
    }

    fun setDate(dateInMilliseconds: Long) {
        //TODO: Convertir la fecha de long a una fecha
        val date = dateInMilliseconds
        println(date)
    }
}