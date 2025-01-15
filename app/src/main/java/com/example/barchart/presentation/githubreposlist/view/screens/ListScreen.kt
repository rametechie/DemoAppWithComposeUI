package com.example.barchart.presentation.githubreposlist.view.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
    val repoListState = viewModel.uiState.collectAsStateWithLifecycle()


        LazyColumn {
            items(repoListState.value.data) {
                //replace with detailed ui
                GitHubListItem(it) {
                    println("values of each item: clicked item: ${it}")
                    navigateToDetail(it)
                }
            }
        }
}