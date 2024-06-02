package com.example.loginjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun LinearGradientBackground() {
    val gradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF630372), // Custom Color 1
            Color(0xFF12171D)  // Custom Color 2
        ),
        start = Offset(0f, 0f),
        end = Offset(500f, 800f)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    )
}

