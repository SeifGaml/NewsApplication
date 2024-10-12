package com.example.newsapplication.domain.usecases.news

import com.example.newsapplication.data.local.NewsDao
import com.loc.newsapp.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article){
        newsDao.upsert(article)
    }
}