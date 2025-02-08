package com.mb.newsappletzte.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mb.newsappletzte.domain.usecases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val appEntryUseCases: AppEntryUseCases) : ViewModel() {

    fun onEvent(onBoardingEvent: OnBoardingEvent){
        when(onBoardingEvent){
            OnBoardingEvent.saveAppEntry -> {
                saveAppEntry()
            }
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }
    }
}