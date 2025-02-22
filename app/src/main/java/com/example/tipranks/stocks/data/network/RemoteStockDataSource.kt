package com.example.tipranks.stocks.data.network

import com.example.tipranks.app.domain.utils.DataError
import com.example.tipranks.app.domain.utils.Result
import com.example.tipranks.stocks.data.dto.StockDto


interface RemoteStockDataSource {

    suspend fun getAutocompleteWithQuery(query: String): Result<List<StockDto>, DataError.Network>

}