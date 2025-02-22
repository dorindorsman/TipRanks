package com.example.tipranks.stocks.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.tipranks.stocks.presentation.views.StockScreenContent
import com.example.tipranks.stocks.presentation.views.StockTopBar


@Composable
fun StocksScreen(
    uiState: StocksUiState,
    onAction: (StocksAction) -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            StockTopBar(modifier = Modifier)
        }
    ) { innerPadding ->
        StockScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
            ,
            uiState = uiState)
    }

}


