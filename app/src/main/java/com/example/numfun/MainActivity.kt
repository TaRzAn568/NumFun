package com.example.numfun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.numfun.navigation.AppNavGraph
import com.example.numfun.ui.theme.NumFunTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NumFunTheme {
                AppNavGraph()
            }
        }
    }
}