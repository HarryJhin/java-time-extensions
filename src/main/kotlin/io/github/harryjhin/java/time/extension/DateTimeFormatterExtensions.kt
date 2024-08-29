package io.github.harryjhin.java.time.extension

import io.github.harryjhin.java.time.extension.JavaTimeExtensionConfiguration.PATTERN_MONTH
import io.github.harryjhin.java.time.extension.JavaTimeExtensionConfiguration.PATTERN_MONTH_DAY
import io.github.harryjhin.java.time.extension.JavaTimeExtensionConfiguration.PATTERN_OFFSET_DATE_TIME
import io.github.harryjhin.java.time.extension.JavaTimeExtensionConfiguration.PATTERN_OFFSET_TIME
import java.time.format.DateTimeFormatter

internal val PATTERN_MONTH: String = JavaTimeExtensionConfiguration.PATTERN_MONTH
internal val PATTERN_MONTH_DAY: String = JavaTimeExtensionConfiguration.PATTERN_MONTH_DAY
internal val PATTERN_LOCAL_DATE: String = JavaTimeExtensionConfiguration.PATTERN_LOCAL_DATE
internal val PATTERN_LOCAL_DATE_TIME: String = JavaTimeExtensionConfiguration.PATTERN_LOCAL_DATE_TIME
internal val PATTERN_LOCAL_TIME: String = JavaTimeExtensionConfiguration.PATTERN_LOCAL_TIME
internal val PATTERN_OFFSET_DATE_TIME: String = JavaTimeExtensionConfiguration.PATTERN_OFFSET_DATE_TIME
internal val PATTERN_OFFSET_TIME: String = JavaTimeExtensionConfiguration.PATTERN_OFFSET_TIME
internal val PATTERN_YEAR: String = JavaTimeExtensionConfiguration.PATTERN_YEAR
internal val PATTERN_YEAR_MONTH: String = JavaTimeExtensionConfiguration.PATTERN_YEAR_MONTH

/**
 * [java.time.Year] 기본 포맷터 [DateTimeFormatter]입니다.
 *
 * 패턴: `yyyy`
 */
internal val FORMATTER_YEAR: DateTimeFormatter by lazy {
    DateTimeFormatter.ofPattern(PATTERN_YEAR)
}

/**
 * [java.time.YearMonth] 기본 포맷터 [DateTimeFormatter]입니다.
 *
 * 패턴: `yyyy-MM`
 */
internal val FORMATTER_YEAR_MONTH: DateTimeFormatter by lazy {
    DateTimeFormatter.ofPattern(PATTERN_YEAR_MONTH)
}

/**
 * [java.time.Month] 기본 포맷터 [DateTimeFormatter]입니다.
 *
 * 패턴: `MM`
 */
internal val FORMATTER_MONTH: DateTimeFormatter by lazy {
    DateTimeFormatter.ofPattern(PATTERN_MONTH)
}

/**
 * [java.time.MonthDay] 기본 포맷터 [DateTimeFormatter]입니다.
 *
 * 패턴: `MM-dd`
 */
internal val FORMATTER_MONTH_DAY: DateTimeFormatter by lazy {
    DateTimeFormatter.ofPattern(PATTERN_MONTH_DAY)
}

/**
 * [java.time.LocalDate] 기본 포맷터 [DateTimeFormatter]입니다.
 *
 * 패턴: `yyyy-MM-dd`
 */
internal val FORMATTER_DATE: DateTimeFormatter by lazy {
    DateTimeFormatter.ofPattern(PATTERN_LOCAL_DATE)
}

/**
 * [java.time.LocalDateTime] 기본 포맷터 [DateTimeFormatter]입니다.
 *
 * 패턴: `yyyy-MM-dd'T'HH:mm:ss`
 */
internal val FORMATTER_DATE_TIME: DateTimeFormatter by lazy {
    DateTimeFormatter.ofPattern(PATTERN_LOCAL_DATE_TIME)
}

/**
 * [java.time.LocalTime] 기본 포맷터 [DateTimeFormatter]입니다.
 *
 * 패턴: `HH:mm:ss`
 */
internal val FORMATTER_TIME: DateTimeFormatter by lazy {
    DateTimeFormatter.ofPattern(PATTERN_LOCAL_TIME)
}

/**
 * [java.time.OffsetTime] 기본 포맷터 [DateTimeFormatter]입니다.
 *
 * 패턴: `HH:mm:ssXXX`
 */
internal val FORMATTER_OFFSET_TIME: DateTimeFormatter by lazy {
    DateTimeFormatter.ofPattern(PATTERN_OFFSET_TIME)
}

/**
 * [java.time.OffsetDateTime] 기본 포맷터 [DateTimeFormatter]입니다.
 *
 * 패턴: `yyyy-MM-dd'T'HH:mm:ssXXX`
 */
internal val FORMATTER_OFFSET_DATE_TIME: DateTimeFormatter by lazy {
    DateTimeFormatter.ofPattern(PATTERN_OFFSET_DATE_TIME)
}
