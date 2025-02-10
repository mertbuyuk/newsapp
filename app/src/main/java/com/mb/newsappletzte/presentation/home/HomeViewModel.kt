package com.mb.newsappletzte.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mb.newsappletzte.domain.usecases.news.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val newsUseCase : GetNewsUseCase) : ViewModel(){

    var state = mutableStateOf(HomeState())
        private set

    val news = newsUseCase.invoke(
        sources = listOf("bbc-news","abc-news","al-jazeera-english")
    ).cachedIn(viewModelScope)
    //paging 3 özelligi -> önbellege alir yukarda ki kodla
    //gereksiz ayni verileri isterse önbellekten gösterilir gereksiz ag istegi engellenir
}
