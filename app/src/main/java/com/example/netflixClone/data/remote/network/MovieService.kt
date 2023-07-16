package com.example.netflixClone.data.remote.network

import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {
    @GET("/movies")
    suspend fun getMovies(): Response<List<NetworkMovie>>
}

class FakeMovieService : MovieApi {

    override suspend fun getMovies(): Response<List<NetworkMovie>> {
        return Response.success(fakeNetworkMovieResponse)
    }
}

val fakeNetworkMovieResponse = listOf(
    NetworkMovie(
        "2 Guns",
        "https://m.media-amazon.com/images/M/MV5BY2JhZTRlYzYtZmI1OS00NTRhLWFjNGYtNzI1ODJmNmZhZGU1XkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_Ratio1.0000_AL_.jpg",
        categories = listOf(NetworkCategory.Movies)
    ),
    NetworkMovie(
        "Inception",
        "https://image.tmdb.org/t/p/original/uoeYeDKCaxcjgZdal4r5UcQrSYD.jpg",
        categories = listOf(NetworkCategory.Movies)
    ),
    NetworkMovie(
        "The Mandalorian",
        "https://image.tmdb.org/t/p/original/eU1i6eHXlzMOlEq0ku1Rzq7Y4wA.jpg",
        categories = listOf(NetworkCategory.NewReleases),
        percentFinished = .67f
    ),
    NetworkMovie(
        "Creed III",
        "https://image.tmdb.org/t/p/original/cvsXj3I9Q2iyyIo95AecSd1tad7.jpg",
        categories = listOf(NetworkCategory.Movies, NetworkCategory.NewReleases)
    ),
    NetworkMovie(
        "Daisy Jones & the Six",
        "https://image.tmdb.org/t/p/original/3zydLxmSci1mxgA4huzBSiEpWAO.jpg",
        categories = listOf(NetworkCategory.TvShows),
        isNetflixOnly = true
    ),
    NetworkMovie(
        "Operation Fortune: Ruse de guerre",
        "https://image.tmdb.org/t/p/original/bQrNm5WIWUpCOwMbyz2PwbM8Lxp.jpg",
        categories = listOf(NetworkCategory.Movies)
    ),
    NetworkMovie(
        "Perry Mason",
        "https://image.tmdb.org/t/p/original/3i8mKy0dDDszSxe8Lltvza3Kkma.jpg",
        categories = listOf(NetworkCategory.BecauseYouWatched),
        isNetflixOnly = true
    ),
    NetworkMovie(
        "Scream VI",
        "https://image.tmdb.org/t/p/original/t2NEaFrNFRCrBIyAETlz5sqq15H.jpg",
        categories = listOf(NetworkCategory.Movies, NetworkCategory.NewReleases),
        percentFinished = .24f
    ),
    NetworkMovie(
        "Gotham Knights",
        "https://image.tmdb.org/t/p/original/tbCGmkR3TRDug4weDnHEGCu3WEC.jpg",
        categories = listOf(NetworkCategory.TvShows, NetworkCategory.BecauseYouWatched),
        isNetflixOnly = true
    ),
    NetworkMovie(
        "Superman & Lois",
        "https://image.tmdb.org/t/p/original/vlv1gn98GqMnKHLSh0dNciqGfBl.jpg",
        categories = listOf(NetworkCategory.Movies, NetworkCategory.BecauseYouWatched)
    ),
    NetworkMovie(
        "Ted Lasso",
        "https://image.tmdb.org/t/p/original/7NS4VYNTm2J1XQk5OVUwImbV4vZ.jpg",
        categories = listOf(NetworkCategory.TvShows),
        percentFinished = .32f,
        isNetflixOnly = true
    ),
    NetworkMovie(
        "Shadow and Bone",
        "https://image.tmdb.org/t/p/original/u9dI2EiGeJRlioPvT3mi4kzrji8.jpg",
        categories = listOf(NetworkCategory.Movies)
    ),
    NetworkMovie(
        "Shazam! Fury of the Gods",
        "https://image.tmdb.org/t/p/original/zpCCTtuQMHiHycpsrWnW2eCrBql.jpg",
        categories = listOf(NetworkCategory.Movies)
    ),
    NetworkMovie(
        "Star Trek: Discovery",
        "https://image.tmdb.org/t/p/original/ihvG9dCEnVU3gmMUftTkRICNdJf.jpg",
        categories = listOf(NetworkCategory.TvShows)
    ),
    NetworkMovie(
        "The Tourist",
        "https://image.tmdb.org/t/p/original/9vKkRooP5ehhfAhzORFkkSRhkvZ.jpg",
        categories = listOf(NetworkCategory.TvShows)
    ),
    NetworkMovie(
        "The Rig", "https://image.tmdb.org/t/p/original/buRe826xkgyU95nyMaDMuCNxfQn.jpg",
        categories = listOf(NetworkCategory.TrendingNow)
    ),
    NetworkMovie(
        "When Calls the Heart",
        "https://image.tmdb.org/t/p/original/j8h79hTrOaSXBKRD25pTT6pEIHY.jpg",
        categories = listOf(NetworkCategory.TrendingNow)
    ),
    NetworkMovie(
        "CSI: Vegas",
        "https://image.tmdb.org/t/p/original/7x1DwPyjVCFekAj6QBeS6DIOODf.jpg",
        categories = listOf(NetworkCategory.TvShows)
    ),
    NetworkMovie(
        "NCIS", "https://image.tmdb.org/t/p/original/fi8EvaWtL5CvoielOjjVvTr7ux3.jpg",
        categories = listOf(NetworkCategory.TvShows)
    ),
    NetworkMovie("Tehran", "https://image.tmdb.org/t/p/original/pXV1fcIQIbpTNYRJ47rfUvG6hq4.jpg"),
    NetworkMovie(
        "That '90s Show",
        "https://image.tmdb.org/t/p/original/nZcufEuqZqNYMx6mNjlh2rmjDqx.jpg",
        categories = listOf(NetworkCategory.NewReleases, NetworkCategory.TvShows)
    ),
    NetworkMovie(
        "1923", "https://image.tmdb.org/t/p/original/u7Fu90Ztuvb9rkfbHjDzfyKai5W.jpg",
        categories = listOf(NetworkCategory.Movies, NetworkCategory.NewReleases)
    ),
    NetworkMovie(
        "The Mighty Ducks: Game Changers",
        "https://image.tmdb.org/t/p/original/s0o1n6PrpfDro2CU0br1wiH4wni.jpg",
        categories = listOf(NetworkCategory.NewReleases)
    ),
    NetworkMovie(
        "Poker Face",
        "https://image.tmdb.org/t/p/original/nsOtuGh2psp0aRnUBQgePlLCfM6.jpg",
        categories = listOf(NetworkCategory.TrendingNow)
    ),
    NetworkMovie(
        "Uncoupled", "https://image.tmdb.org/t/p/original/SbgLxilyL5d5F4ghy8MabVJK6g.jpg",
        categories = listOf(NetworkCategory.TvShows)
    ),
    NetworkMovie("Avenue 5", "https://image.tmdb.org/t/p/original/inSe4HBqnwIoeqoChGlagVs0avG.jpg"),
    NetworkMovie(
        "Mayfair Witches",
        "https://image.tmdb.org/t/p/original/59GtePk4e8wTUl7Ukfaq8SAADqA.jpg",
        categories = listOf(NetworkCategory.TvShows, NetworkCategory.BecauseYouWatched)
    ),
    NetworkMovie(
        "The Terminal List",
        "https://image.tmdb.org/t/p/original/jbyaKYNexl1poKZnEmB6Qobn60s.jpg",
        categories = listOf(NetworkCategory.Movies, NetworkCategory.NewReleases)
    ),
    NetworkMovie(
        "Hit Monkey",
        "https://image.tmdb.org/t/p/original/1aK7hApRSDUv8xxDQXyQil7qBjN.jpg",
        categories = listOf(NetworkCategory.TvShows, NetworkCategory.BecauseYouWatched)
    ),
    NetworkMovie(
        "Night Court",
        "https://image.tmdb.org/t/p/original/aDgsyosno3aKCiAn0UoUuw6HNME.jpg",
        categories = listOf(NetworkCategory.TvShows, NetworkCategory.BecauseYouWatched)
    ),
    NetworkMovie(
        "The Blacklist",
        "https://image.tmdb.org/t/p/original/7WCNaek6zGlhum99TA63QmVPhox.jpg",
        categories = listOf(NetworkCategory.TvShows, NetworkCategory.BecauseYouWatched)
    ),
    NetworkMovie(
        "Pennyworth",
        "https://image.tmdb.org/t/p/original/sF14a0UUhdLmDMv5vQ3QudoM31w.jpg",
        categories = listOf(NetworkCategory.PopularOnNetflix)
    ),
    NetworkMovie(
        "Kindred", "https://image.tmdb.org/t/p/original/iSrPT4PQmrVDGdp55cCShrpBMlj.jpg",
        categories = listOf(NetworkCategory.CasualViewing)
    ),
    NetworkMovie(
        "La Brea", "https://image.tmdb.org/t/p/original/wEo5pzSZ3MF4EzNvY2R1OZNX266.jpg",
        categories = listOf(NetworkCategory.PopularOnNetflix)
    ),
    NetworkMovie(
        "Power Book II: Ghost",
        "https://image.tmdb.org/t/p/original/d19ngys1wsOCGHzLO33tcJgA8dZ.jpg",
        categories = listOf(NetworkCategory.TvShows, NetworkCategory.PopularOnNetflix)
    ),
    NetworkMovie(
        "Extraordinary",
        "https://image.tmdb.org/t/p/original/onp2UrYrvkHphkrCq8wKFflmlKl.jpg",
        categories = listOf(NetworkCategory.TvShows)
    ),
    NetworkMovie(
        "Shrinking",
        "https://image.tmdb.org/t/p/original/49fghnycvR5NgJk8vlCneuj9TER.jpg",
        categories = listOf(NetworkCategory.PopularOnNetflix),
        percentFinished = .43f,
        isNetflixOnly = true
    ),
    NetworkMovie(
        "Will Trent",
        "https://image.tmdb.org/t/p/original/qqMh6R7lDJ0ny3yB3bchLCHO79g.jpg",
        categories = listOf(NetworkCategory.Documentaries)
    ),
    NetworkMovie(
        "Babylon", "https://image.tmdb.org/t/p/original/eKEk1w1aO7YWESer1vnxVE96qvN.jpg",
        categories = listOf(NetworkCategory.PopularOnNetflix),
        percentFinished = .78f
    ),
    NetworkMovie(
        "The Banshees of Inisherin",
        "https://image.tmdb.org/t/p/original/5Y0AINkH7xDqmuxJXUQdPbtyrub.jpg",
        categories = listOf(NetworkCategory.Documentaries)
    ),
    NetworkMovie(
        "A Man Called Otto",
        "https://image.tmdb.org/t/p/original/130H1gap9lFfiTF9iDrqNIkFvC9.jpg",
        categories = listOf(NetworkCategory.CasualViewing)
    ),
    NetworkMovie(
        "Avatar: The Way of Water",
        "https://image.tmdb.org/t/p/original/t6HIqrRAclMCA60NsSmeqe9RmNV.jpg",
        categories = listOf(NetworkCategory.Movies, NetworkCategory.PopularOnNetflix),
        percentFinished = .99f
    ),
    NetworkMovie(
        "The Menu", "https://image.tmdb.org/t/p/original/1L8suifzjMrJ3DxApr8yAQRWrDB.jpg",
        categories = listOf(NetworkCategory.TvShows, NetworkCategory.PopularOnNetflix)
    ),
    NetworkMovie(
        "Triangle of Sadness",
        "https://image.tmdb.org/t/p/original/nZ3Hrt0EMCAOGTEWfwYFJirAUZa.jpg",
        categories = listOf(NetworkCategory.CasualViewing)
    ),
    NetworkMovie(
        "Aftersun", "https://image.tmdb.org/t/p/original/jeXmhP2zbUkREMRqFOYIwQOk49T.jpg",
        categories = listOf(NetworkCategory.CasualViewing)
    ),
    NetworkMovie(
        "You",
        "https://image.tmdb.org/t/p/original/aqNj9RgcMjicLfm1LGpmDY7UEiM.jpg",
        categories = listOf(NetworkCategory.TvShows, NetworkCategory.TrendingNow),
        isNetflixOnly = true
    ),
    NetworkMovie(
        "Wednesday",
        "https://image.tmdb.org/t/p/original/9PFonBhy4cQy7Jz20NpMygczOkv.jpg",
        isNetflixOnly = true
    ),
    NetworkMovie(
        "Puss in Boots: The Last Wish",
        "https://image.tmdb.org/t/p/original/kuf6dutpsT0vSVehic3EZIqkOBt.jpg",
        categories = listOf(NetworkCategory.Movies, NetworkCategory.Documentaries)
    ),
    NetworkMovie(
        "Attack on Titan",
        "https://m.media-amazon.com/images/M/MV5BNDFjYTIxMjctYTQ2ZC00OGQ4LWE3OGYtNDdiMzNiNDZlMDAwXkEyXkFqcGdeQXVyNzI3NjY3NjQ@._V1_.jpg",
        categories = listOf(NetworkCategory.CasualViewing)
    ),
    NetworkMovie(
        "Glass Onion",
        "https://image.tmdb.org/t/p/original/5nCKuujRB0bpppQGu07DqmNF5cC.jpg",
        categories = listOf(NetworkCategory.CasualViewing)
    ),
    NetworkMovie(
        "Star Trek Picard",
        "https://image.tmdb.org/t/p/original/nIlAKIrLKxOeoEnc0Urb65yNCp.jpg",
        categories = listOf(NetworkCategory.TvShows)
    ),
    NetworkMovie(
        "Ant-Man and the Wasp: Quantumania",
        "https://image.tmdb.org/t/p/original/ngl2FKBlU4fhbdsrtdom9LVLBXw.jpg",
        categories = listOf(NetworkCategory.Movies)
    ),
    NetworkMovie(
        "Carnival Row",
        "https://image.tmdb.org/t/p/original/jyhxT10e2z9IDsKoIQDKhyxSQJt.jpg",
        categories = listOf(NetworkCategory.TrendingNow)
    ),
    NetworkMovie(
        "Outer Banks",
        "https://image.tmdb.org/t/p/original/ovDgO2LPfwdVRfvScAqo9aMiIW.jpg",
        categories = listOf(NetworkCategory.TrendingNow),
        isNetflixOnly = true
    ),
    NetworkMovie(
        "The Consultant",
        "https://image.tmdb.org/t/p/original/thqmhjLaMf2n0Ebl7oLRjH6VD15.jpg",
        categories = listOf(NetworkCategory.Documentaries)
    ),
    NetworkMovie(
        "The Last of Us",
        "https://image.tmdb.org/t/p/original/uKvVjHNqB5VmOrdxqAt2F7J78ED.jpg",
        categories = listOf(NetworkCategory.PopularOnNetflix),
        isNetflixOnly = true,
        percentFinished = .45f
    ),
    NetworkMovie(
        "Knock at the Cabin",
        "https://image.tmdb.org/t/p/original/dm06L9pxDOL9jNSK4Cb6y139rrG.jpg",
        categories = listOf(NetworkCategory.CasualViewing)
    ),
    NetworkMovie(
        "80 for Brady",
        "https://image.tmdb.org/t/p/original/jixBLmH4gQuTKTenZr89egvqZbW.jpg",
        categories = listOf(NetworkCategory.CasualViewing)
    )
)