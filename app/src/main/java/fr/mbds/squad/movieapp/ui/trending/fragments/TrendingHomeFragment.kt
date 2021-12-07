package fr.mbds.squad.movieapp.ui.trending.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import fr.mbds.squad.movieapp.databinding.FragmentTrendingHomeBinding
import fr.mbds.squad.movieapp.ui.trending.TrendingViewModel
import fr.mbds.squad.movieapp.ui.trending.adapters.TrendingAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrendingHomeFragment : Fragment() {

    private val trendingViewModel: TrendingViewModel by viewModel()
    private lateinit var binding: FragmentTrendingHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrendingHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(trendingViewModel) {
            token.observe(
                viewLifecycleOwner,
                Observer {
                    getTrendingActorByLastWeek()
                }
            )

            actors.observe(
                viewLifecycleOwner,
                Observer {
                    binding.trendingActorList.adapter = TrendingAdapter(it)
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
