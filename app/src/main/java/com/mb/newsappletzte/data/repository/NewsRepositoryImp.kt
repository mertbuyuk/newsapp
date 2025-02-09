package com.mb.newsappletzte.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.mb.newsappletzte.data.remote.GetNewsApi
import com.mb.newsappletzte.data.remote.NewsPagingSource
import com.mb.newsappletzte.domain.model.Article
import com.mb.newsappletzte.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImp(private val newsApi: GetNewsApi) : NewsRepository{
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {

        //Pager sinifimizi olusturduk sonrasinda asagida ki fonk ile
        //kkullanacagi apiyi verdik ve bu pager icinde istekte bulunduk
        //10 10 cek
        return Pager(config = PagingConfig(pageSize = 10)
            , pagingSourceFactory = {
                NewsPagingSource(newsApi = newsApi, sources = sources.joinToString(separator = ","))
            }).flow
    }
}