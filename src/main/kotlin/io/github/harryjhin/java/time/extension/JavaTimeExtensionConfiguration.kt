package io.github.harryjhin.java.time.extension

import java.util.Properties

internal object JavaTimeExtensionConfiguration {

    private val properties: Properties = Properties().apply {
        JavaTimeExtensionConfiguration::class.java.getResourceAsStream("/java-time-extensions.properties")?.run {
            load(this)
        }
    }

    val PATTERN_YEAR: String = properties.getProperty("pattern.year") ?: "yyyy"
    val PATTERN_MONTH: String = properties.getProperty("pattern.month") ?: "MM"
    val PATTERN_YEAR_MONTH: String = properties.getProperty("pattern.year-month") ?: "yyyy-MM"
    val PATTERN_MONTH_DAY: String = properties.getProperty("pattern.month-day") ?: "MM-dd"
    val PATTERN_LOCAL_DATE: String = properties.getProperty("pattern.local-date") ?: "yyyy-MM-dd"
    val PATTERN_LOCAL_DATE_TIME: String = properties.getProperty("pattern.local-date-time") ?: "yyyy-MM-dd'T'HH:mm:ss"
    val PATTERN_LOCAL_TIME: String = properties.getProperty("pattern.local-time") ?: "HH:mm:ss"
    val PATTERN_OFFSET_TIME: String = properties.getProperty("pattern.offset-time") ?: "HH:mm:ssXXX"
    val PATTERN_OFFSET_DATE_TIME: String = properties.getProperty("pattern.offset-date-time") ?: "yyyy-MM-dd'T'HH:mm:ssXXX"
}