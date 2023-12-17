package me.mitul.portfolio.shared

import java.text.DateFormat
import java.util.Date

internal actual object Utils {
    actual val currentYear = extractYear()

    private fun extractYear(): String = DateFormat
        .getDateInstance(DateFormat.YEAR_FIELD)
        .format(Date()).takeLast(n = 4)
}
