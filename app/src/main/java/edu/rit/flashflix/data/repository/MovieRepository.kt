package edu.rit.flashflix.data.repository

import edu.rit.flashflix.data.model.Movie
import edu.rit.flashflix.data.model.ResponseWrapper
import edu.rit.flashflix.data.remote.MovieRemoteService

class MovieRepository(
    private val apiService: MovieRemoteService = MovieRemoteService.client
) {
    suspend fun getTrendingMovie(): ResponseWrapper<Movie> = apiService.getTrendingMovies()
    suspend fun getTopRatedMovie(): ResponseWrapper<Movie> = apiService.getTopRatedMovies()
    suspend fun getOriginalMovie(): ResponseWrapper<Movie> = apiService.getOriginalMovies()
    suspend fun getActionMovie(): ResponseWrapper<Movie> = apiService.getActionMovies()
    suspend fun getComedyMovie(): ResponseWrapper<Movie> = apiService.getComedyMovies()
    suspend fun getHorrorMovie(): ResponseWrapper<Movie> = apiService.getHorrorMovies()
    suspend fun getRomanceMovie(): ResponseWrapper<Movie> = apiService.getRomanceMovies()
    suspend fun getDocumentaryMovie(): ResponseWrapper<Movie> = apiService.getDocumentaryMovies()

}