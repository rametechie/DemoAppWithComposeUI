package com.example.barchart.presentation.githubreposlist.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.barchart.presentation.githubreposlist.model.GithubListUIModel
import com.example.barchart.presentation.githubreposlist.viewmodel.GithubListViewModel
import com.example.barchart.presentation.widget.theme.BarChartTheme
import dagger.hilt.android.AndroidEntryPoint

//hilt
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: GithubListViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BarChartTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                        RepoListView(viewModel)
                }
            }
        }
    }
}

@Composable
fun RepoListView(
    viewModel: GithubListViewModel
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
                    //TODO..launch detail screen
                    println("panda: clicked item: ${it.repoName}")
                  }

            }
        }
    }
}

