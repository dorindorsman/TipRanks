package com.example.tipranks.stocks.presentation.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tipranks.stocks.presentation.StocksAction
import com.example.tipranks.stocks.presentation.StocksUiState

@Composable
fun StockScreenContent(
    modifier: Modifier = Modifier,
    uiState: StocksUiState,
    onAction: (StocksAction) -> Unit
) {
    if (uiState.stocksList.isEmpty()) {
        EmptyScreen()
    } else {
        StockListScreen(
            stocks = uiState.stocksList,
            modifier = modifier,
            onAction = onAction
        )
    }
}

@Composable
fun EmptyScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(16.dp)
    ) {
        Text(
            text = "No stocks available.",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
