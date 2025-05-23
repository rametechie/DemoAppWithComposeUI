package com.example.barchart.domain.githubreposlist.repository

import com.example.barchart.domain.githubreposlist.model.GitHubListRepos
import kotlinx.coroutines.flow.Flow

interface GithubListRepository {
    suspend fun fetchReposList(): Flow<List<GitHubListRepos>>
}