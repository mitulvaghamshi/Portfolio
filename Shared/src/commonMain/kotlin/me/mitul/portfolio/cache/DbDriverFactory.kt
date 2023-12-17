package me.mitul.portfolio.cache

import app.cash.sqldelight.db.SqlDriver

expect class DbDriverFactory {
    fun createDriver(): SqlDriver
}
