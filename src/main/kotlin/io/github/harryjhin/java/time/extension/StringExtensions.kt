package io.github.harryjhin.java.time.extension

import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime
import java.time.MonthDay
import java.time.Period
import java.time.Year
import java.time.YearMonth
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
        PATTERN_YEAR -> FORMATTER_YEAR
        PATTERN_YEAR_MONTH -> FORMATTER_YEAR_MONTH
        PATTERN_MONTH -> FORMATTER_MONTH
        PATTERN_MONTH_DAY -> FORMATTER_MONTH_DAY
        PATTERN_DATE -> FORMATTER_DATE
        PATTERN_DATE_TIME -> FORMATTER_DATE_TIME
        PATTERN_TIME -> FORMATTER_TIME
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
    return toYear(FORMATTER_YEAR)
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
    return toYearMonth(FORMATTER_YEAR_MONTH)
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
    return toMonthDay(FORMATTER_MONTH_DAY)
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
    return this.toLocalDate(FORMATTER_DATE)
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
    return toLocalTime(FORMATTER_TIME)
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
