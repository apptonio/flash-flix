package edu.rit.flashflix.data.repository

import android.content.Context
import androidx.room.Room
import edu.rit.flashflix.data.local.MovieDatabase
import edu.rit.flashflix.data.model.Movie

class FavoritesRepository(applicationContext: Context) {

    private val db = Room.databaseBuilder(
        applicationContext,
        MovieDatabase::class.java,
        "movie-db"
    ).build()

    private val movieDao = db.movieDao()

    suspend fun isInFavorites(movie: Movie) = movieDao.getById(movie.id) != null

    suspend fun getAllMovies() = movieDao.getAll()

    suspend fun add(movie: Movie) = movieDao.insert(movie)

    suspend fun remove(movie: Movie) = movieDao.delete(movie)
}