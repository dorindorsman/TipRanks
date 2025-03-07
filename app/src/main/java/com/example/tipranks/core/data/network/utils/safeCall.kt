package com.example.tipranks.core.data.network.utils

import com.example.tipranks.core.domain.utils.DataError
import com.example.tipranks.core.domain.utils.Result
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlin.coroutines.coroutineContext

suspend inline fun <reified T> safeCall(
    execute: () -> HttpResponse
): Result<T, DataError.Network> {
    val response = try {
        execute()
    } catch (e: UnresolvedAddressException) {
        return Result.Error(DataError.Network.NO_INTERNET_CONNECTION)
    } catch (e: ServerResponseException) {
        return Result.Error(DataError.Network.SERVER_ERROR)
    } catch (e: Exception) {
        coroutineContext.ensureActive()
        return Result.Error(DataError.Network.UNKNOWN)
    }

    return responseToResult(response)
}