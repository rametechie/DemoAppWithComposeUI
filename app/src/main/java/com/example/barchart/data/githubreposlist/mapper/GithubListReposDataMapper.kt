package com.example.barchart.data.githubreposlist.mapper

import com.example.barchart.data.githubreposlist.model.GitHubListRepos
import com.example.barchart.domain.githubreposlist.model.GitHubListRepos as DomainGitHubListRepos

fun mapDataToDomainReposList(response: List<GitHubListRepos>): List<DomainGitHubListRepos> {
    val repoList = mutableListOf<com.example.barchart.domain.githubreposlist.model.GitHubListRepos>()
    response.forEach { repo ->
        repoList.add(
            DomainGitHubListRepos(
                id = repo.id,
                repoName = repo.repoName,
                avatar = repo.owner.avatarUrl
            )
        )
    }
    return repoList
}

