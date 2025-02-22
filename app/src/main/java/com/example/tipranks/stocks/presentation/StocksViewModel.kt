package com.example.tipranks.stocks.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class StocksViewModel @Inject constructor(

) : ViewModel() {

    companion object{
        private  const val TAG = "StocksViewModel"
    }

    var uiState: StocksUiState by mutableStateOf(StocksUiState())
        private set

    private val _events = Channel<StocksEvent>()
    val events = _events.receiveAsFlow()

    fun onLifecycleEvent(event: Lifecycle.Event) {
        Log.d(TAG, "onEvent: $event")
        when (event) {
            Lifecycle.Event.ON_START -> onStart()
            else -> Unit
        }
    }

    fun onAction(action: StocksAction){
//        when(action){
//
//        }
    }

   private fun onStart(){

   }

}