package com.example.numfun.ui.game.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ResultBox(
    value: Int,
    isGreen: Boolean
) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(if (isGreen) Color(0xFF4CAF50) else Color(0xFFF44336)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = value.toString(), color = Color.White)
    }
}