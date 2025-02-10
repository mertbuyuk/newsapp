package com.mb.newsappletzte.di

import android.app.Application
import com.mb.newsappletzte.data.manager.LocalUserManagerImp
import com.mb.newsappletzte.data.remote.GetNewsApi
import com.mb.newsappletzte.data.remote.NewsPagingSource
import com.mb.newsappletzte.data.repository.NewsRepositoryImp
import com.mb.newsappletzte.domain.manager.LocalUserManager
import com.mb.newsappletzte.domain.repository.NewsRepository
import com.mb.newsappletzte.domain.usecases.appentryusecases.AppEntryUseCases
import com.mb.newsappletzte.domain.usecases.appentryusecases.ReadAppEntry
import com.mb.newsappletzte.domain.usecases.appentryusecases.SaveAppEntry
import com.mb.newsappletzte.domain.usecases.news.GetNewsUseCase
import com.mb.newsappletzte.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsApi() : GetNewsApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GetNewsApi::class.java)
    }


    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: GetNewsApi) : NewsRepository{
        return NewsRepositoryImp(newsApi)
    }

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

    @Provides
    @Singleton
    fun provideGetNewsUseCase( newsRepository: NewsRepository) : GetNewsUseCase {
        return GetNewsUseCase(newsRepository = newsRepository)
    }
}