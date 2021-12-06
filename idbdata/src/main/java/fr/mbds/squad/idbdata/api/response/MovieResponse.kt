package fr.mbds.squad.idbdata.api.response

import com.google.gson.annotations.SerializedName
import fr.mbds.squad.idbdata.data.Movie

internal data class MovieResponse(
    // changer movies par results
    @SerializedName("results")
    val results: List<Result>,
) {
    data class Result(
        @SerializedName("id")
        val id: Int,
        @SerializedName("original_title")
        val original_title: String,
        @SerializedName("vote_average")
        val vote: String,
        @SerializedName("release_date")
        val date: String,
        @SerializedName("backdrop_path")
        val poster: String
    )
}

internal fun MovieResponse.Result.toMovie() = Movie(
    id = id,
    name = original_title,
    vote = vote,
    date = date,
    poster = "https://image.tmdb.org/t/p/w185$poster",
    overview = "nothing"
)
