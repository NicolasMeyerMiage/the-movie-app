package fr.mbds.squad.movieapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.mbds.squad.idbdata.repository.MovieRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

/**
 * Activité principale de l'application
 * Ce sera la seule activité de l'application
 */
class MainActivity : AppCompatActivity() {

    val repository: MovieRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavController()
        GlobalScope.launch {
            Log.d("TOKEN", repository.getToken().toString())
        }
    }

    /**
     * Méthode utilitaire permettant de gérer la navigation
     */
    private fun initNavController() {
        // Instance de la bottom navigation
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        // Navigation controlleur, utilisée pour géter la navigation (ex. affichage de fragment)
        val navController = findNavController(R.id.nav_host_fragment)
        // Charger les éléments principaux de la bottom bar
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_movie_home, R.id.navigation_tv_home, R.id.navigation_about_home
            )
        )
        // Indiquer les éléments principaux de la bottom bar
        setupActionBarWithNavController(navController, appBarConfiguration)
        // Finalement, on lie la bottom bar et la nav controller
        navView.setupWithNavController(navController)
    }
}
