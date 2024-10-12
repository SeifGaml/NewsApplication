package com.example.newsapplication.presentation.navgrph

sealed class Route(
    val route: String
) {
    object OnBoardingScreen:Route(route = "OnBoardingScreen")
    object HomeScreen:Route(route = "HomeScreen")
    object SearchScreen:Route(route = "searchScreen")
    object BookMarkScreen:Route(route = "bookMarkScreen")
    object DetailsScreen:Route(route = "DetailsScreen")
    object AppStartNavigation:Route(route = "appStartNavigationScreen")
    object NewsNavigation:Route(route = "NewsNavigation")
    object NewsNavigatorScreen:Route(route= "newsNavigator")
}