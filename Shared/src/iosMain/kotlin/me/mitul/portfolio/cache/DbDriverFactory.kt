package me.mitul.portfolio.cache

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class DbDriverFactory {
    actual fun createDriver(): SqlDriver = NativeSqliteDriver(
        schema = RepoDatabase.Schema,
        name = "PortfolioRepoCache.db"
    )
}
