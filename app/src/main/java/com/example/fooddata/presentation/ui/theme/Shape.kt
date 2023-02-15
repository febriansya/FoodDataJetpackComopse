package com.example.fooddata.presentation.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp),
)

val CustomShape = Shapes(
    small = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp),
    medium = RoundedCornerShape(
        topStart = 16.dp,
        topEnd = 0.dp,
        bottomEnd = 16.dp,
        bottomStart = 0.dp
    )
)