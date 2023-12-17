package me.mitul.portfolio.cache

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(
        context = context,
        schema = RepoDatabase.Schema,
        name = "PortfolioRepoCache.db",
    )
}
