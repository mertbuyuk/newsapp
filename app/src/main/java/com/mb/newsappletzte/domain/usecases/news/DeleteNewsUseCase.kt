package com.mb.newsappletzte.domain.usecases.news

import com.mb.newsappletzte.data.local.NewsDao
import com.mb.newsappletzte.domain.model.Article
import javax.inject.Inject

class DeleteNewsUseCase @Inject constructor(val newsDao: NewsDao) {

    suspend operator fun invoke(article: Article){

        newsDao.deleteArticle(article)
    }
}