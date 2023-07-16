/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.netflixClone.ui.movie

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import com.example.netflixClone.data.MovieRepository
import com.example.netflixClone.data.local.database.Movie
import com.example.netflixClone.data.remote.FakeMovieService
import com.example.netflixClone.data.remote.TestMovieService

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class) // TODO: Remove when stable
class MovieViewModelTest {
    @Test
    fun uiState_initiallyLoading() = runTest {
        val viewModel = MovieViewModel(FakeMovieRepository(), TestMovieService())
        assertEquals(viewModel.uiState.first(), MovieUiState.Loading)
    }

    @Test
    fun uiState_onItemSaved_isDisplayed() = runTest {
        val viewModel = MovieViewModel(FakeMovieRepository(), TestMovieService())
        assertEquals(viewModel.uiState.first(), MovieUiState.Loading)
    }
}

private class FakeMovieRepository : MovieRepository {

    private val data = mutableListOf<Movie>()

    override val movies: Flow<List<Movie>>
        get() = flow { emit(data.toList()) }

    override suspend fun add(title: String, imageUrl: String) {
        data.add(Movie(title, imageUrl))
    }
}
