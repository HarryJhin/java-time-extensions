package io.github.harryjhin.java.time.extension

import java.time.DateTimeException
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Month
import java.time.MonthDay
import java.time.OffsetDateTime
import java.time.Period
import java.time.Year
import java.time.YearMonth
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

/**
 * [String]을 연(Year) 단위의 [Period]로 변환합니다.
 *
 * ```kotlin
 * val year: Period = "2022".years // P2022Y
 * ```
 *
 * @return 지정된 연 수를 나타내는 [Period] 인스턴스
 * @throws NumberFormatException 문자열이 숫자로 변환할 수 없는 경우
 * @since 0.3.0
 */
val String.years: Period
    get() = this.toInt().years

/**
 * [String]을 월(month) 단위의 [Period]로 변환합니다.
 *
 * ```kotlin
 * val month: Period = "3".months // P3M
 * ```
 *
 * @return 지정된 월 수를 나타내는 [Period] 인스턴스
 * @throws NumberFormatException 문자열이 숫자로 변환할 수 없는 경우
 * @since 0.3.0
 */
val String.months: Period
    get() = this.toInt().months

/**
 * [String]을 일(day) 단위의 [Period]로 변환합니다.
 *
 * ```kotlin
 * val day: Period = "14".days // P14D
 * ```
 *
 * @return 지정된 일 수를 나타내는 [Period] 인스턴스
 * @throws NumberFormatException 문자열이 숫자로 변환할 수 없는 경우
 * @since 0.3.0
 */
val String.days: Period
    get() = this.toInt().days

/**
 * [String]을 시간(hour) 단위의 [Duration]으로 변환합니다.
 *
 * ```kotlin
 * val hour: Duration = "1".hours // PT1H
 * ```
 *
 * @return 지정된 시간 기간을 나타내는 [Duration] 인스턴스
 * @throws NumberFormatException 문자열이 숫자로 변환할 수 없는 경우
 * @since 0.3.0
 */
val String.hours: Duration
    get() = this.toLong().hours

/**
 * [String]을 분(minute) 단위의 [Duration]으로 변환합니다.
 *
 * ```kotlin
 * val minute: Duration = "30".minutes // PT30M
 * ```
 *
 * @return 지정된 분 기간을 나타내는 [Duration] 인스턴스
 * @throws NumberFormatException 문자열이 숫자로 변환할 수 없는 경우
 * @since 0.3.0
 */
val String.minutes: Duration
    get() = this.toLong().minutes

/**
 * [String]을 초(second) 단위의 [Duration]으로 변환합니다.
 *
 * ```kotlin
 * val second: Duration = "30".seconds // PT30S
 * ```
 *
 * @return 지정된 초 기간을 나타내는 [Duration] 인스턴스
 * @throws NumberFormatException 문자열이 숫자로 변환할 수 없는 경우
 * @since 0.3.0
 */
val String.seconds: Duration
    get() = this.toLong().seconds

/**
 * [String]을 밀리초(millisecond) 단위의 [Duration]으로 변환합니다.
 *
 * ```kotlin
 * val millisecond: Duration = "1".milliseconds // PT0.001S
 * ```
 *
 * @return 지정된 밀리초 기간을 나타내는 [Duration] 인스턴스
 * @throws NumberFormatException 문자열이 숫자로 변환할 수 없는 경우
 * @since 0.3.0
 */
val String.milliseconds: Duration
    get() = this.toLong().milliseconds

/**
 * [String]을 마이크로초(microsecond) 단위의 [Duration]으로 변환합니다.
 *
 * ```kotlin
 * val microsecond: Duration = "1".microseconds // PT0.000001S
 * ```
 *
 * @return 지정된 마이크로초 기간을 나타내는 [Duration] 인스턴스
 * @throws NumberFormatException 문자열이 숫자로 변환할 수 없는 경우
 * @since 0.3.0
 */
val String.microseconds: Duration
    get() = this.toLong().microseconds

/**
 * [String]을 나노초(nanosecond) 단위의 [Duration]으로 변환합니다.
 *
 * ```kotlin
 * val nanosecond: Duration = "1".nanoseconds // PT0.000000001S
 * ```
 *
 * @return 지정된 나노초 기간을 나타내는 [Duration] 인스턴스
 * @throws NumberFormatException 문자열이 숫자로 변환할 수 없는 경우
 * @since 0.3.0
 */
