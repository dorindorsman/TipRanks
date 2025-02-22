package com.example.tipranks.stocks.data.mapper

import com.example.tipranks.stocks.data.dto.StockDto
import com.example.tipranks.stocks.domain.model.Stock


fun StockDto.toStock(): Stock {
    return Stock(
        label = label,
        ticker =  ticker ?: "",
        value = value,
        category = category,
        uid = uid,
    )
}

fun Stock.toStockDto(): StockDto {
    return StockDto(
        label = label,
        ticker =  ticker,
        category = category,
        value = value,
        uid = uid,
    )
}