package com.example.numfun.ui.game

data class GuessResult(
    val digits: List<Int>,
    val correctPosition: Int, // green
    val wrongPosition: Int    // red
)