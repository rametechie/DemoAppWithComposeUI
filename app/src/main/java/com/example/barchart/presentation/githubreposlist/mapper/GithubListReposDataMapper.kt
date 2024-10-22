package com.example.barchart.presentation.githubreposlist.mapper

import com.example.barchart.presentation.githubreposlist.model.GithubListUIModel
import com.example.barchart.domain.githubreposlist.model.GitHubListRepos as DomainGitHubListRepos

fun mapDomainToPresentationReposList(response: List<DomainGitHubListRepos>): List<GithubListUIModel> {
    val repoList = mutableListOf<GithubListUIModel>()
    response.forEach { domainModel ->
        repoList.add(
            GithubListUIModel(
                id = domainModel.id,
                repoName = domainModel.repoName,
                avatar = domainModel.avatar
            )
        )
    }
    return repoList
}
