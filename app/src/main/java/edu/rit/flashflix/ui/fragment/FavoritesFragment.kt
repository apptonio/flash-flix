package edu.rit.flashflix.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.rit.flashflix.R
import edu.rit.flashflix.data.repository.FavoritesRepository
import edu.rit.flashflix.databinding.FragmentFavoritesBinding
import edu.rit.flashflix.ui.adapter.MovieAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private lateinit var binding: FragmentFavoritesBinding
    private lateinit var repo: FavoritesRepository

    private val adapter = MovieAdapter { movie ->
        val direction = FavoritesFragmentDirections.actionGlobalMovieDetailFragment(movie)
        findNavController().navigate(direction)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoritesBinding.bind(view)
        repo = FavoritesRepository(requireContext())

        binding.rvFavorites.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvFavorites.adapter = adapter

        lifecycleScope.launch(Dispatchers.Main) {

            val data = withContext(Dispatchers.IO){
                repo.getAllMovies()
            }
            adapter.setData(data)
            if(data.isEmpty()){
            binding.rvFavoritesTitle.text = "Favorites are empty"}else
            { binding.rvFavoritesTitle.text = "Favorites"}
        }
    }
}