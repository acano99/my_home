package org.acano99.my_home.ui.screens.food.addFood

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.acano99.my_home.domain.model.DayMenu
import org.acano99.my_home.domain.model.Food
import org.acano99.my_home.domain.usecases.InsertDayMenuUseCase
import org.acano99.my_home.domain.usecases.InsertFoodUseCase

class AddFoodViewModel(
    private val insertDayMenu: InsertDayMenuUseCase,
    private val insertFoodUseCase: InsertFoodUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(AddFoodUiState())
    var uiState: StateFlow<AddFoodUiState> = _uiState

    init {

    }

    fun onMenuChange(menu: String) {
        _uiState.update { state -> state.copy(menu = menu) }
    }

    fun temporalAdd(food: Food) {
        _uiState.update { state ->
            val foods = listOf(food) + state.foods
            state.copy(menu = "", foods = foods)
        }
    }

    fun save(dayMenu: DayMenu) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                insertDayMenu.invoke(dayMenu)
            }.onFailure {
                // Cambiar a estado de error
            }.onSuccess {
                // TODO:Obtener el id del dayMenu para asignarselo a cada food en la lista
                _uiState.value.foods.forEach {
                    insertFoodUseCase.invoke(food = it)
                }
            }.onFailure {
                // Eliminar todos los registros insertados hasta el momento
            }
        }
    }
}