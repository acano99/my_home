package org.acano99.my_home.ui.screens.food.foodHome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.acano99.my_home.domain.usecases.GetDayMenuByDateUseCase

class FoodHomeViewModel(
    private val getDayMenuByDateUseCase: GetDayMenuByDateUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(FoodHomeUiState())
    var uiState: StateFlow<FoodHomeUiState> = _uiState

    init {
        loadData()
    }

    private fun loadData() {
        _uiState.update { state ->
            state.copy(loading = true)
        }
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                getDayMenuByDateUseCase.invoke("12/12/12")
            }.onSuccess { response ->

                _uiState.update { state ->
                    state.copy(
                        loading = false,
                        dayMenu = response,
                        testdata = response.toString(),
                        error = ""
                    )
                }
            }.onFailure { error ->
                _uiState.update { state ->
                    state.copy(
                        loading = false,
                        dayMenu = null,
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