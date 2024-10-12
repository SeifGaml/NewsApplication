package com.example.newsapplication.domain.usecases.news

import androidx.paging.PagingData
import com.example.newsapplication.data.remote.dto.NewsResponse
import com.example.newsapplication.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import com.loc.newsapp.domain.model.Article


class GetNews(
    private val newsRepository: NewsRepository
){
    operator fun invoke(source:List<String>):Flow<PagingData<Article>> {
        return newsRepository.getNews(source = source)
    }
}