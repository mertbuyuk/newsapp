package com.mb.newsappletzte.domain.usecases.news

import com.mb.newsappletzte.data.local.NewsDao
import com.mb.newsappletzte.domain.model.Article
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class GetAllArticlesUseCase @Inject constructor(val newsDao: NewsDao) {

    suspend operator fun invoke() : Flow<List<Article>> {
        return newsDao.getArticles()
    }
}