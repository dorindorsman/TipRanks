package com.example.tipranks.stocks.data.network

import com.example.tipranks.app.data.network.utils.constructUrl
import com.example.tipranks.app.data.network.utils.safeCall
import com.example.tipranks.app.domain.utils.DataError
import com.example.tipranks.app.domain.utils.Result
import com.example.tipranks.stocks.data.dto.StockDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class KtorRemoteStockDataSource(private val httpClient: HttpClient) : RemoteStockDataSource {

    override suspend fun getAutocompleteWithQuery(query: String): Result<List<StockDto>, DataError.Network> {
        return safeCall<List<StockDto>> {
            httpClient.get(urlString = constructUrl("api/Autocomplete/GetAutocomplete/")) {
                parameter("name", query)
            }
        }
    }
}