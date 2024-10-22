package com.example.barchart.data.githubreposlist.repository

import com.example.barchart.common.network.ktor.httpClientAndroid
import com.example.barchart.data.githubreposlist.mapper.mapDataToDomainReposList
import com.example.barchart.data.githubreposlist.service.GithubListService
import com.example.barchart.domain.githubreposlist.model.GitHubListRepos
import com.example.barchart.domain.githubreposlist.repository.GithubListRepository

//hilt
class GithubListRepositoryImpl: GithubListRepository {

    override suspend fun fetchReposList(): List<GitHubListRepos> {
        val apiService = GithubListService(httpClientAndroid)
        val response = apiService.getRepos()

        //map to the domain model
        return mapDataToDomainReposList(response)
    }
}