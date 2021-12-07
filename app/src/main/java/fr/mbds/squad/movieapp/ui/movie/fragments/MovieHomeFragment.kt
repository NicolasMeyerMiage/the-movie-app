package fr.mbds.squad.movieapp.ui.movie.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import fr.mbds.squad.movieapp.databinding.FragmentMovieHomeBinding
import fr.mbds.squad.movieapp.ui.movie.MovieViewModel
import fr.mbds.squad.movieapp.ui.movie.adapters.MovieCategoryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieHomeFragment : Fragment() {

    private val movieViewModel: MovieViewModel by viewModel()
    private lateinit var binding: FragmentMovieHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(movieViewModel) {
            token.observe(
                viewLifecycleOwner,
                Observer {
                    // récupérer les catégories
                    getMovieCategories()
                }
            )

            categories.observe(
                viewLifecycleOwner,
                Observer {
                    binding.categoryMovieList.adapter = MovieCategoryAdapter(it)
                }
            )

            error.observe(
                viewLifecycleOwner,
                Observer {
                    // afficher l'erreur
                }
            )
        }
    }
}
