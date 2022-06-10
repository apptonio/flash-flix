package edu.rit.flashflix.data.remote


import edu.rit.flashflix.data.model.Movie
import edu.rit.flashflix.data.model.ResponseWrapper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieRemoteService {

    @GET("trending/all/week?api_key=$apikey&language=en-US")
    suspend fun getTrendingMovies(): ResponseWrapper<Movie>

    @GET("discover/tv?api_key=$apikey&with_networks=213")
    suspend fun getOriginalMovies(): ResponseWrapper<Movie>

    @GET("movie/top_rated?api_key=$apikey&language=en-US")
    suspend fun getTopRatedMovies(): ResponseWrapper<Movie>

    @GET("discover/movie?api_key=$apikey&with_genres=28")
    suspend fun getActionMovies(): ResponseWrapper<Movie>

    @GET("discover/movie?api_key=$apikey&with_genres=35")
    suspend fun getComedyMovies(): ResponseWrapper<Movie>

    @GET("discover/movie?api_key=$apikey&with_genres=27")
    suspend fun getHorrorMovies(): ResponseWrapper<Movie>

    @GET("discover/movie?api_key=$apikey&with_genres=10749")
    suspend fun getRomanceMovies(): ResponseWrapper<Movie>

    @GET("discover/movie?api_key=$apikey&with_genres=99")
    suspend fun getDocumentaryMovies(): ResponseWrapper<Movie>

    companion object {
        private const val baseUrl = "https://api.themoviedb.org/3/"
        private const val apikey = "5c2b7efbbd8e319e76bd47c085f2d973"

        val client: MovieRemoteService = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieRemoteService::class.java)
    }
}
