package com.example.tipranks.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.tipranks.app.navigation.route.Route
import com.example.tipranks.app.navigation.route.stocksRoute


@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Route.Stocks,
    ) {
        stocksRoute(navController)
    }

}