import fr.mbds.squad.idbdata.utils.Result
import retrofit2.Response
import java.io.IOException

internal fun <T : Any> Response<T>.parse(): Result<T> {
    return if (isSuccessful) {
        body()?.let {
            Result.Succes(it)
        } ?: run {
            Result.Error(
                exception = NoDataException(),
                message = "Aucune donnée",
                code = 404
            )
        }
    } else {
        Result.Error(
            exception = Exception(),
            message = message(),
            code = code()
        )
    }
}

internal suspend fun <T : Any> safeCall(execute: suspend () -> Result<T>): Result<T> {
    return try {
        execute()
    } catch (e: Exception) {
        if (e is IOException) {
            Result.Error(
                exception = IOException(),
                message = "Problème d'accès au réseau",
                code = -1
            )
        } else {
            Result.Error(
                exception = e,
                message = e.message ?: "No message",
                code = -1
            )
        }
    }
}

class NoDataException : Exception()
class NetworkException : Exception()
