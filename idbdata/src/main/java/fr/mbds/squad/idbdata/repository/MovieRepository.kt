package fr.mbds.squad.idbdata.repository

import fr.mbds.squad.idbdata.api.response.toCategory
import fr.mbds.squad.idbdata.api.response.toEntity
import fr.mbds.squad.idbdata.api.response.toMovie
import fr.mbds.squad.idbdata.api.response.toToken
import fr.mbds.squad.idbdata.data.Category
import fr.mbds.squad.idbdata.data.Movie
import fr.mbds.squad.idbdata.data.Token
import fr.mbds.squad.idbdata.datasources.LocalDataSource
import fr.mbds.squad.idbdata.datasources.OnlineMovieDataSource
import fr.mbds.squad.idbdata.utils.Result
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * La classe permettant de gérer les données de l'application
 */
class MovieRepository : KoinComponent {
    // Gestion des sources de données locales
    private val local: LocalDataSource by inject()
    // Gestion des sources de données en lignes
    private val online: OnlineMovieDataSource by inject()

    /**
     * Récupérer le token permettant de consommer les ressources sur le serveur
     * Le résultat du datasource est converti en instance d'objets publiques
     */
    suspend fun getToken(): Result<Token> {
        return when (val result = online.getToken()) {
            is Result.Succes -> {
                // save the response in the local database
                local.saveToken(result.data.toEntity())
                // return the response
                Result.Succes(result.data.toToken())
            }
            is Result.Error -> result
        }
    }

    suspend fun getMovieCategories(): Result<List<Category>> {
        return when (val result = online.getMovieCategories()) {
            is Result.Succes -> {
                // On utilise la fonction map pour convertir les catégories de la réponse serveur
                // en liste de categories d'objets de l'application
                val categories = result.data.map {
                    it.toCategory()
                }
                Result.Succes(categories)
            }
            is Result.Error -> result
        }
    }

    suspend fun getMoviesByCategoryId(categoryId: String, language: String): Result<List<Movie>> {
        return when (val result = online.getMoviesByCategoryId(categoryId, language)) {
            is Result.Succes -> {
                val results = result.data.map {
                    it.toMovie()
                }
                Result.Succes(results)
            }
            is Result.Error -> result
        }
    }

    suspend fun getMovieById(movieId: String, language: String): Result<Movie> {
        return when (val result = online.getMovieById(movieId, language)) {
            is Result.Succes -> {
                val result = result.data.toMovie()
                Result.Succes(result)
            }
            is Result.Error -> result
        }
    }
}
