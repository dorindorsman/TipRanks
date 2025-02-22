package com.example.tipranks.stocks.domain.repository

import com.example.tipranks.app.domain.utils.DataError
import com.example.tipranks.app.domain.utils.Result
import com.example.tipranks.stocks.domain.model.Stock

interface StocksRepository {
    suspend fun getAutocompleteWithQuery(query: String): Result<List<Stock>, DataError.Network>
}