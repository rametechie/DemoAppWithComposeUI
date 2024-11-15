package com.example.barchart.presentation.githubreposlist.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.example.barchart.presentation.githubreposlist.model.GithubListUIModel
import com.example.barchart.presentation.githubreposlist.viewmodel.GithubListViewModel

@Composable
fun DetailScreen(navController: NavController, gitHubObject: GithubListUIModel) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val repoName = gitHubObject.repoName
        Text("This is detail screen $repoName")
    }
}