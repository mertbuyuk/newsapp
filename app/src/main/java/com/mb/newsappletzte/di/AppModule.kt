package com.mb.newsappletzte.di

import android.app.Application
import com.mb.newsappletzte.data.manager.LocalUserManagerImp
import com.mb.newsappletzte.domain.manager.LocalUserManager
import com.mb.newsappletzte.domain.usecases.appentryusecases.AppEntryUseCases
import com.mb.newsappletzte.domain.usecases.appentryusecases.ReadAppEntry
import com.mb.newsappletzte.domain.usecases.appentryusecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application) : LocalUserManager{
        return LocalUserManagerImp(context = application)
    }

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) : AppEntryUseCases {
        return AppEntryUseCases(
            readAppEntry = ReadAppEntry(localUserManager),saveAppEntry = SaveAppEntry(localUserManager)
        )
    }
}