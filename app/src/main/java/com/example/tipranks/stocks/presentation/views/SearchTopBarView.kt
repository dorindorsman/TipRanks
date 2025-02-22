@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.tipranks.stocks.presentation.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import com.example.tipranks.R
import com.example.tipranks.stocks.presentation.StocksAction
import com.example.tipranks.stocks.presentation.StocksUiState

@Composable
fun SearchTopBarView(
    uiState: StocksUiState,
    onAction: (StocksAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    SearchBar(
        modifier = modifier
            .fillMaxWidth(),
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            dividerColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        inputField = {
            SearchBarDefaults.InputField(
                query = uiState.query,
                onQueryChange = {
                    onAction(StocksAction.OnSearchQueryChange(it))
                },
                onSearch = {
                    keyboardController?.hide()
                    onAction(StocksAction.OnSearchExpanded(false))
                },
                expanded = uiState.isSearchExpended,
                onExpandedChange = {
                    onAction(StocksAction.OnSearchExpanded(it))
                },
                placeholder = {
                    Text(stringResource(R.string.top_bar_search))
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            keyboardController?.hide()
                            onAction(StocksAction.OnSearchExpanded(false))
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null
                        )
                    }
                },
            )
        },
        onExpandedChange = {
            onAction(StocksAction.OnSearchExpanded(it))
        },
        expanded = uiState.isSearchExpended,
    ) {
        SearchTopBarContentView(
            uiState = uiState,
            modifier = Modifier.fillMaxSize(),
            onItemClick = {
                keyboardController?.hide()
                onAction(StocksAction.OnSearchExpanded(false))
            }
        )
    }
}