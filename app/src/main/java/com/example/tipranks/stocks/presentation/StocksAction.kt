package com.example.tipranks.stocks.presentation

sealed interface StocksAction {
    data class OnSearchQueryChange(val query: String) : StocksAction
    data class OnSearchExpanded(val isSearchExpended: Boolean) : StocksAction
    data class OnUidClick(val uid: String) : StocksAction
    data class OnClickCard(val index: Int, val label: String) : StocksAction
}