package com.example.newsapplication.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSourceFactory
import com.example.newsapplication.data.remote.NewsPagSource
import com.example.newsapplication.data.remote.SearchNewsPagingSource
import com.example.newsapplication.data.remote.dto.NewsApi
import com.example.newsapplication.data.remote.dto.NewsResponse
import com.example.newsapplication.domain.repository.NewsRepository
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(private val newsApi: NewsApi ):NewsRepository {
    override fun getNews(source: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = {
                NewsPagSource(
                    newsApi = newsApi,
                    source = source.joinToString(separator = " ,")
                )
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, source: List<String>): Flow<PagingData<Article>> {
            return Pager(
                config = PagingConfig(10),
                pagingSourceFactory = {
                    SearchNewsPagingSource(
                        searchQuery = searchQuery,
                        newsApi = newsApi,
                        source = source.joinToString(separator = " ,")
                    )
                }
            ).flow
    }
}