package com.example.tipranks.stocks.presentation.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tipranks.stocks.domain.model.Stock
import com.example.tipranks.stocks.presentation.StocksAction

@Composable
fun StockListScreen(stocks: List<Stock>, modifier: Modifier, onAction: (StocksAction) -> Unit) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 120.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp, Alignment.Top),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        itemsIndexed(
            items = stocks,
            key = { _: Int, item: Stock ->
                item.uid
            }
        ) { index, stock ->
            StockCard(
                stock = stock,
                index = index,
                onAction = onAction
            )
        }
    }
}