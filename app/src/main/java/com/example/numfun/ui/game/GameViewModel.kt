package com.example.numfun.ui.game

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import com.example.numfun.ui.game.GuessResult
import kotlin.random.Random

class GameViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState

    init {
        startNewGame()
    }

    fun startNewGame() {
        _uiState.value = GameUiState(
            secret = generateSecret()
        )
    }

    fun onNumberClick(number: Int) {
        val input = _uiState.value.currentInput
        if (input.size < 4) {
            _uiState.update {
                it.copy(currentInput = input + number)
            }
        }
    }

    fun onDelete() {
        _uiState.update {
            it.copy(currentInput = it.currentInput.dropLast(1))
        }
    }

    fun onEnter() {
        val state = _uiState.value
        if (state.currentInput.size != 4 || state.gameOver) return

        val result = evaluateGuess(state.currentInput, state.secret)

        val newGuesses = state.guesses + result
        val attemptsLeft = state.attemptsLeft - 1
        val won = result.correctPosition == 4

        _uiState.value = state.copy(
            guesses = newGuesses,
            currentInput = emptyList(),
            attemptsLeft = attemptsLeft,
            gameOver = won || attemptsLeft == 0,
            won = won
        )
    }

    private fun evaluateGuess(
        guess: List<Int>,
        secret: List<Int>
    ): GuessResult {
        val correct = guess.zip(secret).count { it.first == it.second }
        val common = guess.intersect(secret.toSet()).size
        val wrong = common - correct

        return GuessResult(
            digits = guess,
            correctPosition = correct,
            wrongPosition = wrong
        )
    }

    private fun generateSecret(): List<Int> =
        (0..9).shuffled(Random(System.currentTimeMillis())).take(4)
}