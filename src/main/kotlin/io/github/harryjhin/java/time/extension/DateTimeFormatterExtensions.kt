package io.github.harryjhin.java.time.extension

import java.time.format.DateTimeFormatter

/**
 * [java.time.Year] 기본 패턴 `yyyy`를 나타냅니다.
 */
internal const val PATTERN_YEAR: String = "yyyy"

/**
 * [java.time.YearMonth] 기본 패턴 `yyyy-MM`을 나타냅니다.
 */
internal const val PATTERN_YEAR_MONTH: String = "yyyy-MM"

/**
 * [java.time.Month] 기본 패턴 `MM`을 나타냅니다.
 */
internal const val PATTERN_MONTH: String = "MM"

/**
 * [java.time.MonthDay] 기본 패턴 `--MM-dd`을 나타냅니다.
 */
internal const val PATTERN_MONTH_DAY: String = "--MM-dd"

/**
 * [java.time.LocalDate] 기본 패턴 `yyyy-MM-dd`을 나타냅니다.
 */
internal const val PATTERN_DATE: String = "yyyy-MM-dd"

/**
 * [java.time.LocalDateTime] 기본 패턴 `yyyy-MM-dd'T'HH:mm:ss`을 나타냅니다.
 */
internal const val PATTERN_DATE_TIME: String = "yyyy-MM-dd'T'HH:mm:ss"

/**
 * [java.time.LocalTime] 기본 패턴 `HH:mm:ss`을 나타냅니다.
 */
internal const val PATTERN_TIME: String = "HH:mm:ss"

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
 * 패턴: `--MM-dd`
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
    DateTimeFormatter.ofPattern(PATTERN_DATE)
}

/**
 * [java.time.LocalDateTime] 기본 포맷터 [DateTimeFormatter]입니다.
 *
 * 패턴: `yyyy-MM-dd'T'HH:mm:ss`
 */
internal val FORMATTER_DATE_TIME: DateTimeFormatter by lazy {
    DateTimeFormatter.ofPattern(PATTERN_DATE_TIME)
}

/**
 * [java.time.LocalTime] 기본 포맷터 [DateTimeFormatter]입니다.
 *
 * 패턴: `HH:mm:ss`
 */
internal val FORMATTER_TIME: DateTimeFormatter by lazy {
    DateTimeFormatter.ofPattern(PATTERN_TIME)
}
