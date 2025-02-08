package com.mb.newsappletzte.domain.usecases

import com.mb.newsappletzte.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManager: LocalUserManager) {

    operator fun invoke() : Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}