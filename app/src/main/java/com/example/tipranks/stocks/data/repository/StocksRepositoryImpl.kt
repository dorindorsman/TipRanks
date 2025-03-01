package com.example.tipranks.stocks.data.repository

import com.example.tipranks.core.domain.utils.DataError
import com.example.tipranks.core.domain.utils.Result
import com.example.tipranks.core.domain.utils.map
import com.example.tipranks.stocks.data.mapper.toStock
import com.example.tipranks.stocks.data.network.RemoteStockDataSource
import com.example.tipranks.stocks.domain.model.Stock
import com.example.tipranks.stocks.domain.repository.StocksRepository

class StocksRepositoryImpl(private val remoteStockDataSource: RemoteStockDataSource) :
    StocksRepository {

    override suspend fun getAutocompleteWithQuery(query: String): Result<List<Stock>, DataError.Network> {
        return remoteStockDataSource
            .getAutocompleteWithQuery(query = query)
            .map { listDto ->
                listDto.map { stockDto ->
                    stockDto.toStock()
                }
            }
    }
}