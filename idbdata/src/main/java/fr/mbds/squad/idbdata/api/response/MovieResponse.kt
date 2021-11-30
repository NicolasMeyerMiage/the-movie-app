package fr.mbds.squad.idbdata.api.response

import com.google.gson.annotations.SerializedName
import fr.mbds.squad.idbdata.data.Movie

internal data class MovieResponse(
    @SerializedName("results")
    val results: List<Result>
) {
    data class Result(
        @SerializedName("original_title")
        val original_title: String,

        @SerializedName("id")
        val id: Int,

        @SerializedName("poster_path")
        val poster: String
    )
}

internal fun MovieResponse.Result.toMovie() = Movie(
    title = original_title,
    id = id,
    poster = poster
)
