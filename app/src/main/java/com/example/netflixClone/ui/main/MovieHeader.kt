package com.example.netflixClone.ui.main

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.netflixClone.R
import com.example.netflixClone.data.local.database.Movie

@Preview
@Composable
fun MovieHeader(movie: Movie? = Movie("", ""), onClick: (Movie) -> Unit = {}) {
    Box(modifier = Modifier.wrapContentHeight()) {
        movie?.let {
            AsyncImage(
                model = movie.imageUrl,
                contentDescription = movie.movieTitle,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(it) }
            )
        }
        // Contains the tags and buttons at the bottom of the movie image
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = .1f))
                .align(Alignment.BottomCenter)
                .padding(top = 12.dp)
        ) {
            HeaderTags()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 24.dp, start = 12.dp, end = 12.dp)
            ) {

                TextButton(
                    id = R.drawable.ic_baseline_add_24,
                    stringResource(id = R.string.my_list)
                )
                PlayButton()
                TextButton(
                    id = R.drawable.ic_outline_info_24,
                    text = stringResource(id = R.string.info)
                )
            }
        }
    }
}

@Composable()
fun TextButton(@DrawableRes id: Int, text: String, contentDescription: String = text) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painterResource(id = id),
                contentDescription = contentDescription,
                modifier = Modifier.size(30.dp)
            )

            Text(text = text, color = Color.White, fontSize = 8.sp)
        }
    }
}

@Composable()
fun PlayButton() {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 0.dp),
        modifier = Modifier.padding(top = 8.dp)
    ) {
        val play = stringResource(id = R.string.play)
        Image(
            painterResource(id = R.drawable.ic_baseline_play_arrow_24),
            contentDescription = play,
            colorFilter = ColorFilter.tint(Color.DarkGray),
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = play,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 4.dp),
            color = Color.DarkGray,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

//TODO: Add tags to the data model
@Preview
@Composable
fun HeaderTags() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        ProvideTextStyle(value = TextStyle(fontSize = 12.sp, color = Color.White)) {
            Text("Explosive")
            CircleSeparator()
            Text("Exciting")
            CircleSeparator()
            Text("Action Thriller")
            CircleSeparator()
            Text("Heist Movie")
        }
    }
}

@Preview
@Composable
fun CircleSeparator() {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(4.dp)
            .clip(CircleShape)
            .background(Color.White)
    )
}
