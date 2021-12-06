package fr.mbds.squad.idbdata.api.service

import fr.mbds.squad.idbdata.api.response.CategoryResponse
import fr.mbds.squad.idbdata.api.response.MovieResponse
import fr.mbds.squad.idbdata.api.response.TokenResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieService {
    @GET("authentication/token/new")
    suspend fun getToken(): Response<TokenResponse>

    @GET("genre/movie/list")
    suspend fun getCategories(): Response<CategoryResponse>

    @GET("discover/movie")
    suspend fun getMoviesByCatId(@Query("with_genres") genre: String): Response<MovieResponse>

    @GET("movie")
    suspend fun getMovieById(id: String): Response<MovieResponse.Result>
}
