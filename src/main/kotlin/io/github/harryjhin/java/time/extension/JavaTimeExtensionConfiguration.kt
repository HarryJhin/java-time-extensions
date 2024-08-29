package io.github.harryjhin.java.time.extension

import java.time.format.DateTimeFormatter
import java.util.Properties

/**
 * [JavaTimeExtensionConfiguration] 오브젝트는 날짜와 시간, 그리고 시간대의 형식을 지정하기 위해 다양한 패턴을 정의하고
 * 이 패턴에 따라 [DateTimeFormatter]를 제공하는 구성 객체입니다.
 *
 * 이 오브젝트는 `java-time-extensions.properties` 파일을 읽어와서 패턴을 정의하며, 파일이 존재하지 않는 경우 기본값을 사용합니다.
 *
 * 지원하는 타입:
 *
 * - java.time.LocalDate: `pattern.local-date` (기본값: `yyyy-MM-dd`)
 * - java.time.LocalDateTime: `pattern.local-date-time` (기본값: `yyyy-MM-dd'T'HH:mm:ss`)
 * - java.time.LocalTime: `pattern.local-time` (기본값: `HH:mm:ss`)
 * - java.time.Month: `pattern.month` (기본값: `MM`)
 * - java.time.MonthDay: `pattern.month-day` (기본값: `MM-dd`)
 * - java.time.OffsetDateTime: `pattern.offset-date-time` (기본값: `yyyy-MM-dd'T'HH:mm:ssXXX`)
 * - java.time.OffsetTime: `pattern.offset-time` (기본값: `HH:mm:ssXXX`)
 * - java.time.Year: `pattern.year` (기본값: `yyyy`)
 * - java.time.YearMonth: `pattern.year-month` (기본값: `yyyy-MM`)
 * - java.time.ZonedDateTime: `pattern.zoned-date-time` (기본값: `yyyy-MM-dd'T'HH:mm:ssXXX`)
 *
 * @since 0.13.7
 */
internal object JavaTimeExtensionConfiguration {

    private val properties: Properties = Properties().apply {
        JavaTimeExtensionConfiguration::class.java.getResourceAsStream("/java-time-extensions.properties")?.run {
            load(this)
        }
    }

    val PATTERN_LOCAL_DATE: String = properties.getProperty("pattern.local-date") ?: "yyyy-MM-dd"
    val PATTERN_LOCAL_DATE_TIME: String = properties.getProperty("pattern.local-date-time") ?: "yyyy-MM-dd'T'HH:mm:ss"
    val PATTERN_LOCAL_TIME: String = properties.getProperty("pattern.local-time") ?: "HH:mm:ss"
    val PATTERN_MONTH_DAY: String = properties.getProperty("pattern.month-day") ?: "MM-dd"
    val PATTERN_OFFSET_DATE_TIME: String = properties.getProperty("pattern.offset-date-time") ?: "yyyy-MM-dd'T'HH:mm:ssXXX"
    val PATTERN_OFFSET_TIME: String = properties.getProperty("pattern.offset-time") ?: "HH:mm:ssXXX"
    val PATTERN_YEAR: String = properties.getProperty("pattern.year") ?: "yyyy"
    val PATTERN_YEAR_MONTH: String = properties.getProperty("pattern.year-month") ?: "yyyy-MM"
    val PATTERN_ZONED_DATE_TIME: String = properties.getProperty("pattern.zoned-date-time") ?: "yyyy-MM-dd'T'HH:mm:ssXXX"

    val FORMATTER_LOCAL_DATE: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_LOCAL_DATE)
    }

    val FORMATTER_LOCAL_DATE_TIME: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_LOCAL_DATE_TIME)
    }

    val FORMATTER_LOCAL_TIME: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_LOCAL_TIME)
    }

    val FORMATTER_MONTH_DAY: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_MONTH_DAY)
    }

    val FORMATTER_OFFSET_DATE_TIME: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_OFFSET_DATE_TIME)
    }

    val FORMATTER_OFFSET_TIME: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_OFFSET_TIME)
    }

    val FORMATTER_YEAR: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_YEAR)
    }

    val FORMATTER_YEAR_MONTH: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_YEAR_MONTH)
    }

    val FORMATTER_ZONED_DATE_TIME: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_ZONED_DATE_TIME)
    }
}