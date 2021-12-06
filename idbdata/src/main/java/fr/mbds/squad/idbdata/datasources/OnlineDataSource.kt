package fr.mbds.squad.idbdata.datasources

import fr.mbds.squad.idbdata.api.response.CategoryResponse
import fr.mbds.squad.idbdata.api.response.MovieResponse
import fr.mbds.squad.idbdata.api.response.TokenResponse
import fr.mbds.squad.idbdata.api.service.MovieService
import fr.mbds.squad.idbdata.utils.Result
import parse
import safeCall

/**
 * Manipule les données de l'application en utilisant un web service
 * Cette classe est interne au module, ne peut être initialisé ou exposé aux autres composants
 * de l'application
 */
internal class OnlineDataSource(private val service: MovieService) {

    /**
     * Récupérer le token du serveur
     * @return [Result<Token>]
     * Si [Result.Succes], tout s'est bien passé
     * Sinon, une erreur est survenue
     */
    suspend fun getToken(): Result<TokenResponse> {
        return safeCall {
            val response = service.getToken()
            response.parse()
        }
    }

    suspend fun getCategories(): Result<List<CategoryResponse.Genre>> {
        return safeCall {
            val response = service.getCategories()
            when (val result = response.parse()) {
                is Result.Succes -> Result.Succes(result.data.genres)
                is Result.Error -> result
            }
        }
    }

    suspend fun getMoviesByGenre(genre: String): Result<List<MovieResponse.Result>> {
        return safeCall {
            val response = service.getMoviesByGenre(genre)
            when (val result = response.parse()) {
                is Result.Succes -> Result.Succes(result.data.results)
                is Result.Error -> result
            }
        }
    }

    suspend fun getMovieById(movieId: String): Result<MovieResponse.Result> {
        return safeCall {
            val response = service.getMovieById(movieId.toInt())
            when (val result = response.parse()) {
                is Result.Succes -> Result.Succes(result.data)
                is Result.Error -> result
            }
        }
    }
}

