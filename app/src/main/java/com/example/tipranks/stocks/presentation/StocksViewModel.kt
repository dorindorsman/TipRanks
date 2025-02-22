package com.example.tipranks.stocks.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tipranks.app.domain.utils.onError
import com.example.tipranks.app.domain.utils.onSuccess
import com.example.tipranks.stocks.domain.repository.StocksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StocksViewModel @Inject constructor(
    private val repository: StocksRepository
) : ViewModel() {

    companion object {
        private const val TAG = "StocksViewModel"
    }


    private val _uiState = MutableStateFlow(
        StocksUiState(
            isSearchExpended = false,
            query = "M",
            stocksList = emptyList()
        )
    )
    val uiState = _uiState
        .onStart {
            observeSearch()
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _uiState.value
        )

    private var searchJob: Job? = null

    private val _events = Channel<StocksEvent>()
    val events = _events.receiveAsFlow()

    fun onAction(action: StocksAction) {
        when (action) {
            is StocksAction.OnSearchExpanded -> onSearchExpanded(action.isSearchExpended)
            is StocksAction.OnSearchQueryChange -> onSearchQueryChange(action.query)
            is StocksAction.OnClickCard -> onClickCard(action.index, action.label)
            is StocksAction.OnUidClick -> onUidClick(action.uid)
        }
    }

    private fun onClickCard(index: Int, label: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _events.send(StocksEvent.ShowToast("Company $label in position $index"))
        }
    }

    private fun onUidClick(uid: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _events.send(StocksEvent.ShowToast("uid $uid"))
        }
    }


    private fun onSearchExpanded(isExpended: Boolean) {
        _uiState.update {
            it.copy(isSearchExpended = isExpended)
        }
    }

    private fun onSearchQueryChange(query: String) {
        _uiState.update {
            it.copy(query = query)
        }
    }

    @OptIn(FlowPreview::class)
    private fun observeSearch() {
        Log.d(TAG, "observeSearch")
        _uiState
            .map {
                it.query
            }
            .distinctUntilChanged()
            .debounce(500L)
            .onEach { query ->
                when {
                    query.isNotEmpty() -> {
                        searchJob?.cancel()
                        searchJob = search(query)
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun search(query: String) = viewModelScope.launch(Dispatchers.IO) {
        repository.getAutocompleteWithQuery(query)
            .onError { error ->
                viewModelScope.launch(Dispatchers.IO) {
                    _events.send(StocksEvent.ShowToast("Error: ${error.name}"))
                }
            }
            .onSuccess { stocks ->
                _uiState.update { stock ->
                    stock.copy(stocksList = stocks.sortedBy { it.label })
                }
            }
    }

}