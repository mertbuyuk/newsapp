package com.mb.newsappletzte.domain.repository

import androidx.paging.PagingData
import com.mb.newsappletzte.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>) : Flow<PagingData<Article>>
}