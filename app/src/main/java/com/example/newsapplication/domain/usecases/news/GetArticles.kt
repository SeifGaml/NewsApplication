package com.example.newsapplication.domain.usecases.news

import com.example.newsapplication.data.local.NewsDao
import com.loc.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetArticles(
    private val newsDao: NewsDao
) {
          operator fun invoke(): Flow<List<Article>> {
           return newsDao.getArticleByUrl()
        }

}