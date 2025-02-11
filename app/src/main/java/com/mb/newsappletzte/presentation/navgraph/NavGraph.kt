package com.mb.newsappletzte.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation

import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.mb.newsappletzte.presentation.home.HomeScreen
import com.mb.newsappletzte.presentation.home.HomeViewModel
import com.mb.newsappletzte.presentation.onboarding.OnBoardingScreen
import com.mb.newsappletzte.presentation.onboarding.OnBoardingViewModel
import com.mb.newsappletzte.presentation.search.SearchScreen
import com.mb.newsappletzte.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onEvent = viewModel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.HomeScreen.route
        ) {
            composable(route = Route.HomeScreen.route) {
                val viewModel : HomeViewModel = hiltViewModel()
                val articles = viewModel.news.collectAsLazyPagingItems()

                HomeScreen(articles = articles, navigate = {
                    navController.navigate(it)
                })
            }
            composable(route = Route.SearchScreen.route) {
                val viewModel : SearchViewModel = hiltViewModel()
                SearchScreen(state = viewModel.state.value, event = {
                    viewModel.onEvent(it)
                })
            }
            composable(route = Route.BookmarkScreen.route) {

            }
            composable(route = Route.DetailsScreen.route) {

            }
        }
    }
}