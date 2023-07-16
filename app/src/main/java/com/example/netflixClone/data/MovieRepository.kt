package com.example.netflixClone.data

import com.example.netflixClone.data.local.database.*
import com.example.netflixClone.data.remote.network.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

interface MovieRepository {
    val movies: Flow<List<CategoryWithMovies>>
    val headerMovie: Flow<Movie?>
    suspend fun fetchMovies(): Response<List<NetworkMovie>>
}

class DefaultMovieRepository @Inject constructor(
    @Named("FakeMovieService") private val movieService: MovieApi, private val movieDao: MovieDao
) : MovieRepository {

    // Combine the default categories with property based filters
    override val movies: Flow<List<CategoryWithMovies>> = combineTransform(
        movieDao.getCategoriesWithMovies(),
        movieDao.getNetflixExclusives(),
        movieDao.getInProgress()
    ) { categories: List<CategoryWithMovies>, exclusives: List<Movie>, inProgress: List<Movie> ->
        val exclusiveCategory =
            CategoryWithMovies(Category(categoryTitle = "Only on Netflix"), exclusives)
        val inProgressCategory =
            CategoryWithMovies(Category(categoryTitle = "In Progress"), inProgress)
        emit(listOf(inProgressCategory, exclusiveCategory) + categories)
    }

    override val headerMovie: Flow<Movie?> = movieDao.getRandomMovie()

    override suspend fun fetchMovies(): Response<List<NetworkMovie>> {
        val response = movieService.getMovies()

        // Cache movies locally if none exist
        if (response.isSuccessful) {
            coroutineScope {
                if (movieDao.getCategoriesWithMovies().firstOrNull().isNullOrEmpty()) {
                    response.body()!!.forEach { networkMovie ->
                        movieDao.insertMovieWithCategories(
                            networkMovie.toLocalMovie(),
                            networkMovie.categories.map { it.toLocalCategory() })
                    }
                }
            }
        }

        return response
    }
}
