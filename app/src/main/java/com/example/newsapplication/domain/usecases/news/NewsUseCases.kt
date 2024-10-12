package com.example.newsapplication.domain.usecases.news

data class NewsUseCases(
    val getNews: GetNews,
    val searchNews :SearchNews,
    val upsertArticle: UpsertArticle,
    val deleteArticle: DeleteArticle,
    val getArticles: GetArticles,
  /*  val getArticle: DeleteArticle*/
)
