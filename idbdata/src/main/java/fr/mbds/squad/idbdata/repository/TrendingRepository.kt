package fr.mbds.squad.idbdata.repository

import fr.mbds.squad.idbdata.api.response.*
import fr.mbds.squad.idbdata.api.response.toEntity
import fr.mbds.squad.idbdata.api.response.toToken
import fr.mbds.squad.idbdata.data.Actor
import fr.mbds.squad.idbdata.data.Category
import fr.mbds.squad.idbdata.data.Token
import fr.mbds.squad.idbdata.data.Tv
import fr.mbds.squad.idbdata.datasources.LocalDataSource
import fr.mbds.squad.idbdata.datasources.OnlineTrendingDataSource
import fr.mbds.squad.idbdata.datasources.OnlineTvDataSource
import fr.mbds.squad.idbdata.utils.Result
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * La classe permettant de gérer les données de l'application
 */
class TrendingRepository : KoinComponent {
    // Gestion des sources de données locales
    private val local: LocalDataSource by inject()
    // Gestion des sources de données en lignes
    private val online: OnlineTrendingDataSource by inject()

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

    suspend fun getTrendingActorByLastWeek(): Result<List<Actor>> {
        return when (val result = online.getTrendingActorByLastWeek()) {
            is Result.Succes -> {
                val actors = result.data.map {
                    it.toActor()
                }
                Result.Succes(actors)
            }
            is Result.Error -> result
        }
    }
}
