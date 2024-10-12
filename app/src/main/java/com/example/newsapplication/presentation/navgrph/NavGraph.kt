package com.example.newsapplication.presentation.navgrph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsapplication.presentation.bookmark.BookMarkViewModel
import com.example.newsapplication.presentation.bookmark.BookmarkScreen
import com.example.newsapplication.presentation.home.HomeScreen
import com.example.newsapplication.presentation.home.HomeViewModel
import com.example.newsapplication.presentation.onboarding.OnBoardingScreen
import com.example.newsapplication.presentation.onboarding.OnBoardingViewModel
import com.example.newsapplication.presentation.search.SearchScreen
import com.example.newsapplication.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination:String
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =  startDestination){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(
                route = Route.OnBoardingScreen.route
            ){
                val viewModel :OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = viewModel::onEvent)
                
            }
        }
        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ){
            composable(route = Route.NewsNavigatorScreen.route){
               val viewModel :BookMarkViewModel = hiltViewModel()
                BookmarkScreen(state =viewModel.state.value , navigateToDetails ={} )
            }
        }
        
        
    }
    
}