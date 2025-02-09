package com.mb.newsappletzte.domain.usecases.appentryusecases

import com.mb.newsappletzte.domain.manager.LocalUserManager

class SaveAppEntry(private val localUserManager: LocalUserManager) {

    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}