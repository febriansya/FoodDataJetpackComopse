package com.example.fooddata.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fooddata.R

// Set of Material typography styles to start with

val Poppins = FontFamily(
    Font(R.font.poppins_reegular),
    Font(R.font.poppin_bold, weight = FontWeight.Bold),
    Font(R.font.poppins_extrabold, weight = FontWeight.ExtraBold),
    Font(R.font.poppins_light, weight = FontWeight.Light),
    Font(R.font.poppins_medium, weight = FontWeight.Medium),
    Font(R.font.poppins_semibold, weight = FontWeight.SemiBold),
)

val Typography = Typography(

    h1 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        color = Color.Black,
        fontSize = 32.sp
    ),


    h2 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        color = Color.Black,
        fontSize = 22.sp
    ),

    h3 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        color = Color.Black,
        fontSize = 14.sp
    ),


    body2 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        color = AbuRokok,
        fontSize = 14.sp
    ),

    body1 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        color = Color.Black,
        fontSize = 16.sp
    )
)


