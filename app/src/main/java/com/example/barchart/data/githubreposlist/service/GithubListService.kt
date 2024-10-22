package com.example.barchart.data.githubreposlist.service

import android.util.Log
import com.example.barchart.data.githubreposlist.model.GitHubListRepos
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

//hilt
class GithubListService(private val client: HttpClient) {
    companion object {
        private const val END_POINT = "https://api.github.com/users/rametechie/repos"
    }

    suspend fun getRepos(): List<GitHubListRepos> {
        val response = client.get(END_POINT)
        if (response.status.value == 200) {
            println("panda: $response")
            return response.body<List<GitHubListRepos>>()
        }
        Log.d("GithubListService", "getRepos: Response status: ${response.status.value}")
        return emptyList()
    }
}