package io.github.harryjhin.java.time.extension

import java.time.format.DateTimeFormatter

internal const val PATTERN_YEAR_MONTH: String = "yyyy-MM"
internal val FORMATTER_YEAR_MONTH: DateTimeFormatter by lazy {
    DateTimeFormatter.ofPattern(PATTERN_YEAR_MONTH)
}
