package com.example.numfun.ui.game

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.numfun.ui.game.components.DigitBox
import com.example.numfun.ui.game.components.Keypad
import com.example.numfun.ui.game.components.ResultBox

@Composable
fun GameScreen(
    onExit: () -> Unit,
    viewModel: GameViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Attempts left: ${state.attemptsLeft}",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(Modifier.height(16.dp))

        state.guesses.forEach { guess ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                guess.digits.forEach {
                    DigitBox(value = it)
                }
                Spacer(Modifier.width(8.dp))
                ResultBox(value = guess.wrongPosition, isGreen = false)
                Spacer(Modifier.width(4.dp))
                ResultBox(value = guess.correctPosition, isGreen = true)
            }
            Spacer(Modifier.height(8.dp))
        }

        Spacer(Modifier.weight(1f))

        Row {
            repeat(4) { index ->
                DigitBox(
                    value = state.currentInput.getOrNull(index)
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        Keypad(
            onNumberClick = viewModel::onNumberClick,
            onDelete = viewModel::onDelete,
            onEnter = viewModel::onEnter
        )
    }
}