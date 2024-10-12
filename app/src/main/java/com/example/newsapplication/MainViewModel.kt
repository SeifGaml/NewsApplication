package com.example.newsapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplication.domain.usecases.app_entry.AppEntryUseCases
import com.example.newsapplication.presentation.navgrph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
):ViewModel() {
    var splashCondition by mutableStateOf(true)
    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
    init {
        appEntryUseCases.readAppEntry().onEach { shouldStartFromHome ->
            if (shouldStartFromHome){
                startDestination = Route.NewsNavigation.route
            }else{
                startDestination =Route.AppStartNavigation.route
            }
            delay(300)
            splashCondition =false
        }.launchIn(viewModelScope)
    }

}