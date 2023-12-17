package me.mitul.portfolio.github

import me.mitul.portfolio.cache.Database
import me.mitul.portfolio.cache.DriverFactory

class GitHubSdk(factory: DriverFactory) {
    private val database = Database(factory)
    private val api = GitHubApi()

    @Throws(Exception::class)
    suspend fun getRepos(limit: Int, cached: Boolean): List<GitHubRepo> {
        if (limit <= 0) throw IllegalArgumentException("[Error]: Repo limit cannot be zero.")
        val repos = if (cached) database.repos else listOf()
        return repos.ifEmpty {
            api.getRepos(limit = limit).also {
                database.insertAll(repos = it, reload = !cached)
            }
        }
    }
}
