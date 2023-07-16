package com.example.netflixClone.data.di

import com.example.netflixClone.data.DefaultMovieRepository
import com.example.netflixClone.data.MovieRepository
import com.example.netflixClone.data.local.database.Movie
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindsMovieRepository(movieRepository: DefaultMovieRepository): MovieRepository
}

val fakeMovies = listOf(
    Movie("Star Trek Picard", "https://image.tmdb.org/t/p/original/nIlAKIrLKxOeoEnc0Urb65yNCp.jpg"),
    Movie(
        "Ant-Man and the Wasp",
        "https://image.tmdb.org/t/p/original/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg"
    ),
    Movie("Carnival Row", "https://image.tmdb.org/t/p/original/jyhxT10e2z9IDsKoIQDKhyxSQJt.jpg"),
    Movie("Outer Banks", "https://image.tmdb.org/t/p/original/ovDgO2LPfwdVRfvScAqo9aMiIW.jpg"),
    Movie("The Consultant", "https://image.tmdb.org/t/p/original/thqmhjLaMf2n0Ebl7oLRjH6VD15.jpg"),
    Movie("The Last of Us", "https://image.tmdb.org/t/p/original/uKvVjHNqB5VmOrdxqAt2F7J78ED.jpg"),
    Movie(
        "Knock the Cabin",
        "https://image.tmdb.org/t/p/original/dm06L9pxDOL9jNSK4Cb6y139rrG.jpg"
    ),
    Movie("80 for Brady", "https://image.tmdb.org/t/p/original/jixBLmH4gQuTKTenZr89egvqZbW.jpg")
)
