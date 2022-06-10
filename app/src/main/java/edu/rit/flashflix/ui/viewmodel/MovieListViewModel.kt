package edu.rit.flashflix.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.rit.flashflix.data.model.Movie
import edu.rit.flashflix.data.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieListViewModel(
    private val movieRepository: MovieRepository = MovieRepository()
): ViewModel() {
    val trendingData: MutableLiveData<List<Movie>> = MutableLiveData()
    val originalData: MutableLiveData<List<Movie>> = MutableLiveData()
    val topRatedData: MutableLiveData<List<Movie>> = MutableLiveData()
    val actionData: MutableLiveData<List<Movie>> = MutableLiveData()
    val comedyData: MutableLiveData<List<Movie>> = MutableLiveData()
    val horrorData: MutableLiveData<List<Movie>> = MutableLiveData()
    val romanceData: MutableLiveData<List<Movie>> = MutableLiveData()
    val documentaryData: MutableLiveData<List<Movie>> = MutableLiveData()

    init {
        getTrendingData()
        getOriginalData()
        getTopRatedData()
        getActionData()
        getComedyData()
        getHorrorData()
        getRomanceData()
        getDocumentaryData()
    }

    private fun getTrendingData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = movieRepository.getTrendingMovie()
            val movieData = response.results
            trendingData.postValue(movieData)
        }
    }

    private fun getOriginalData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = movieRepository.getOriginalMovie()
            val movieData = response.results
            originalData.postValue(movieData)
        }
    }

    private fun getTopRatedData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = movieRepository.getTopRatedMovie()
            val movieData = response.results
            topRatedData.postValue(movieData)
        }
    }

    private fun getActionData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = movieRepository.getActionMovie()
            val movieData = response.results
            actionData.postValue(movieData)
        }
    }

    private fun getComedyData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = movieRepository.getComedyMovie()
            val movieData = response.results
            comedyData.postValue(movieData)
        }
    }

    private fun getHorrorData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = movieRepository.getHorrorMovie()
            val movieData = response.results
            horrorData.postValue(movieData)
        }
    }

    private fun getRomanceData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = movieRepository.getRomanceMovie()
            val movieData = response.results
            romanceData.postValue(movieData)
        }
    }

    private fun getDocumentaryData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = movieRepository.getDocumentaryMovie()
            val movieData = response.results
            documentaryData.postValue(movieData)
        }
    }

}