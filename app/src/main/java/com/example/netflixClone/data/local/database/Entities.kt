package com.example.netflixClone.data.local.database

import androidx.room.*

@Entity
data class Movie @JvmOverloads constructor(
    @PrimaryKey
    var movieTitle: String,
    var imageUrl: String,
    var percentFinished: Float = 0f,
    var isNetflixOnly: Boolean = false
)

@Entity
data class Category(
    @PrimaryKey
    var categoryTitle: String
)

@Entity(
    primaryKeys = ["categoryTitle", "movieTitle"]
)
data class MovieCategoryCrossRef constructor(
    var categoryTitle: String,
    var movieTitle: String
)

data class CategoryWithMovies constructor(
    @Embedded var category: Category,
    @Relation(
        parentColumn = "categoryTitle",
        entityColumn = "movieTitle",
        associateBy = Junction(MovieCategoryCrossRef::class)
    )
    var movies: List<Movie>
)