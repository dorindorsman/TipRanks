package com.example.tipranks.app.navigation.route

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tipranks.core.presentation.ObserveAsEvents
import com.example.tipranks.stocks.presentation.StocksEvent
import com.example.tipranks.stocks.presentation.StocksScreen
import com.example.tipranks.stocks.presentation.StocksViewModel


fun NavGraphBuilder.stocksRoute(
    navController: NavController,
) {
    composable<Route.Stocks> {
        val context = LocalContext.current
        val viewModel: StocksViewModel = hiltViewModel()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        ObserveAsEvents(viewModel.events) { event ->
            when (event) {
                is StocksEvent.ShowToast -> {
                    Toast.makeText(context, event.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        StocksScreen(
            uiState = uiState,
            onAction = viewModel::onAction
        )
    }
}