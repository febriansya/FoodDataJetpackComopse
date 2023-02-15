package com.example.fooddata.presentation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddata.BuildConfig
import com.example.fooddata.R
import com.example.fooddata.presentation.ui.theme.CustomShape
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
    var showMenu by remember { mutableStateOf(false) }
    Scaffold(
//        atur topbar
        topBar = {
//            default topbar
//            TopAppBar(
//                title = {
//                    Text(text = "Food Favorite")
//                },
//            )

//        custom topbar
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .height(80.dp)
//                    .fillMaxWidth()
//                    .background(color = MaterialTheme.colors.primary)
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.fastfood),
//                    contentDescription = "topbar",
//                    modifier = Modifier.height(
//                        40.dp
//                    )
//                )
//            }
//


//            slot based layout topbar
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                    }
                },

                title = {
                    Text("Favorite Food")
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
                    }
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More")
                    }
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        DropdownMenuItem(onClick = {}) {
                            Text(text = "Call me")
                        }
                    }

                }
            )
        },


//        atur floating action button
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        },

        ) { innerPadding ->
        Column(
            modifier = Modifier
//
                .padding(innerPadding)
                .fillMaxSize()
        ) {
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
}


@Composable
fun FoodTaskList(name: String) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }

//    animasi mengubah ukuran dari card dimana di dalamnya terdapat image
    val animatedSizeDp by animateDpAsState(
        targetValue = if (isExpanded) 120.dp else 80.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Card(
        backgroundColor = Color.DarkGray,
        shape = CustomShape.medium,
        modifier = Modifier
            .wrapContentHeight(align = Alignment.Top)
            .padding(15.dp)
            .fillMaxWidth(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.padding(7.dp)

        ) {
            Card(
                backgroundColor = MaterialTheme.colors.onSecondary,
                elevation = 30.dp,
                modifier = Modifier
                    .padding(4.dp)
                    .size(animatedSizeDp)

            ) {
//                val imageBitmap = ImageBitmap.imageResource(id = R.drawable.ic_launcher_foreground)
                Image(
                    painter = painterResource(id = R.drawable.ramen),
                    contentDescription = "Food one",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.clip(CircleShape)
                )
            }

            Column(
//                mengatur width untuk colum nama dan description supaya tidak oversize, biar lebih reponsive
                Modifier.weight(2f),
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.h6,
                    color = Color.White,
                )
                Text(
                    textAlign = TextAlign.Start,
                    text = "this is your name and i will m uhugiguyfytdcyvy fy",
                    style = MaterialTheme.typography.body2.copy(
                        fontStyle = FontStyle.Italic
                    ),
                    maxLines = if (isExpanded) 2 else 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
            }
            IconButton(onClick = { isExpanded = !isExpanded }, Modifier.weight(1f, true)) {
                Icon(
//                    offset digunakan untuk mengatur supaya keluar dari letak yang telah ditentukan
                    modifier = Modifier.offset(x = 12.dp, y = 12.dp),
                    imageVector = if (isExpanded) Icons.Outlined.KeyboardArrowUp else Icons.Outlined.KeyboardArrowDown,
                    contentDescription = if (isExpanded) "Show Less" else "Show More",
                    tint = Color.White,
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Preview(showBackground = true, device = Devices.PIXEL_4, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewContent() {
    FoodDataTheme() {
        Surface(modifier = Modifier.fillMaxSize()) {
            ScreenFood(nameInterest)
        }
    }
}


