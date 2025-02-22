package com.example.tipranks.app.navigation.route

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object Stocks : Route

}