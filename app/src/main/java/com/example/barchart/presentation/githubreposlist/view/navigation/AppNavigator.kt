package com.example.barchart.presentation.githubreposlist.view.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.barchart.presentation.githubreposlist.model.GithubListUIModel
import com.example.barchart.presentation.githubreposlist.view.screens.DetailScreen
import com.example.barchart.presentation.githubreposlist.view.screens.RepoListView
import com.example.barchart.presentation.githubreposlist.viewmodel.GithubListViewModel


@Composable
fun AppNavigator() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "List"
    ) {
        composable (route = "List") {

          RepoListView(viewModel = hiltViewModel<GithubListViewModel>(),
              navigateToDetail = { data ->
                  // Pass the github object as a Parcelable
                  navController.currentBackStackEntry?.savedStateHandle?.set("data", data)
                  navController.navigate("Detail")
              }
          )
        }

        composable (route = "Detail") {
            val gitHubObject = navController.previousBackStackEntry?.savedStateHandle?.get<GithubListUIModel>("data")

            gitHubObject?.let { it1 ->
                DetailScreen(
                    it1
                )
            }
        }
    }
}