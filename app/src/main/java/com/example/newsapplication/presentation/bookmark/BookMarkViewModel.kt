package com.example.newsapplication.presentation.bookmark

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplication.domain.usecases.news.NewsUseCases
import com.loc.newsapp.domain.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {

    // Private mutable state for the ViewModel
    private val _state = mutableStateOf(BookMarkItemState())

    // Public immutable state for UI to observe
    val state: State<BookMarkItemState> = _state

    init {
        getArticles()
    }

    // Function to fetch articles
    private fun getArticles() {
        // Set loading to true while fetching
        _state.value = _state.value.copy(isLoading = true)

        newsUseCases.getArticles()
            .onEach { articles ->
                // Update state with fetched articles
                _state.value = _state.value.copy(
                    articles = articles,
                    isLoading = false,
                    errorMessage = null // Reset error message on successful fetch
                )
            }
            .catch { exception ->
                // Handle errors and update the state with an error message
                _state.value = _state.value.copy(
                    isLoading = false,
                    errorMessage = exception.message ?: "An error occurred"
                )
            }
            .launchIn(viewModelScope)
    }
}

data class BookMarkItemState(
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val errorMessage: String? = null
)

