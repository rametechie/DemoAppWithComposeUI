package com.example.barchart.presentation.githubreposlist.view.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.example.barchart.presentation.githubreposlist.model.GithubListUIModel
import com.example.barchart.presentation.githubreposlist.view.GitHubListItem
import com.example.barchart.presentation.githubreposlist.viewmodel.GithubListViewModel

@Composable
fun RepoListView (
    viewModel: GithubListViewModel,
    navigateToDetail: (GithubListUIModel) -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.fetchReposList()
    }

    // State
    val repoListState = viewModel.reposList.observeAsState()

    // UI
    if (repoListState.value != null) {
        val repos = repoListState.value as List<GithubListUIModel>
        LazyColumn {
            items(repos) {
                //replace with detailed ui
                GitHubListItem(it) {
                    println("panda: clicked item: ${it}")
                    navigateToDetail(it)
                }
            }
        }
    }
}