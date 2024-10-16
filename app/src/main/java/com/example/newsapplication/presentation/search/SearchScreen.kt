package com.example.newsapplication.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsapplication.Dimentions.MediumPadding1
import com.example.newsapplication.presentation.common.ArticleList
import com.example.newsapplication.presentation.common.SearchBar

@Composable
fun SearchScreen(
    state:SearchState,
    event: (SearchEvent)->Unit,
    navigate:(String)->Unit

){
    Column(modifier = Modifier
        .padding(
            top = MediumPadding1,
            start = MediumPadding1,
            end = MediumPadding1
        )
        .statusBarsPadding()
    ){
        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChange = {event(SearchEvent.UpdateSearchQuery(it))},
            onSearch = {
            event(SearchEvent.searchNews)
            }
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        state.article?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticleList(
                articles = articles,
                onclick = {
                    //TODO: Navigate to details screen
                }
            )
        }
    }
}