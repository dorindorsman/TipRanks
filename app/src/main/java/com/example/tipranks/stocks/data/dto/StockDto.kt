package com.example.tipranks.stocks.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class StockDto(
    val label:String,
    val ticker:String? = null,
    val value:String,
    val category:String,
    val uid : String,
)
