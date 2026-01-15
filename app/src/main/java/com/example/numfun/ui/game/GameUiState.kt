package com.example.numfun.ui.game

import com.example.numfun.ui.game.GuessResult

data class GameUiState(
    val secret: List<Int> = emptyList(),
    val currentInput: List<Int> = emptyList(),
    val guesses: List<GuessResult> = emptyList(),
    val attemptsLeft: Int = 6,
    val gameOver: Boolean = false,
    val won: Boolean = false
)