package com.example.barchart.presentation.githubreposlist.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.barchart.R
import com.example.barchart.presentation.githubreposlist.model.GithubListUIModel
import com.example.barchart.presentation.githubreposlist.viewmodel.GithubListViewModel

@Composable
fun DetailScreen(gitHubObject: GithubListUIModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val repoName = gitHubObject.repoName
        Card(modifier = Modifier.background(color = Color.Cyan)) {
            Image(
                painter = painterResource(R.drawable.ramesh),
                contentDescription = "image"
            )
        }
        Text("This is detail screen $repoName")
    }
}

@Preview
@Composable
fun previewDetailScreen() {
    DetailScreen(GithubListUIModel(1, "", ""))
}
