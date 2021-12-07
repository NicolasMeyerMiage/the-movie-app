package fr.mbds.squad.idbdata.datasources

import fr.mbds.squad.idbdata.api.response.ActorResponse
import fr.mbds.squad.idbdata.api.response.CategoryResponse
import fr.mbds.squad.idbdata.api.response.TokenResponse
import fr.mbds.squad.idbdata.api.response.TvResponse
import fr.mbds.squad.idbdata.api.service.TrendingService
import fr.mbds.squad.idbdata.api.service.TvService
import fr.mbds.squad.idbdata.utils.Result
import parse
import safeCall

/**
 * Manipule les données de l'application en utilisant un web service
 * Cette classe est interne au module, ne peut être initialisé ou exposé aux autres composants
 * de l'application
 */
internal class OnlineTrendingDataSource(private val trendingService: TrendingService) {

    /**
     * Récupérer le token du serveur
     * @return [Result<Token>]
     * Si [Result.Succes], tout s'est bien passé
     * Sinon, une erreur est survenue
     */
    suspend fun getToken(): Result<TokenResponse> {
        return safeCall {
            val response = trendingService.getToken()
            response.parse()
        }
    }

    /**
     * Liste des services gérant les tendances
     * Si [Result.Succes], tout s'est bien passé
     * Sinon, une erreur est survenue
     */
    suspend fun getTrendingActorByLastWeek(): Result<List<ActorResponse.Result>> {
        return safeCall {
            val response = trendingService.getTrendingActorByLastWeek()
            when (val result = response.parse()) {
                is Result.Succes -> Result.Succes(result.data.results)
                is Result.Error -> result
            }
        }
    }
}
