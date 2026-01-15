package com.example.numfun.ui.game.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Keypad(
    onNumberClick: (Int) -> Unit,
    onDelete: () -> Unit,
    onEnter: () -> Unit
) {
    val numbers = listOf(1, 2, 3, 4, 5)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        numbers.forEach { num ->
            Button(
                onClick = { onNumberClick(num) },
                modifier = Modifier.weight(1f)
            ) {
                Text(num.toString())
            }
            Spacer(Modifier.width(4.dp))
        }
    }

    Spacer(Modifier.height(8.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedButton(
            onClick = onDelete,
            modifier = Modifier.weight(1f)
        ) {
            Text("DEL")
        }
        Spacer(Modifier.width(8.dp))
        Button(
            onClick = onEnter,
            modifier = Modifier.weight(1f)
        ) {
            Text("ENTER")
        }
    }
}