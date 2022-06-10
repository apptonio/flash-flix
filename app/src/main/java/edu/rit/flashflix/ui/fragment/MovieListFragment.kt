package edu.rit.flashflix.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import edu.rit.flashflix.R
import edu.rit.flashflix.databinding.FragmentMovieListBinding
import edu.rit.flashflix.ui.adapter.*
import edu.rit.flashflix.ui.viewmodel.MovieListViewModel

class MovieListFragment : Fragment(R.layout.fragment_movie_list) {
    private val viewModel: MovieListViewModel by activityViewModels()
    private lateinit var binding: FragmentMovieListBinding

    private val adapter = MovieAdapter { movie ->
        val direction = MovieListFragmentDirections.actionGlobalMovieDetailFragment(movie)
        findNavController().navigate(direction)
    }
    private val actionAdapter = ActionMovieAdapter { movie ->
        val direction = MovieListFragmentDirections.actionGlobalMovieDetailFragment(movie)
        findNavController().navigate(direction)
    }
    private val comedyAdapter = ComedyMovieAdapter { movie ->
        val direction = MovieListFragmentDirections.actionGlobalMovieDetailFragment(movie)
        findNavController().navigate(direction)
    }
    private val horrorAdapter = HorrorMovieAdapter { movie ->
        val direction = MovieListFragmentDirections.actionGlobalMovieDetailFragment(movie)
        findNavController().navigate(direction)
    }
    private val romanceAdapter = RomanceMovieAdapter { movie ->
        val direction = MovieListFragmentDirections.actionGlobalMovieDetailFragment(movie)
        findNavController().navigate(direction)
    }
    private val documentaryAdapter = DocumentaryMovieAdapter { movie ->
        val direction = MovieListFragmentDirections.actionGlobalMovieDetailFragment(movie)
        findNavController().navigate(direction)
    }
    private val originalAdapter = OriginalMovieAdapter { movie ->
        val direction = MovieListFragmentDirections.actionGlobalMovieDetailFragment(movie)
        findNavController().navigate(direction)
    }
    private val topRatedAdapter = TopRatedMovieAdapter { movie ->
        val direction = MovieListFragmentDirections.actionGlobalMovieDetailFragment(movie)
        findNavController().navigate(direction)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieListBinding.bind(view)

        binding.rvTrending.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvTrending.adapter = adapter

        binding.rvOriginal.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvOriginal.adapter = originalAdapter

        binding.rvTopRated.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvTopRated.adapter = topRatedAdapter

        binding.rvAction.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvAction.adapter = actionAdapter

        binding.rvComedy.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvComedy.adapter = comedyAdapter

        binding.rvHorror.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvHorror.adapter = horrorAdapter

        binding.rvRomance.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvRomance.adapter = romanceAdapter

        binding.rvDocumentary.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvDocumentary.adapter = documentaryAdapter

        viewModel.trendingData.observe(viewLifecycleOwner) { movie ->
            adapter.setData(movie)
        }
        viewModel.originalData.observe(viewLifecycleOwner) { movie ->
            originalAdapter.setData(movie)
        }

        viewModel.topRatedData.observe(viewLifecycleOwner) { movie ->
            topRatedAdapter.setData(movie)
        }

        viewModel.actionData.observe(viewLifecycleOwner) { movie ->
            actionAdapter.setData(movie)
        }

        viewModel.comedyData.observe(viewLifecycleOwner) { movie ->
            comedyAdapter.setData(movie)
        }

        viewModel.horrorData.observe(viewLifecycleOwner) { movie ->
            horrorAdapter.setData(movie)
        }

        viewModel.romanceData.observe(viewLifecycleOwner) { movie ->
            romanceAdapter.setData(movie)
        }

        viewModel.documentaryData.observe(viewLifecycleOwner) { movie ->
            documentaryAdapter.setData(movie)
        }


    }
}