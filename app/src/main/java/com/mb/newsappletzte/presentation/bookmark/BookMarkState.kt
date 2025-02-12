package com.mb.newsappletzte.presentation.bookmark

import com.mb.newsappletzte.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)