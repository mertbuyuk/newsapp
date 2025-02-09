package com.mb.newsappletzte.domain.usecases.news

import androidx.paging.PagingData
import com.mb.newsappletzte.domain.model.Article
import com.mb.newsappletzte.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNewsUseCase(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(sources : List<String>) : Flow<PagingData<Article>>{
        return newsRepository.getNews(sources)
    }
}