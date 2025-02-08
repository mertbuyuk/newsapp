package com.mb.newsappletzte.domain.usecases

import com.mb.newsappletzte.domain.manager.LocalUserManager

class SaveAppEntry(private val localUserManager: LocalUserManager) {

    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}