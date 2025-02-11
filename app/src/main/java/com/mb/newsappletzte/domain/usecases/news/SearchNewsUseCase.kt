package com.mb.newsappletzte.domain.usecases.news

import androidx.paging.PagingData
import com.mb.newsappletzte.domain.model.Article
import com.mb.newsappletzte.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNewsUseCase(private val newsRepository: NewsRepository) {

    operator fun invoke(searchQuery : String, sources: List<String>) : Flow<PagingData<Article>> {

        return newsRepository.searchNews(sources,searchQuery)
    }
}