package org.acano99.my_home.ui.screens.food.addFood

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.acano99.my_home.data.models.dayMenu

class AddFoodViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AddFoodUiState())
    var uiState: StateFlow<AddFoodUiState> = _uiState

    init {
        _uiState.update { state -> state.copy(dayMenu = dayMenu) }
    }

    fun onMenuChange(menu: String) {
        _uiState.update { state -> state.copy(menu = menu) }
    }
}