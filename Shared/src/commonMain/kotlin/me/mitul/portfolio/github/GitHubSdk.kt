package me.mitul.portfolio.github

import me.mitul.portfolio.cache.Database
import me.mitul.portfolio.cache.DbDriverFactory

class GitHubSdk(factory: DbDriverFactory) {
    private val database = Database(factory)
    private val api = GitHubApi()

    @Throws(Exception::class)
    suspend fun getRepos(limit: Int, cached: Boolean): List<GitHubRepo> {
        if (limit <= 0) throw IllegalArgumentException("Limit cannot be zero.")
        val cachedRepos = database.repos
        return if (cached && cachedRepos.isNotEmpty()) cachedRepos
        else api.getRepos(limit = limit).also { repos ->
            database.insertRepos(repos = repos, clearOld = true)
        }
    }
}
