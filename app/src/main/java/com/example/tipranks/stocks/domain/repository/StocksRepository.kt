package com.example.tipranks.stocks.domain.repository

import com.example.tipranks.core.domain.utils.DataError
import com.example.tipranks.core.domain.utils.Result
import com.example.tipranks.stocks.domain.model.Stock

interface StocksRepository {
    suspend fun getAutocompleteWithQuery(query: String): Result<List<Stock>, DataError.Network>
}