val String.nanoseconds: Duration
    get() = this.toLong().nanoseconds

/**
 * [String]을 [DateTimeFormatter]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val formatter: DateTimeFormatter = "yyyy-MM-dd".toDateTimeFormatter()
 * ```
 *
 * @return 변환된 [DateTimeFormatter] 인스턴스
 * @throws IllegalArgumentException 날짜 포맷이 유효하지 않은 경우
 * @since 0.7.0
 * @sample io.github.harryjhin.java.time.extension.DateTimeFormatterExtensionsTest.stringToDateTimeFormatter
 */
fun String.toDateTimeFormatter(): DateTimeFormatter {
    return when (this) {
        JavaTimeExtensionConfiguration.PATTERN_LOCAL_DATE -> JavaTimeExtensionConfiguration.FORMATTER_LOCAL_DATE
        JavaTimeExtensionConfiguration.PATTERN_LOCAL_DATE_TIME -> JavaTimeExtensionConfiguration.FORMATTER_LOCAL_DATE_TIME
        JavaTimeExtensionConfiguration.PATTERN_LOCAL_TIME -> JavaTimeExtensionConfiguration.FORMATTER_LOCAL_TIME
        JavaTimeExtensionConfiguration.PATTERN_MONTH_DAY -> JavaTimeExtensionConfiguration.FORMATTER_MONTH_DAY
        JavaTimeExtensionConfiguration.PATTERN_OFFSET_DATE_TIME -> JavaTimeExtensionConfiguration.FORMATTER_OFFSET_DATE_TIME
        JavaTimeExtensionConfiguration.PATTERN_OFFSET_TIME -> JavaTimeExtensionConfiguration.FORMATTER_OFFSET_TIME
        JavaTimeExtensionConfiguration.PATTERN_YEAR -> JavaTimeExtensionConfiguration.FORMATTER_YEAR
        JavaTimeExtensionConfiguration.PATTERN_YEAR_MONTH -> JavaTimeExtensionConfiguration.FORMATTER_YEAR_MONTH
        JavaTimeExtensionConfiguration.PATTERN_ZONED_DATE_TIME -> JavaTimeExtensionConfiguration.FORMATTER_ZONED_DATE_TIME
        else -> DateTimeFormatter.ofPattern(this)
    }
}

/**
 * [String]을 [DateTimeFormatter]로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * ```kotlin
 * val formatter: DateTimeFormatter? = "yyyy-MM-dd".toDateTimeFormatterOrNull()
 * ```
 *
 * @return 변환된 [DateTimeFormatter] 인스턴스 또는 변환 실패 시 null
 * @since 0.7.0
 * @sample io.github.harryjhin.java.time.extension.DateTimeFormatterExtensionsTest.stringToDateTimeFormatterOrNull
 */
