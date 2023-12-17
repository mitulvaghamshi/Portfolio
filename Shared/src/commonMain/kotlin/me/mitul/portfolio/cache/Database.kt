package me.mitul.portfolio.cache

import me.mitul.portfolio.github.GitHubRepo

internal class Database(factory: DbDriverFactory) {
    private val database = RepoDatabase(driver = factory.createDriver())
    private val dbQuery = database.repoDatabaseQueries

    internal val repos: List<GitHubRepo>
        get() = dbQuery.selectRepos(mapper = ::mapRepo).executeAsList()

    internal fun insertRepos(repos: List<GitHubRepo>, clearOld: Boolean) = dbQuery.transaction {
        if (clearOld) {
            dbQuery.removeTopics()
            dbQuery.removeRepos()
        }
        repos.forEach { repo ->
            insertRepo(repo = repo)
            insertTopics(topics = repo.topics, repoId = repo.id)
        }
    }

    private fun mapRepo(
        id: Long,
        name: String,
        url: String,
        size: Long,
        language: String?,
        description: String?,
    ): GitHubRepo = GitHubRepo(
        id = id,
        name = name,
        url = url,
        size = size.toInt(),
        language = language,
        description = description,
        topics = getTopicsFor(repoId = id),
    )

    private fun getTopicsFor(repoId: Long): List<String> = dbQuery
        .selectTopicsByRepoId(repo_id = repoId)
        .executeAsList()

    private fun insertRepo(repo: GitHubRepo) = dbQuery.insertRepo(
        id = repo.id,
        name = repo.name,
        url = repo.url,
        size = repo.size.toLong(),
        language = repo.language,
        description = repo.description,
    )

    private fun insertTopics(topics: List<String>, repoId: Long) = topics.forEach { topic ->
        dbQuery.insertTopic(topic_name = topic, repo_id = repoId)
    }
}
