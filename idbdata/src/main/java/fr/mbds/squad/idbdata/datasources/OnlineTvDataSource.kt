package fr.mbds.squad.idbdata.datasources

import fr.mbds.squad.idbdata.api.response.CategoryResponse
import fr.mbds.squad.idbdata.api.response.TokenResponse
import fr.mbds.squad.idbdata.api.response.TvResponse
import fr.mbds.squad.idbdata.api.service.TvService
import fr.mbds.squad.idbdata.utils.Result
import parse
import safeCall

/**
 * Manipule les données de l'application en utilisant un web service
 * Cette classe est interne au module, ne peut être initialisé ou exposé aux autres composants
 * de l'application
 */
internal class OnlineTvDataSource(private val serviceTv: TvService) {

    /**
     * Récupérer le token du serveur
     * @return [Result<Token>]
     * Si [Result.Succes], tout s'est bien passé
     * Sinon, une erreur est survenue
     */
    suspend fun getToken(): Result<TokenResponse> {
        return safeCall {
            val response = serviceTv.getToken()
            response.parse()
        }
    }

    /**
     * Liste des services gérant les shows télés
     * Si [Result.Succes], tout s'est bien passé
     * Sinon, une erreur est survenue
     */
    suspend fun getTvCategories(): Result<List<CategoryResponse.Genre>> {
        return safeCall {
            val response = serviceTv.getTvCategories()
            when (val result = response.parse()) {
                is Result.Succes -> Result.Succes(result.data.genres)
                is Result.Error -> result
            }
        }
    }

    suspend fun getTvsByCategoryId(categoryId: String, language: String): Result<List<TvResponse.Result>> {
        return safeCall {
            val response = serviceTv.getTvsByCategoryId(categoryId, language)
            when (val result = response.parse()) {
                is Result.Succes -> Result.Succes(result.data.results)
                is Result.Error -> result
            }
        }
    }

    suspend fun getTvById(tvId: String, language: String): Result<TvResponse.Result> {
        return safeCall {
            val response = serviceTv.getTvById(tvId.toInt(), language)
            when (val result = response.parse()) {
                is Result.Succes -> Result.Succes(result.data)
                is Result.Error -> result
            }
        }
    }
}
