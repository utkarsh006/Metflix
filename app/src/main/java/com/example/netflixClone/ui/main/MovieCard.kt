package com.example.netflixClone.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.netflixClone.data.local.database.Movie

@Composable
fun MovieCard(
    movie: Movie,
    onMovieClick: (Movie) -> Unit = { },
    startPadding: Dp = 8.dp
) {
    AsyncImage(
        model = movie.imageUrl,
        contentDescription = "Movie Poster",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .padding(start = startPadding)
            .height(135.dp)
            .width(95.dp)
            .clip(
                RoundedCornerShape(10.dp)
            )
            .clickable { onMovieClick(movie) }
    )
}