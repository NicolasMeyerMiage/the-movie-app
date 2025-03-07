package fr.mbds.squad.idbdata.api.service

import fr.mbds.squad.idbdata.api.response.ActorResponse
import fr.mbds.squad.idbdata.api.response.TokenResponse
import retrofit2.Response
import retrofit2.http.GET

internal interface TrendingService {
    @GET("authentication/token/new")
    suspend fun getToken(): Response<TokenResponse>

    @GET("trending/person/week")
    suspend fun getTrendingActorByLastWeek(): Response<ActorResponse>
}
