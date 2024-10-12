package com.example.newsapplication.data.remote

import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsapplication.data.remote.dto.NewsApi
import com.loc.newsapp.domain.model.Article

class NewsPagSource(
    private val newsApi: NewsApi,
    private val source: String
):PagingSource<Int,Article>(){
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPostion->
            val anchorPage = state.closestPageToPosition(anchorPostion)
            anchorPage?.prevKey?.plus(1)?: anchorPage?.nextKey?.minus(1)
        }

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key?: 1
        var totalNewsResult = 0
        return try {
            val newsResponse = newsApi.getNews(source = source , page = page)
            totalNewsResult += newsResponse.articles.size
            val article = newsResponse.articles.distinctBy { it.title }
            LoadResult.Page(
                data = article,
                nextKey = if (totalNewsResult == newsResponse.articles.size) null else page +1,
                prevKey = null
            )

        }catch (e:Exception){
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }
}