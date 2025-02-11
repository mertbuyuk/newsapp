package com.mb.newsappletzte.domain.usecases.news

import javax.inject.Inject

data class NewsUseCases (
    val getNews: GetNewsUseCase,
    val searchNews: SearchNewsUseCase
)