package me.mitul.portfolio.github

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class GitHubApi {
    private val endpoint = "https://api.github.com/users/mitulvaghamshi/repos"

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    @Throws(Exception::class)
    internal suspend fun getRepos(limit: Int) = client.get(endpoint) {
        header("Accept", "application/vnd.github+json")
        parameter("per_page", limit)
    }.body<List<GitHubRepo>>()
}
