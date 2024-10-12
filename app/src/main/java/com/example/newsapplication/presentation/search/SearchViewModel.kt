package com.example.newsapplication.presentation.search

import androidx.compose.runtime.mutableStateOf

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsapplication.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases

):ViewModel(){
    private val _State = mutableStateOf(SearchState())
    val state: State<SearchState> = _State
    fun onEvent(event: SearchEvent){
        when(event){
            is SearchEvent.UpdateSearchQuery ->{
                _State.value = _State.value.copy(searchQuery = event.searchQuery)

            }
            is SearchEvent.searchNews->{
                SearchNews()

            }
        }
    }

    private fun SearchNews() {
        val articles = newsUseCases.searchNews(
            searchQuery = _State.value.searchQuery,
            source = listOf("bbc-news", "abc-news", "al-jazeera-english")
        ).cachedIn(viewModelScope)
        _State.value =_State.value.copy(article = articles)
    }
}