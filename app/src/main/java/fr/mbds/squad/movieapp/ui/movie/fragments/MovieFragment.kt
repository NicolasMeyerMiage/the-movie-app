package fr.mbds.squad.movieapp.ui.movie.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import fr.mbds.squad.movieapp.R
import fr.mbds.squad.movieapp.databinding.FragmentMovieBinding
import fr.mbds.squad.movieapp.ui.movie.MovieViewModel
import fr.mbds.squad.movieapp.ui.movie.adapters.MovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private val movieViewModel: MovieViewModel by viewModel()
    private val args: MovieFragmentArgs by navArgs()
    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.title_movies) + " - " + args.catName

        with(movieViewModel) {
            token.observe(
                viewLifecycleOwner,
                Observer {
                    getMoviesByCategoryId(
                        args.catId,
                        getString(
                            R.string.rest_langage
                        )
                    )
                }
            )
            movies.observe(
                viewLifecycleOwner,
                Observer {
                    binding.movieList.adapter = MovieAdapter(it)
                }
            )
            error.observe(
                viewLifecycleOwner,
                Observer {
                }
            )
        }
    }
}
