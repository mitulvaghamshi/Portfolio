package me.mitul.portfolio.shared

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter

internal actual object Utils {
    actual val currentYear = extractYear()

    private fun extractYear(): String {
        val formatter = NSDateFormatter()
        formatter.dateFormat = "yyyy"
        return formatter.stringFromDate(NSDate())
    }
}
