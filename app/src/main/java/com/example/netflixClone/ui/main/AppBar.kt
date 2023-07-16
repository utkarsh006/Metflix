package com.example.netflixClone.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.netflixClone.R

@Preview
@Composable
fun AppBar(topPadding: MutableState<Int> = mutableStateOf(107)) {
    Surface(
        color = Color.Black.copy(alpha = .1f),
        modifier = Modifier.wrapContentHeight()
    ) {
        val paddingPixels = topPadding.value
        val paddingDp = with(LocalDensity.current) { paddingPixels.toDp() }
        // App Bar Rows
        Column(modifier = Modifier.padding(top = paddingDp)) {
            Row(modifier = Modifier.height(48.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.netflix_icon),
                    contentDescription = "Netflix", modifier = Modifier.size(54.dp)
                )

                // Contains action icons
                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_cast_24),
                        contentDescription = "Chromecast",
                        modifier = Modifier.padding(12.dp),
                        tint = Color.White,
                    )
                    Icon(
                        Icons.Rounded.Search,
                        contentDescription = "Search",
                        modifier = Modifier.padding(12.dp),
                        tint = Color.White
                    )
                }
            }

            // Netflix Filters
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .height(48.dp)
                    .padding(top = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "TV Shows")
                Text(text = "Movies")
                Row {
                    Text(text = "Categories")
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_drop_down_24),
                        contentDescription = "expand"
                    )
                }
            }
        }
    }
}