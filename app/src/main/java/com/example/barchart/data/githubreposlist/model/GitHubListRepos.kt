package com.example.barchart.data.githubreposlist.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubListRepos(
    val id: Int,
    @SerialName("name")
    val repoName: String,
    val owner: Owner
)

@Serializable
data class Owner(
    @SerialName("avatar_url")
    val avatarUrl: String
)