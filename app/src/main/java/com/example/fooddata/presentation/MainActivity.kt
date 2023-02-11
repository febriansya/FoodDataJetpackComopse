package com.example.fooddata.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddata.BuildConfig
import com.example.fooddata.R
import com.example.fooddata.presentation.ui.theme.FoodDataTheme


val nameInterest: List<String> = listOf(
    "ketengan", "kemlikin", "tai kucing", "tape", "fade", "testing again"
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        this for example dont pusth api key to github
        val api_key = BuildConfig.API_KEY
        super.onCreate(savedInstanceState)
        setContent {
            FoodDataTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ScreenFood(nameInterest)
                }
            }
        }
    }
}

@Composable
fun ScreenFood(name: List<String>) {
    Column() {
        if (name.isNotEmpty()) {
            LazyColumn {
                items(name) { name ->
                    FoodTaskList(name = name)
                }
            }
        } else {
            Text(text = "no name to showing")
        }
    }
}


@Composable
fun FoodTaskList(name: String) {
    var isExpanded by remember { mutableStateOf(false) }

//    animasi
    val animatedSizeDp by animateDpAsState(
        targetValue = if (isExpanded) 120.dp else 80.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )



    Card(
        backgroundColor = Color.DarkGray,
        modifier = Modifier
            .wrapContentHeight(align = Alignment.Top)
            .padding(15.dp)
            .fillMaxWidth(),
        elevation = 12.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.padding(7.dp)

        ) {
            Card(
                elevation = 30.dp,
                modifier = Modifier
                    .size(animatedSizeDp)
                    .padding(4.dp),
            ) {
//                val imageBitmap = ImageBitmap.imageResource(id = R.drawable.ic_launcher_foreground)
                Image(
                    painter = painterResource(id = R.drawable.ramen),
                    contentDescription = "Food one",
                    contentScale = ContentScale.Crop,
                )
            }

            Column(
//                mengatur width untuk colum nama dan description supaya tidak oversize, biar lebih reponsive
                Modifier.weight(1f)
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h6,
                    color = Color.White,
                )
                Text(
                    textAlign = TextAlign.Start,
                    text = "this is your name and i will m uhugiguyfytdcyvy fy",
                    style = MaterialTheme.typography.body2,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
            }
            IconButton(onClick = { isExpanded = !isExpanded }) {
                Icon(
                    imageVector = if (isExpanded) Icons.Outlined.KeyboardArrowUp else Icons.Outlined.KeyboardArrowDown,
                    contentDescription = if (isExpanded) "Show Less" else "Show More",
                    tint = Color.White,
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewContent() {
    FoodDataTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            ScreenFood(nameInterest)
        }
    }
}