fun String.toDateTimeFormatterOrNull(): DateTimeFormatter? {
    return try {
        toDateTimeFormatter()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 [Year]로 변환합니다. 기본 포맷 "yyyy"를 사용합니다.
 *
 * 예시:
 * ```kotlin
 * val year: Year = "2022".toYear() // 2022
 * ```
 *
 * @return 변환된 [Year] 인스턴스
 * @throws DateTimeParseException 문자열 파싱에 실패한 경우
 */
fun String.toYear(): Year {
    return toYear(JavaTimeExtensionConfiguration.FORMATTER_YEAR)
}

/**
 * [String]을 지정된 포맷의 [Year]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val year: Year = "22".toYear("yy") // 2022
 * ```
 *
 * @param pattern 년도 문자열의 포맷
 * @return 변환된 [Year] 인스턴스
 * @throws DateTimeParseException 문자열 파싱에 실패한 경우
 * @throws IllegalArgumentException 제공된 포맷이 유효하지 않은 경우
 */
fun String.toYear(
    pattern: String,
): Year {
    val formatter = pattern.toDateTimeFormatter()
    return toYear(formatter)
}

/**
 * [String]을 지정된 [DateTimeFormatter]를 사용하여 [Year]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val formatter = DateTimeFormatter.ofPattern("yy")
 * val year: Year = "22".toYear(formatter) // 2022
 * ```
 *
 * @param formatter 년도 문자열을 파싱할 [DateTimeFormatter]
 * @return 변환된 [Year] 인스턴스
 * @throws DateTimeParseException 문자열 파싱에 실패한 경우
 */
fun String.toYear(
    formatter: DateTimeFormatter,
): Year {
    return Year.parse(this, formatter)
}

/**
 * [String]을 [Year]로 변환합니다. 기본 포맷 "yyyy"를 사용합니다.
 * 변환에 실패하면 `null`을 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val validYear: Year? = "2022".toYearOrNull() // 2022
 * val invalidYear: Year? = "202X".toYearOrNull() // null
 * ```
 *
 * @return 변환된 [Year] 인스턴스 또는 변환 실패 시 null
 */
fun String.toYearOrNull(): Year? {
    return try {
        toYear()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 지정된 포맷의 [Year]로 변환합니다.
 * 변환에 실패하면 `null`을 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val validYear: Year? = "22".toYearOrNull("yy") // 2022
 * val invalidYear: Year? = "XX".toYearOrNull("yy") // null
 * ```
 *
 * @param pattern 년도 문자열의 포맷
 * @return 변환된 [Year] 인스턴스 또는 변환 실패 시 null
 */
fun String.toYearOrNull(
    pattern: String,
): Year? {
    return try {
        toYear(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 지정된 [DateTimeFormatter]를 사용하여 [Year]로 변환합니다.
 * 변환에 실패하면 `null`을 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val formatter = DateTimeFormatter.ofPattern("yy")
 * val validYear: Year? = "22".toYearOrNull(formatter) // 2022
 * val invalidYear: Year? = "XX".toYearOrNull(formatter) // null
 * ```
 *
 * @param formatter 년도 문자열을 파싱할 [DateTimeFormatter]
 * @return 변환된 [Year] 인스턴스 또는 변환 실패 시 null
 */
fun String.toYearOrNull(
    formatter: DateTimeFormatter,
): Year? {
    return try {
        toYear(formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * 주어진 월 문자열을 [String]을 [Month]로 변환합니다.
 *
 * @return 변환된 [Month] 인스턴스
 * @throws NumberFormatException 문자열이 숫자로 변환할 수 없는 경우
 * @throws DateTimeException 문자열 파싱에 실패한 경우
 * @since 0.13.8
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toMonth
 */
fun String.toMonth(): Month {
    return when (this) {
        "Jan",
        "JANUARY" -> Month.JANUARY
        "Feb",
        "FEBRUARY" -> Month.FEBRUARY
        "Mar",
        "MARCH" -> Month.MARCH
        "Apr",
        "APRIL" -> Month.APRIL
        "May",
        "MAY" -> Month.MAY
        "Jun",
        "JUNE" -> Month.JUNE
        "Jul",
        "JULY" -> Month.JULY
        "Aug",
        "AUGUST" -> Month.AUGUST
        "Sep",
        "SEPTEMBER" -> Month.SEPTEMBER
        "Oct",
        "OCTOBER" -> Month.OCTOBER
        "Nov",
        "NOVEMBER" -> Month.NOVEMBER
        "Dec",
        "DECEMBER" -> Month.DECEMBER
        else -> this.toInt().toMonth()
    }
}

/**
 * 주어진 월 문자열을 [String]을 [Month]로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * @return 변환된 [Month] 인스턴스 또는 변환 실패 시 null
 * @since 0.13.8
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toMonthOrNull
 */
fun String.toMonthOrNull(): Month? {
    return try {
        toMonth()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 [YearMonth]로 변환합니다. 기본 포맷 "yyyy-MM"을 사용합니다.
 *
 * 예시:
 * ```kotlin
 * val yearMonth: YearMonth = "2022-01".toYearMonth() // 2022-01
 * ```
 *
 * @return 변환된 [YearMonth] 인스턴스
 * @throws DateTimeParseException 문자열 파싱에 실패한 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.YearMonthTest.stringToYearMonth
 */
fun String.toYearMonth(): YearMonth {
    return toYearMonth(JavaTimeExtensionConfiguration.FORMATTER_YEAR_MONTH)
}

/**
 * [String]을 지정된 포맷의 [YearMonth]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val yearMonth: YearMonth = "2022/01".toYearMonth("yyyy/MM") // 2022-01
 * ```
 *
 * @param pattern 날짜 문자열의 포맷
 * @return 변환된 [YearMonth] 인스턴스
 * @throws DateTimeParseException 문자열 파싱에 실패한 경우
 * @throws IllegalArgumentException 제공된 포맷이 유효하지 않은 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.YearMonthTest.stringToYearMonthFormat
 */
fun String.toYearMonth(
    pattern: String,
): YearMonth {
    val formatter = pattern.toDateTimeFormatter()
    return toYearMonth(formatter)
}

/**
 * [String]을 지정된 [DateTimeFormatter]를 사용하여 [YearMonth]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val formatter = DateTimeFormatter.ofPattern("yyyy/MM")
 * val yearMonth: YearMonth = "2022/01".toYearMonth(formatter) // 2022-01
 * ```
 *
 * @param formatter 날짜 문자열을 파싱할 [DateTimeFormatter]
 * @return 변환된 [YearMonth] 인스턴스
 * @throws DateTimeParseException 문자열 파싱에 실패한 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.YearMonthTest.stringToYearMonthFormatter
 */
fun String.toYearMonth(
    formatter: DateTimeFormatter,
): YearMonth {
    return YearMonth.parse(this, formatter)
}

/**
 * [String]을 [YearMonth]로 변환합니다. 기본 포맷 "yyyy-MM"을 사용합니다.
 *
 * 변환에 실패하면 `null`을 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val validYearMonth: YearMonth? = "2022-01".toYearMonthOrNull() // 2022-01
 * val invalidYearMonth: YearMonth? = "2022-13".toYearMonthOrNull() // null
 * ```
 *
 * @return 변환된 [YearMonth] 인스턴스 또는 변환 실패 시 null
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.YearMonthTest.stringToYearMonthOrNull
 */
fun String.toYearMonthOrNull(): YearMonth? {
    return try {
        toYearMonth()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 지정된 포맷의 [YearMonth]로 변환합니다.
 *
 * 변환에 실패하면 `null`을 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val validYearMonth: YearMonth? = "2022/01".toYearMonthOrNull("yyyy/MM") // 2022-01
 * val invalidYearMonth: YearMonth? = "2022/13".toYearMonthOrNull("yyyy/MM") // null
 * ```
 *
 * @param pattern 날짜 문자열의 포맷
 * @return 변환된 [YearMonth] 인스턴스 또는 변환 실패 시 null
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.YearMonthTest.stringToYearMonthOrNullFormat
 */
fun String.toYearMonthOrNull(
    pattern: String,
): YearMonth? {
    return try {
        toYearMonth(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 지정된 [DateTimeFormatter]를 사용하여 [YearMonth]로 변환합니다.
 *
 * 변환에 실패하면 `null`을 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val formatter = DateTimeFormatter.ofPattern("yyyy/MM")
 * val validYearMonth: YearMonth? = "2022/01".toYearMonthOrNull(formatter) // 2022-01
 * val invalidYearMonth: YearMonth? = "2022/13".toYearMonthOrNull(formatter) // null
 * ```
 *
 * @param formatter 날짜 문자열을 파싱할 [DateTimeFormatter]
 * @return 변환된 [YearMonth] 인스턴스 또는 변환 실패 시 null
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.YearMonthTest.stringToYearMonthOrNullFormatter
 */
fun String.toYearMonthOrNull(
    formatter: DateTimeFormatter,
): YearMonth? {
    return try {
        toYearMonth(formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 [MonthDay]로 변환합니다. 기본 포맷 "MM-dd"를 사용합니다.
 *
 * 예시:
 * ```kotlin
 * val monthDay: MonthDay = "01-01".toMonthDay() // --01-01
 * ```
 *
 * @return 변환된 [MonthDay] 인스턴스
 * @throws DateTimeParseException 문자열 파싱에 실패한 경우
 * @since 0.8.0
 * @sample io.github.harryjhin.java.time.extension.MonthDayExtensionsTest.stringToMonthDay
 */
fun String.toMonthDay(): MonthDay {
    return toMonthDay(JavaTimeExtensionConfiguration.FORMATTER_MONTH_DAY)
}

/**
 * [String]을 지정된 포맷의 [MonthDay]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val monthDay: MonthDay = "01/01".toMonthDay("MM/dd") // --01-01
 * ```
 *
 * @param pattern 날짜 문자열의 포맷
 * @return 변환된 [MonthDay] 인스턴스
 * @throws DateTimeParseException 문자열 파싱에 실패한 경우
 * @throws IllegalArgumentException 제공된 포맷이 유효하지 않은 경우
 * @since 0.8.0
 * @sample io.github.harryjhin.java.time.extension.MonthDayExtensionsTest.stringToMonthDayWithPattern
 */
fun String.toMonthDay(
    pattern: String,
): MonthDay {
    val formatter = pattern.toDateTimeFormatter()
    return toMonthDay(formatter)
}

/**
 * [String]을 지정된 [DateTimeFormatter]를 사용하여 [MonthDay]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val formatter = DateTimeFormatter.ofPattern("MM/dd")
 * val monthDay: MonthDay = "01/01".toMonthDay(formatter) // --01-01
 * ```
 *
 * @param formatter 날짜 문자열을 파싱할 [DateTimeFormatter]
 * @return 변환된 [MonthDay] 인스턴스
 * @throws DateTimeParseException 문자열 파싱에 실패한 경우
 * @since 0.8.0
 * @sample io.github.harryjhin.java.time.extension.MonthDayExtensionsTest.stringToMonthDayWithFormatter
 */
fun String.toMonthDay(
    formatter: DateTimeFormatter,
): MonthDay {
    return MonthDay.parse(this, formatter)
}

/**
 * [String]을 [MonthDay]로 변환합니다. 기본 포맷 "MM-dd"를 사용합니다.
 *
 * 변환에 실패하면 `null`을 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val validMonthDay: MonthDay? = "01-01".toMonthDayOrNull() // --01-01
 * val invalidMonthDay: MonthDay? = "13-01".toMonthDayOrNull() // null
 * ```
 *
 * @return 변환된 [MonthDay] 인스턴스 또는 변환 실패 시 null
 * @since 0.8.0
 * @sample io.github.harryjhin.java.time.extension.MonthDayExtensionsTest.stringToMonthDayOrNull
 */
fun String.toMonthDayOrNull(): MonthDay? {
    return try {
        toMonthDay()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 지정된 포맷의 [MonthDay]로 변환합니다.
 *
 * 변환에 실패하면 `null`을 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val validMonthDay: MonthDay? = "01/01".toMonthDayOrNull("MM/dd") // --01-01
 * val invalidMonthDay: MonthDay? = "13/01".toMonthDayOrNull("MM/dd") // null
 * ```
 *
 * @param pattern 날짜 문자열의 포맷
 * @return 변환된 [MonthDay] 인스턴스 또는 변환 실패 시 null
 * @since 0.8.0
 * @sample io.github.harryjhin.java.time.extension.MonthDayExtensionsTest.stringToMonthDayOrNullWithPattern
 */
fun String.toMonthDayOrNull(
    pattern: String,
): MonthDay? {
    return try {
        toMonthDay(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 지정된 [DateTimeFormatter]를 사용하여 [MonthDay]로 변환합니다.
 *
 * 변환에 실패하면 `null`을 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val formatter = DateTimeFormatter.ofPattern("MM/dd")
 * val validMonthDay: MonthDay? = "01/01".toMonthDayOrNull(formatter) // --01-01
 * val invalidMonthDay: MonthDay? = "13/01".toMonthDayOrNull(formatter) // null
 * ```
 *
 * @param formatter 날짜 문자열을 파싱할 [DateTimeFormatter]
 * @return 변환된 [MonthDay] 인스턴스 또는 변환 실패 시 null
 * @since 0.8.0
 * @sample io.github.harryjhin.java.time.extension.MonthDayExtensionsTest.stringToMonthDayOrNullWithFormatter
 */
fun String.toMonthDayOrNull(
    formatter: DateTimeFormatter,
): MonthDay? {
    return try {
        toMonthDay(formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * 문자열을 [LocalDate]로 변환합니다. 기본 포맷 "yyyy-MM-dd"를 사용합니다.
 *
 * ```kotlin
 * val date: LocalDate = "2022-01-01".toLocalDate()
 * ```
 *
 * @return 변환된 [LocalDate] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @since 0.7.0
 */
fun String.toLocalDate(): LocalDate {
    return this.toLocalDate(JavaTimeExtensionConfiguration.FORMATTER_LOCAL_DATE)
}

/**
 * 문자열을 [LocalDate]로 변환합니다.
 *
 * ```kotlin
 * val date: LocalDate = "2022-01-01".toLocalDate()
 * ```
 *
 * @param pattern 날짜 형식
 * @return [LocalDate] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @throws IllegalArgumentException 날짜 포맷이 유효하지 않은 경우
 * @since 0.7.0
 */
fun String.toLocalDate(
    pattern: String,
): LocalDate {
    val formatter = pattern.toDateTimeFormatter()
    return toLocalDate(formatter)
}

/**
 * 문자열을 [LocalDate]로 변환합니다.
 *
 * ```kotlin
 * val date: LocalDate = "2022-01-01".toLocalDate(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
 * ```
 *
 * @param formatter [DateTimeFormatter] 인스턴스
 * @return 변환된 [LocalDate] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @since 0.7.0
 */
fun String.toLocalDate(
    formatter: DateTimeFormatter,
): LocalDate {
    return LocalDate.parse(this, formatter)
}

/**
 * 문자열을 [LocalDate]로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * ```kotlin
 * val date: LocalDate? = "2022-01-01".toLocalDateOrNull()
 * ```
 *
 * @return 변환된 [LocalDate] 인스턴스 또는 null
 * @since 0.7.0
 */
fun String.toLocalDateOrNull(): LocalDate? {
    return try {
        toLocalDate()
    } catch (e: Exception) {
        null
    }
}

/**
 * 문자열을 [LocalDate]로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * ```kotlin
 * val date: LocalDate? = "2022-01-01".toLocalDateOrNull()
 * ```
 *
 * @param pattern 날짜 형식
 * @return 변환된 [LocalDate] 인스턴스 또는 null
 * @since 0.7.0
 */
fun String.toLocalDateOrNull(
    pattern: String,
): LocalDate? {
    return try {
        toLocalDate(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * 문자열을 [LocalDate]로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * ```kotlin
 * val date: LocalDate? = "2022-01-01".toLocalDateOrNull(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
 * ```
 *
 * @param formatter [DateTimeFormatter] 인스턴스
 * @return [LocalDate] 인스턴스
 */
fun String.toLocalDateOrNull(
    formatter: DateTimeFormatter,
): LocalDate? = try {
    toLocalDate(formatter)
} catch (e: Exception) {
    null
}

/**
 * 문자열을 [LocalTime]로 변환합니다.
 *
 * ```kotlin
 * val time: LocalTime = "00:00:00".toLocalTime()
 * ```
 *
 * @return [LocalTime] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @throws IllegalArgumentException 시간 포맷이 유효하지 않은 경우
 * @since 0.2.0
 */
fun String.toLocalTime(): LocalTime {
    return toLocalTime(JavaTimeExtensionConfiguration.FORMATTER_LOCAL_TIME)
}

/**
 * 문자열을 [LocalTime]로 변환합니다.
 *
 * ```kotlin
 * val format = "HH:mm:ss"
 * val time: LocalTime = "00:00:00".toLocalTime(format)
 * ```
 *
 * @param pattern 시간 포맷 문자열
 * @return [LocalTime] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @throws IllegalArgumentException 시간 포맷이 유효하지 않은 경우
 * @since 0.2.0
 */
fun String.toLocalTime(
    pattern: String,
): LocalTime {
    val formatter = pattern.toDateTimeFormatter()
    return toLocalTime(formatter)
}

/**
 * 문자열을 [LocalTime]로 변환합니다.
 *
 * ```kotlin
 * val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
 * val time: LocalTime = "00:00:00".toLocalTime(formatter)
 * ```
 *
 * @param formatter [DateTimeFormatter] 인스턴스
 * @return [LocalTime] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @since 0.2.0
 */
fun String.toLocalTime(
    formatter: DateTimeFormatter,
): LocalTime {
    return LocalTime.parse(this, formatter)
}

/**
 * 문자열을 [LocalTime]로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * ```kotlin
 * val time: LocalTime? = "00:00:00".toLocalTimeOrNull()
 * ```
 *
 * @return [LocalTime] 인스턴스
 * @since 0.2.0
 */
fun String.toLocalTimeOrNull(): LocalTime? {
    return try {
        toLocalTime()
    } catch (e: Exception) {
        null
    }
}

/**
 * 문자열을 [LocalTime]로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * ```kotlin
 * val format = "HH:mm:ss"
 * val time: LocalTime? = "00:00:00".toLocalTimeOrNull(format)
 * ```
 *
 * @param pattern 날짜 형식 문자열
 * @return [LocalTime] 인스턴스
 * @since 0.2.0
 */
fun String.toLocalTimeOrNull(
    pattern: String,
): LocalTime? {
    return try {
        toLocalTime(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * 문자열을 [LocalTime]로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * ```kotlin
 * val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
 * val time: LocalTime? = "00:00:00".toLocalTimeOrNull(formatter)
 * ```
 *
 * @param formatter [DateTimeFormatter] 인스턴스
 * @return [LocalTime] 인스턴스
 * @since 0.2.0
 */
fun String.toLocalTimeOrNull(
    formatter: DateTimeFormatter,
): LocalTime? {
    return try {
        toLocalTime(formatter)
    } catch (e: Exception) {
        null
    }
}

//fun String.toOffsetTime(): OffsetTime {
//    return toOffsetTime(FORMATTER_OFFSET_TIME)
//}

/**
 * 주어진 일시 문자열을 [LocalDateTime]으로 파싱합니다. 기본 포맷 "yyyy-MM-dd'T'HH:mm:ss"를 사용합니다.
 *
 * @return 알시 문자열을 파싱한 [LocalDateTime] 인스턴스를 반환합니다.
 * @throws DateTimeParseException 문자열 분석에 실패한 경우 발생합니다.
 * @since 0.13.1
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateTime
 */
fun String.toLocalDateTime(): LocalDateTime {
    return toLocalDateTime(JavaTimeExtensionConfiguration.FORMATTER_LOCAL_DATE_TIME)
}

/**
 * 주어진 일시 문자열을 [pattern]을 사용하여 [LocalDateTime]으로 파싱합니다.
 *
 * @param pattern 일시 패턴 문자열
 * @return 패턴을 사용하여 일시 문자열을 파싱한 [LocalDateTime] 인스턴스를 반환합니다.
 * @throws IllegalArgumentException 패턴이 유효하지 않은 경우 발생합니다.
 * @throws DateTimeParseException 문자열 분석에 실패한 경우 발생합니다.
 * @since 0.13.1
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateTimeWithPattern
 */
fun String.toLocalDateTime(
    pattern: String,
): LocalDateTime {
    val formatter = pattern.toDateTimeFormatter()
    return toLocalDateTime(formatter)
}

/**
 * 주어진 일시 문자열을 [formatter]를 사용하여 [LocalDateTime]으로 파싱합니다.
 *
 * @param formatter 일시 포맷터
 * @return 포맷터를 사용하여 일시 문자열을 파싱한 [LocalDateTime] 인스턴스를 반환합니다.
 * @throws DateTimeParseException 문자열 분석에 실패한 경우 발생합니다.
 * @since 0.13.1
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateTimeWithDateTimeFormatter
 */
fun String.toLocalDateTime(
    formatter: DateTimeFormatter,
): LocalDateTime {
    return LocalDateTime.parse(this, formatter)
}

/**
 * 주어진 일시 문자열을 [LocalDateTime]으로 파싱합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * @return 일시 문자열을 파싱한 [LocalDateTime] 인스턴스를 반환합니다.
 * @since 0.13.1
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateTimeOrNull
 */
fun String.toLocalDateTimeOrNull(): LocalDateTime? {
    return try {
        toLocalDateTime()
    } catch (e: Exception) {
        null
    }
}

/**
 * 주어진 일시 문자열을 [pattern]을 사용하여 [LocalDateTime]으로 파싱합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * @param pattern 일시 패턴 문자열
 * @return 패턴을 사용하여 일시 문자열을 파싱한 [LocalDateTime] 인스턴스를 반환합니다.
 * @since 0.13.1
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateTimeOrNullWithPattern
 */
fun String.toLocalDateTimeOrNull(
    pattern: String,
): LocalDateTime? {
    return try {
        toLocalDateTime(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * 주어진 일시 문자열을 [formatter]를 사용하여 [LocalDateTime]으로 파싱합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * @param formatter 일시 포맷터
 * @return 포맷터를 사용하여 일시 문자열을 파싱한 [LocalDateTime] 인스턴스를 반환합니다.
 * @since 0.13.1
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateTimeOrNullWithDateTimeFormatter
 */
fun String.toLocalDateTimeOrNull(
    formatter: DateTimeFormatter,
): LocalDateTime? {
    return try {
        toLocalDateTime(formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * 문자열을 [OffsetDateTime]으로 변환합니다. 기본 포맷 "yyyy-MM-dd'T'HH:mm:ssXXX"를 사용합니다.
 *
 * @return [OffsetDateTime] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetDateTime
 */
fun String.toOffsetDateTime(): OffsetDateTime {
    return toOffsetDateTime(JavaTimeExtensionConfiguration.FORMATTER_OFFSET_DATE_TIME)
}

/**
 * 문자열을 [pattern] 형식으로 [OffsetDateTime]으로 변환합니다.
 *
 * @param pattern 날짜 형식 문자열
 * @return [OffsetDateTime] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @throws IllegalArgumentException 날짜 포맷이 유효하지 않은 경우
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetDateTimeWithPattern
 */
fun String.toOffsetDateTime(
    pattern: String,
): OffsetDateTime {
    val formatter = pattern.toDateTimeFormatter()
    return toOffsetDateTime(formatter)
}

/**
 * 문자열을 [formatter]를 사용하여 [OffsetDateTime]으로 변환합니다.
 *
 * @param formatter 날짜 포맷터
 * @return [OffsetDateTime] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetDateTimeWithDateTimeFormatter
 */
fun String.toOffsetDateTime(
    formatter: DateTimeFormatter,
): OffsetDateTime {
    return OffsetDateTime.parse(this, formatter)
}

/**
 * 문자열을 [OffsetDateTime]으로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * @return [OffsetDateTime] 인스턴스
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetDateTimeOrNull
 */
fun String.toOffsetDateTimeOrNull(): OffsetDateTime? {
    return try {
        toOffsetDateTime()
    } catch (e: Exception) {
        null
    }
}

/**
 * 문자열을 [pattern] 형식으로 [OffsetDateTime]으로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * @param pattern 날짜 형식 문자열
 * @return [OffsetDateTime] 인스턴스
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetDateTimeOrNullWithPattern
 */
fun String.toOffsetDateTimeOrNull(
    pattern: String,
): OffsetDateTime? {
    return try {
        toOffsetDateTime(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * 문자열을 [formatter]를 사용하여 [OffsetDateTime]으로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * @param formatter 날짜 포맷터
 * @return [OffsetDateTime] 인스턴스
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetDateTimeOrNullWithDateTimeFormatter
 */
fun String.toOffsetDateTimeOrNull(
    formatter: DateTimeFormatter,
): OffsetDateTime? {
    return try {
        toOffsetDateTime(formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * 주어진 문자열을 사용하여 [ZoneId] 인스턴스를 생성합니다.
 *
 * [toZoneId] 확장 함수는 [String]을 timezone ID로 해석하여 [ZoneId] 또는 [ZoneOffset]을 생성합니다.
 *
 * 파싱 과정은 다음 단계를 따릅니다:
 *
 * - 문자열이 `Z`와 같으면 [ZoneOffset.UTC]입니다.
 * - 문자열이 단일 문자로 구성되면 유효하지 않은 것으로 간주되어 [DateTimeException]이 발생합니다.
 * - 문자열이 `+` 또는 `-`로 시작하면 오프셋 ID로 간주되어 [ZoneOffset] 인스턴스를 생성합니다.
 * - 문자열이 `GMT`, `UTC` 또는 `UT`로 시작하면 동일한 ID를 가진 [ZoneId]이며 [ZoneOffset.UTC]와 동등한 규칙을 가집니다.
 * - 문자열이 `UTC+`, `UTC-`, `GMT+`, `GMT-`, `UT+` 또는 `UT-`로 시작하면 접두사가 있는 오프셋 기반 ID로 취급됩니다.
 * - 그 외의 모든 문자열은 지역 기반 시간대 ID로 파싱됩니다. 이들은 정규 표현식 `[A-Za-z][A-Za-z0-9~/._+-]+`와 일치해야 합니다.
 *
 * @return 지정된 ID를 나타내는 [ZoneId] 인스턴스
 * @throws DateTimeException 문자열의 형식이 유효하지 않은 경우
 * @throws java.time.zone.ZoneRulesException 문자열이 찾을 수 없는 지역 ID인 경우
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toZoneId
 */
fun String.toZoneId(): ZoneId {
    return ZoneId.of(this)
}

/**
 * 주어진 오프셋 ID [String]을 사용하여 [ZoneOffset] 인스턴스를 생성합니다.
 *
 * 지원되는 최대 범위는 `-18:00`에서 `+18:00`까지입니다.
 *
 * @return 지정된 오프셋을 나타내는 [ZoneOffset] 인스턴스
 * @throws DateTimeException 오프셋 ID가 유효하지 않은 경우 발생합니다.
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toZoneOffset
 */
fun String.toZoneOffset(): ZoneOffset {
    return ZoneOffset.of(this)
}
