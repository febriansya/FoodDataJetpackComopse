package com.example.fooddata.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fooddata.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)

val Poppins = FontFamily(
    Font(R.font.poppins_reegular),
    Font(R.font.poppin_bold),
    Font(R.font.poppins_extrabold),
    Font(R.font.poppins_light),
    Font(R.font.poppins_medium),
    Font(R.font.poppins_semibold),
)

