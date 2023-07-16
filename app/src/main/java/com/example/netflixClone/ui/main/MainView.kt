package com.example.netflixClone.ui.main

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.netflixClone.data.di.fakeMovies
import com.example.netflixClone.data.local.database.CategoryWithMovies
import com.example.netflixClone.data.local.database.Movie
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainView(
    viewModel: MainViewModel = hiltViewModel(),
    statusBarHeight: MutableState<Int> = mutableStateOf(107)
) {
    val categories = viewModel.categories.collectAsState(initial = emptyList()).value
    val header = viewModel.header.collectAsState(initial = null).value
    val state = viewModel.state.collectAsState(initial = MainState.Loading).value

    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    var currentlySelectedMovie by remember { mutableStateOf(Movie("", "")) }

    val coroutineScope = rememberCoroutineScope()

    if (state is MainState.Success) {
        ModalBottomSheetLayout(sheetState = bottomSheetState, sheetContent = {
            MovieDetailBottomSheet(currentlySelectedMovie) {
                coroutineScope.launch {
                    bottomSheetState.hide()
                }
            }
        }) {
            ContentView(statusBarHeight, header, categories) {
                val isNewMovie = it != currentlySelectedMovie
                currentlySelectedMovie = it

                val transform = if (!isNewMovie && bottomSheetState.isVisible) {
                    suspend { bottomSheetState.hide() }
                } else {
                    suspend { bottomSheetState.show() }
                }

                coroutineScope.launch { transform() }
            }
        }
    } else Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(24.dp)
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        Text("Loading or Error") // TODO: Could create a good loading state or error handling
    }


}

@Composable
private fun ContentView(
    topPadding: MutableState<Int>,
    headerMovie: Movie?,
    categories: List<CategoryWithMovies>,
    onMovieClick: (Movie) -> Unit = {}
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart,
    ) {
        LazyColumn(Modifier.background(Color.Black)) {
            item {
                MovieHeader(headerMovie, onMovieClick)
            }
            nestedCategoryList(categories, onMovieClick)
        }
        AppBar(topPadding)
        BottomBar(Modifier.align(Alignment.BottomCenter))
    }
}

@Preview()
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HorizontalMovieList(movies: List<Movie> = fakeMovies, onMovieClick: (Movie) -> Unit = {}) {
    LazyRow {
        items(movies.size) { index ->
            MovieCard(movies[index], onMovieClick)
        }
    }
}

@Preview()
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MovieListTitle(text: String = "Popular on Netflix") {
    Text(
        text,
        fontSize = 17.sp,
        fontWeight = FontWeight.ExtraBold,
        color = Color.White,
        modifier = Modifier.padding(8.dp)
    )
}

fun LazyListScope.nestedCategoryList(
    categories: List<CategoryWithMovies>,
    onMovieClick: (Movie) -> Unit
) {
    items(categories) { category ->
        MovieListTitle(category.category.categoryTitle)
        HorizontalMovieList(category.movies, onMovieClick)
    }
}