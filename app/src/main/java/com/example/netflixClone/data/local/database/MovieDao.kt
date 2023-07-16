package com.example.netflixClone.data.local.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: Movie): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<Movie>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieWithCategory(crossReference: MovieCategoryCrossRef): Long

    @Query("")
    @Transaction
    suspend fun insertMovieWithCategories(movie: Movie, categories: List<Category>) {
        insertMovie(movie)
        categories.forEach {
            insertCategory(it)
            insertMovieWithCategory(MovieCategoryCrossRef(it.categoryTitle, movie.movieTitle))
        }
    }

    @Query("")
    @Transaction
    suspend fun insertCategoriesWithMovies(categories: Map<Category, List<Movie>>) {
        categories.entries.forEach { map ->
            insertCategory(map.key)
            insertMovies(map.value)
            map.value.forEach {
                insertMovieWithCategory(MovieCategoryCrossRef(map.key.categoryTitle, it.movieTitle))
            }
        }
    }

    @Transaction
    @Query("SELECT * FROM category")
    fun getCategoriesWithMovies(): Flow<List<CategoryWithMovies>>

    @Query("SELECT * FROM movie WHERE movie.isNetflixOnly = true")
    fun getNetflixExclusives(): Flow<List<Movie>>

    @Query("SELECT * FROM movie WHERE movie.percentFinished > 0")
    fun getInProgress(): Flow<List<Movie>>

    //TODO: This should only be used with small datasets - query would need to be revised for production use.
    @Query("SELECT * FROM movie ORDER BY RANDOM() LIMIT 1")
    fun getRandomMovie(): Flow<Movie>
}