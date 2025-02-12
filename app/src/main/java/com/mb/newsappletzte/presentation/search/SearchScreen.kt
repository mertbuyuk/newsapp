package com.mb.newsappletzte.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.mb.newsappletzte.presentation.Dimens.MediumPadding1
import com.mb.newsappletzte.presentation.common.ArticlesList
import com.mb.newsappletzte.presentation.common.SearchBar

@Composable
fun SearchScreen(modifier: Modifier = Modifier,
                 state: SearchState,
                 event:(SearchEvent)->Unit) {

    Column(
        modifier = Modifier
            .padding(top = MediumPadding1, start = MediumPadding1, end = MediumPadding1)
            .statusBarsPadding()
    ) {
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.updateSearchQuery(it)) },
            onSearch = {
                event(SearchEvent.SearchNews)
            }
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        state.articles?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticlesList(
                articles = articles
            ) {
                //TODO: Navigate to details screen
            }
        }
    }
}