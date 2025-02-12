package com.mb.newsappletzte.domain.usecases.news

import com.mb.newsappletzte.data.local.NewsDao
import com.mb.newsappletzte.domain.model.Article
import javax.inject.Inject

class GetArticleUseCase @Inject constructor(val newsDao: NewsDao) {

    suspend operator fun invoke(url: String) : Article? {
        return newsDao.getArticle(url)
    }
}