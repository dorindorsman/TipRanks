package com.example.tipranks.stocks.di

import com.example.tipranks.stocks.data.network.KtorRemoteStockDataSource
import com.example.tipranks.stocks.data.network.RemoteStockDataSource
import com.example.tipranks.stocks.data.repository.StocksRepositoryImpl
import com.example.tipranks.stocks.domain.repository.StocksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StockModule {

    @Singleton
    @Provides
    fun provideRemoteStockDataSource(httpClient: HttpClient): RemoteStockDataSource {
        return KtorRemoteStockDataSource(httpClient = httpClient)
    }

    @Singleton
    @Provides
    fun provideStocksRepository(dataSource: RemoteStockDataSource): StocksRepository {
        return StocksRepositoryImpl(dataSource)
    }

}