package com.example.numfun.ui.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    // Later connect DataStore here
    fun checkSavedGame(hasGame: Boolean) {
        _uiState.value = HomeUiState(hasSavedGame = hasGame)
    }
}