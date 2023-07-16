package com.example.netflixClone.ui.main

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixClone.R

@Preview
@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    Surface(color = colorResource(id = R.color.bottom_bar_gray), modifier = modifier) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 8.dp, bottom = 10.dp)
            ) {
                ProvideTextStyle(value = TextStyle(fontSize = 8.sp, color = Color.Gray)) {
                    BottomBarButton(
                        id = R.drawable.ic_baseline_home_24,
                        text = "Home",
                        tint = Color.White
                    )
                    BottomBarButton(id = R.drawable.ic_outline_videogame_asset_24, text = "Games")
                    BottomBarButton(id = R.drawable.ic_outline_content_copy_24, text = "New & Hot")
                    BottomBarButton(
                        id = R.drawable.ic_outline_emoji_emotions_24,
                        text = "Fast Laughs"
                    )
                    BottomBarButton(
                        id = R.drawable.ic_baseline_arrow_circle_down_24,
                        text = "Downloads"
                    )
                }
            }
        }
    }
}

@Composable
fun BottomBarButton(
    @DrawableRes id: Int,
    text: String,
    tint: Color = Color.Gray,
    contentDescription: String = text
) {
    Surface(color = Color.Transparent, modifier = Modifier.clickable { })
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = id),
                contentDescription = contentDescription,
                tint = tint
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = text, color = tint)
        }
    }
}