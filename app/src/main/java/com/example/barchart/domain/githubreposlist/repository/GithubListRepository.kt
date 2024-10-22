package com.example.barchart.domain.githubreposlist.repository

import com.example.barchart.domain.githubreposlist.model.GitHubListRepos

//hilt
interface GithubListRepository {

    suspend fun fetchReposList(): List<GitHubListRepos>
}