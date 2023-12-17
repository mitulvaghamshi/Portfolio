package me.mitul.portfolio.cache

import me.mitul.portfolio.github.GitHubRepo

class Database(
    factory: DriverFactory,
) {
    private val database = RepoDatabase(driver = factory.createDriver())
    private val dbQuery = database.repoDatabaseQueries

    internal val repos by lazy { dbQuery.selectRepos(::mapRepo).executeAsList() }

    private val topics = { id: Long -> dbQuery.selectTopicsByRepoId(id).executeAsList() }

    internal fun insertAll(repos: List<GitHubRepo>, reload: Boolean) = dbQuery.transaction {
        if (reload) {
            dbQuery.removeTopics()
            dbQuery.removeRepos()
        }
        repos.forEach(insert)
    }

    private val insert = { repo: GitHubRepo ->
        dbQuery.insertRepo(
            id = repo.id,
            name = repo.name,
            url = repo.url,
            size = repo.size.toLong(),
            language = repo.language,
            description = repo.description,
        )
        repo.topics.forEach {
            dbQuery.insertTopic(topic_name = it, repo_id = repo.id)
        }
    }

    private fun mapRepo(
        id: Long,
        name: String,
        url: String,
        size: Long,
        language: String?,
        description: String?,
    ) = GitHubRepo(
        id = id,
        name = name,
        url = url,
        size = size.toInt(),
        language = language,
        description = description,
        topics = topics(id),
    )
}
