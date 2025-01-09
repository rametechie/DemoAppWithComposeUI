package com.example.barchart.presentation.githubreposlist.view.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.barchart.presentation.githubreposlist.model.GithubListUIModel
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


    // UI
//    if (repoListState.value != null) {
//        val repos = repoListState.value as List<GithubListUIModel>
//        LazyColumn {
//            items(repos) {
//                //replace with detailed ui
//                GitHubListItem(it) {
//                    println("panda: clicked item: ${it}")
//                    navigateToDetail(it)
//                }
//            }
//        }
//    }
}