package com.example.tipranks.stocks.presentation

import com.example.tipranks.stocks.domain.model.Stock

data class StocksUiState(
    val query: String,
    val isSearchExpended: Boolean,
    val stocksList: List<Stock>
)
