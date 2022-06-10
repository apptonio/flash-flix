package edu.rit.flashflix.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import edu.rit.flashflix.R
import edu.rit.flashflix.data.repository.FavoritesRepository
import edu.rit.flashflix.databinding.FragmentMovieDetailBinding
import edu.rit.flashflix.utils.loadUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {
    private lateinit var binding: FragmentMovieDetailBinding
    private val args: MovieDetailFragmentArgs by navArgs()
    private lateinit var favoritesRepository: FavoritesRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailBinding.bind(view)

        favoritesRepository = FavoritesRepository(requireContext())

        binding.tvMovieName.text = args.movie.title
        if (args.movie.title.isNullOrEmpty()){
            binding.tvMovieName.text = args.movie.name
        }
        binding.tvMovieOverview.text = args.movie.overview
        binding.ivMovie.loadUrl("https://image.tmdb.org/t/p/original" + args.movie.backdrop_path)
        binding.tvMovieRating.text = "Rating: " + args.movie.vote_average.toString()

        binding.btnToggleFavorites.setOnClickListener { toggleFavorite() }
        (requireActivity() as AppCompatActivity).supportActionBar?.title = args.movie.title
        if (args.movie.title.isNullOrEmpty()){
            (requireActivity() as AppCompatActivity).supportActionBar?.title = args.movie.name
        }

        updateButtonText()

    }

    private fun updateButtonText() {
        lifecycleScope.launch(Dispatchers.IO) {
            val isInFavorites = favoritesRepository.isInFavorites(args.movie)
            val btnText = if(isInFavorites) "Unfavorite" else "Favorite"

            withContext(Dispatchers.Main) {
                binding.btnToggleFavorites.text = btnText
            }
        }
    }

    private fun toggleFavorite() {
        lifecycleScope.launch(Dispatchers.IO) {
            val isInFavorites = favoritesRepository.isInFavorites(args.movie)

            if(isInFavorites) {
                favoritesRepository.remove(args.movie)
            } else {
                favoritesRepository.add(args.movie)
            }

            updateButtonText()
        }
    }
}