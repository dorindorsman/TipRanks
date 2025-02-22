package com.example.tipranks.stocks.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.tipranks.stocks.domain.model.Stock
import com.example.tipranks.stocks.presentation.views.SearchTopBarView
import com.example.tipranks.stocks.presentation.views.StockScreenContent
import com.example.tipranks.ui.theme.TipRanksTheme


@Composable
fun StocksScreen(
    uiState: StocksUiState,
    onAction: (StocksAction) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            SearchTopBarView(
                modifier = Modifier,
                uiState = uiState,
                onAction = onAction
            )
        }
    ) { innerPadding ->
        StockScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            uiState = uiState,
            onAction = onAction
        )
    }
}

@PreviewLightDark
@Composable
fun StocksScreenPreview(
    @PreviewParameter(StocksUiStatePreviewParameterProvider::class)
    uiState: StocksUiState
) {
    TipRanksTheme {
        StocksScreen(
            uiState = uiState,
            onAction = {}
        )
    }
}

private class StocksUiStatePreviewParameterProvider : PreviewParameterProvider<StocksUiState> {
    private val emptyUiState =
        StocksUiState(isSearchExpended = false, query = "M", stocksList = emptyList())
    private val listUiState = StocksUiState(
        isSearchExpended = false,
        query = "M",
        stocksList = (1..10).map {
            Stock(
                label = "Macy's Inc",
                ticker = "",
                value = "M",
                category = "ticker",
                uid = "$it"
            )
        }
    )
    private val expendedSearch = listUiState.copy(isSearchExpended = true)
    override val values: Sequence<StocksUiState>
        get() = sequenceOf(emptyUiState, listUiState, expendedSearch)
}


