package fr.mbds.squad.idbdata.api.service

import fr.mbds.squad.idbdata.api.response.CategoryResponse
import fr.mbds.squad.idbdata.api.response.MovieResponse
import fr.mbds.squad.idbdata.api.response.TokenResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface MovieService {
    @GET("authentication/token/new")
    suspend fun getToken(): Response<TokenResponse>

    @GET("genre/movie/list")
    suspend fun getMovieCategories(): Response<CategoryResponse>

    @GET("discover/movie")
    suspend fun getMoviesByCategoryId(@Query("with_genres") categoryId: String, @Query("language") language: String): Response<MovieResponse>

    @GET("movie/{id}")
    suspend fun getMovieById(@Path("id") id: Int, @Query("language") language: String): Response<MovieResponse.Result>
}