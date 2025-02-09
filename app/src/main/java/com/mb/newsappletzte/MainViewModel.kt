package com.mb.newsappletzte

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mb.newsappletzte.domain.usecases.appentryusecases.AppEntryUseCases
import com.mb.newsappletzte.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val appEntryUseCases: AppEntryUseCases) : ViewModel() {

     var splashCondition = mutableStateOf(true)
        private set

    var startDestination = mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        appEntryUseCases.readAppEntry().onEach {startFromMainPageScreen->
            when(startFromMainPageScreen){
                true -> startDestination.value = Route.NewsNavigation.route
                else -> {Route.AppStartNavigation.route}
            }
            delay(400)
            splashCondition.value = false
        }.launchIn(viewModelScope)
        //launch in ile collect yapmadan flowu baslatiriz.
        // viewmodel yasam döngüsüne baglariz viewmodel ölünce bu da ölür
        // böylelikle bellek sizintisi olmaz
    }
}