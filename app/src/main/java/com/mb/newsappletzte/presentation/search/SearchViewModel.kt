package com.mb.newsappletzte.presentation.search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mb.newsappletzte.domain.usecases.news.NewsUseCases
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(val newsUseCases: NewsUseCases) : ViewModel() {

    private var _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state

    fun onEvent(event : SearchEvent){
        when(event){
            is SearchEvent.SearchNews -> searchNews()
            is SearchEvent.updateSearchQuery -> {
                _state.value = _state.value.copy(searchQuery = event.query)
            }
        }
    }

    private fun searchNews() {
        val articles = newsUseCases.searchNews.invoke(
            _state.value.searchQuery, sources = listOf("bbc-news", "abc-news", "al-jazeera-english")
        ).cachedIn(viewModelScope)

        _state.value = _state.value.copy(articles = articles)
    }
}