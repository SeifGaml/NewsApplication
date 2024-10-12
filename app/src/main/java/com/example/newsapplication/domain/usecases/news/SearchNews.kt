package com.example.newsapplication.domain.usecases.news

import androidx.paging.PagingData
import com.example.newsapplication.domain.repository.NewsRepository
import com.example.newsapplication.presentation.search.SearchEvent
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String,source:List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery = searchQuery,source = source)
    }
}