package com.example.tipranks.app.navigation.route

import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.tipranks.app.presentation.Observe
import com.example.tipranks.app.presentation.ObserveAsEvents
import com.example.tipranks.stocks.presentation.StocksScreen
import com.example.tipranks.stocks.presentation.StocksViewModel


fun NavGraphBuilder.stocksRoute(
    navController: NavController,
) {
    composable<Route.Stocks> {
        val context = LocalContext.current
        val viewModel: StocksViewModel = hiltViewModel()

        LocalLifecycleOwner.current.lifecycle.Observe(viewModel::onLifecycleEvent)


        ObserveAsEvents(viewModel.events) { event ->
//            when (event) {
//
//            }
        }

        StocksScreen(
            uiState = viewModel.uiState,
            onAction = viewModel::onAction
        )
    }
}