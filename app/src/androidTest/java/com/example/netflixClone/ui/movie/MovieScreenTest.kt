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

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.netflixClone.data.local.database.Movie
import com.example.netflixClone.data.remote.NetworkMovie
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * UI tests for [MovieScreen].
 */
@RunWith(AndroidJUnit4::class)
class MovieScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setup() {
        composeTestRule.setContent {
            MovieScreen(FAKE_DATA, onSave = {})
        }
    }

    @Test
    fun firstItem_exists() {
        composeTestRule.onNodeWithText(FAKE_DATA.first().title, substring = true).assertExists()
    }
}

private val FAKE_DATA = listOf(
    Movie("Star Trek Picard", "https://image.tmdb.org/t/p/original/nIlAKIrLKxOeoEnc0Urb65yNCp.jpg"),
    Movie("Ant-Man and the Wasp: Quantumania", "https://image.tmdb.org/t/p/original/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg"),
    Movie("Carnival Row", "https://image.tmdb.org/t/p/original/jyhxT10e2z9IDsKoIQDKhyxSQJt.jpg")
)
