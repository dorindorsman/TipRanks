package com.example.tipranks.core.data.network.utils

private const val BASE_URL = "https://trautocomplete.azurewebsites.net/"

fun constructUrl(url: String): String {
    return when {
        url.contains(BASE_URL) -> return url
        url.startsWith("/") -> BASE_URL + url.drop(1)
        else -> BASE_URL + url
    }
}