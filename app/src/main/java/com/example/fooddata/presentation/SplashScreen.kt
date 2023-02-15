package com.example.fooddata.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun SplashScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "test", modifier = Modifier.align(Alignment.Start))
            Text(text = "test")
            Text(text = "test")
            Text(text = "test")
            Text(text = "test")
            Text(text = "test")
            Text(text = "test")
        }
    }

}


@Preview
@Composable
fun Previewk() {
    SplashScreen()
}