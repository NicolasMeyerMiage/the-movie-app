package fr.mbds.squad.idbdata.api.response

import com.google.gson.annotations.SerializedName
import fr.mbds.squad.idbdata.data.Actor

internal data class ActorResponse(
    @SerializedName("results")
    val results: List<Result>,
) {
    data class Result(
        @SerializedName("id")
        val id: Int,
        @SerializedName("adult")
        val adult: Int,
        @SerializedName("gender")
        val gender: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("profile_path")
        val poster: String,
        @SerializedName("popularity")
        val popularity: Double,
        @SerializedName("media_type")
        val media_type: String
    )
}

internal fun ActorResponse.Result.toActor() = Actor(
    id = id,
    adult = adult,
    gender = gender,
    name = name,
    poster = "https://image.tmdb.org/t/p/w185$poster",
    popularity = popularity,
    media_type = media_type,
)
