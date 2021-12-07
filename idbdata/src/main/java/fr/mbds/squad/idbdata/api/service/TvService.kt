package fr.mbds.squad.idbdata.api.service

import fr.mbds.squad.idbdata.api.response.CategoryResponse
import fr.mbds.squad.idbdata.api.response.TokenResponse
import fr.mbds.squad.idbdata.api.response.TvResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface TvService {
    @GET("authentication/token/new")
    suspend fun getToken(): Response<TokenResponse>

    @GET("genre/tv/list")
    suspend fun getTvCategories(): Response<CategoryResponse>

    @GET("discover/tv")
    suspend fun getTvsByCategoryId(@Query("with_genres") categoryId: String, @Query("language") language: String): Response<TvResponse>

    @GET("tv/{id}")
    suspend fun getTvById(@Path("id") id: Int, @Query("language") language: String): Response<TvResponse.Result>
}
