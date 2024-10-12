package com.example.newsapplication.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.newsapplication.Dimentions.MediumPadding1
import com.example.newsapplication.Dimentions.ExtraSmallPadding2

import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.presentation.common.ArticleCard

@Composable
fun ArticleList(
    modifier: Modifier =Modifier,
    articles: List<Article>,
    onclick:(Article)->Unit
){
        LazyColumn(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all =ExtraSmallPadding2 )
            ){
            items (
                count = articles.size
            ) {
                val article = articles[it]
                ArticleCard(article = article, onclick = { onclick(article) })


            }


        }

}
@Composable
fun handlePagingResult(article: LazyPagingItems<Article>
):Boolean{
    val loadState = article.loadState
    val error = when{
        loadState.refresh is LoadState.Error ->loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error ->loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error ->loadState.append as LoadState.Error
        else ->null
    }
    return when{
        loadState.refresh is LoadState.Loading->{
            ShimmerEfferct()
            false
        }
        error != null ->{
                EmptyScreen()
            false
        }
        else ->true

    }

}

@Composable
private fun ShimmerEfferct(){
    Column(verticalArrangement =  Arrangement.spacedBy(MediumPadding1)) {
        repeat(10){
            ArticleCardShimmerEffect(modifier =  Modifier.padding(horizontal = MediumPadding1))
        }

    }
}
