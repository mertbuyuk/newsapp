package com.mb.newsappletzte.data.remote.dto

import com.mb.newsappletzte.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)