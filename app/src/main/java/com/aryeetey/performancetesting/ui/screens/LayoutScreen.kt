package com.aryeetey.performancetesting.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LayoutScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Surface(
                color = Color.Magenta,
                modifier = Modifier
                    .fillMaxHeight(.5f)
                    .fillMaxWidth(),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    VerticalColoredBar(color = Color.Red)
                    VerticalColoredBar(color = Color.Yellow)
                    VerticalColoredBar(color = Color.Blue)
                    VerticalColoredBar(color = Color.Black)
                }
            }
            Surface(
                color = Color.Cyan,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    HorizontalColoredBar(color = Color.Red)
                    HorizontalColoredBar(color = Color.Yellow)
                    HorizontalColoredBar(color = Color.Blue)
                    HorizontalColoredBar(color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun HorizontalColoredBar(color: Color) {
    Surface(
        color = color, modifier = Modifier
            .height(300.dp)
            .width(60.dp)
    ) {}
}

@Composable
fun VerticalColoredBar(color: Color) {
    Surface(
        color = color, modifier = Modifier
            .height(60.dp)
            .width(300.dp)
    ) {}
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun PreviewMainActivity() {
    LayoutScreen()
}