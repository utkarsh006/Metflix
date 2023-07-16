package com.example.netflixClone.ui.main

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflixClone.R
import com.example.netflixClone.data.local.database.Movie

@Preview
@Composable
fun MovieDetailBottomSheet(movie: Movie = Movie("", ""), onClose: () -> Unit = {}) {
    Surface(
        color = colorResource(id = R.color.bottom_sheet_background),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(Modifier.fillMaxWidth()) {
                MovieCard(movie, {}, 0.dp)
                // Movie Description
                Column(
                    Modifier
                        .weight(1f)
                        .padding(start = 8.dp)
                ) {
                    Text(
                        text = movie.movieTitle,
                        fontSize = 24.sp,
                        maxLines = 2,
                        color = Color.White
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        ProvideTextStyle(
                            value = TextStyle(
                                fontSize = 12.sp,
                                color = colorResource(id = R.color.bottom_sheet_button_text)
                            )
                        ) {
                            Text(text = "2017")
                            Text(text = "TV_MA")
                            Text(text = "1h 22m")
                        }
                    }
                    Text(
                        text = "This docuseries traces the history of classic video games, featuring insights from the innovators who brought these" +
                                " worlds and characters to life.",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
                CircularImageButton(R.drawable.ic_baseline_close_24, 24.dp, "Close", onClose)
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp, top = 24.dp)
            ) {
                ImageTextButton(
                    id = R.drawable.ic_baseline_play_arrow_24,
                    text = "Play",
                    size = 42.dp
                )
                ImageTextButton(
                    id = R.drawable.ic_baseline_file_download_24,
                    text = "Download",
                    size = 42.dp
                )
                ImageTextButton(id = R.drawable.ic_baseline_add_24, text = "My List", size = 42.dp)
                ImageTextButton(id = R.drawable.ic_outline_share_24, text = "Share", size = 42.dp)
            }
            Divider(color = colorResource(id = R.color.bottom_sheet_divider))
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 12.dp)
                    .clickable { }) {
                Icon(
                    painter = painterResource(R.drawable.ic_outline_info_24),
                    contentDescription = "Details & More",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Details & More", color = Color.White)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                    contentDescription = "Details & More",
                    tint = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
private fun CircularImageButton(
    @DrawableRes id: Int = R.drawable.ic_baseline_add_24,
    size: Dp = 50.dp,
    contentDescription: String = "Test",
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.bottom_sheet_button_background)),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        elevation = null,
        modifier = Modifier.size(size)
    ) {
        Image(
            painterResource(id = id), contentDescription = contentDescription
        )
    }
}

@Preview
@Composable
private fun ImageTextButton(
    @DrawableRes id: Int = R.drawable.ic_baseline_add_24,
    text: String = "Test",
    size: Dp = 50.dp,
    contentDescription: String = text
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CircularImageButton(id, size, contentDescription)
        Text(
            text = text,
            color = colorResource(id = R.color.bottom_sheet_button_text),
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}