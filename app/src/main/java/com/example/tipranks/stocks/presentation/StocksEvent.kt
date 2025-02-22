package com.example.tipranks.stocks.presentation

sealed interface StocksEvent {
    data class ShowToast(val message: String) : StocksEvent
}