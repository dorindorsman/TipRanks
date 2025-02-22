package com.example.tipranks.stocks.domain.model

data class Stock(
    val label: String,
    val ticker: String,
    val value: String,
    val category: String,
    val uid: String,
)
