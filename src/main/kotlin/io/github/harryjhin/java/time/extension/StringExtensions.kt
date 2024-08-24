package io.github.harryjhin.java.time.extension

import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime
import java.time.Period
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.Locale

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
 * 문자열을 [DateTimeFormatter]로 변환합니다.
 *
 * ```kotlin
 * val formatter: DateTimeFormatter = "yyyy-MM-dd".toDateTimeFormatter()
 * ```
 *
 * @return [DateTimeFormatter] 인스턴스
 * @throws IllegalArgumentException 날짜 포맷이 유효하지 않은 경우
 */
fun String.toDateTimeFormatter(
    locale: Locale = Locale.getDefault(),
): DateTimeFormatter = DateTimeFormatter.ofPattern(this, locale)

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
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toYearMonth
 */
fun String.toYearMonth(): YearMonth {
    return toYearMonth(formatter = FORMATTER_YEAR_MONTH)
}

/**
 * [String]을 지정된 포맷의 [YearMonth]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val yearMonth: YearMonth = "2022/01".toYearMonth("yyyy/MM") // 2022-01
 * ```
 *
 * @param format 날짜 문자열의 포맷
 * @return 변환된 [YearMonth] 인스턴스
 * @throws DateTimeParseException 문자열 파싱에 실패한 경우
 * @throws IllegalArgumentException 제공된 포맷이 유효하지 않은 경우
 * @since 0.3.0
 */
fun String.toYearMonth(
    format: String,
): YearMonth {
    if (format == PATTERN_YEAR_MONTH) {
        return toYearMonth()
    }
    return toYearMonth(formatter = format.toDateTimeFormatter())
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
 */
fun String.toYearMonth(
    formatter: DateTimeFormatter,
): YearMonth {
    return YearMonth.parse(this, formatter)
}

/**
 * [String]을 [YearMonth]로 변환합니다. 기본 포맷 "yyyy-MM"을 사용합니다.
 * 변환에 실패하면 null을 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val validYearMonth: YearMonth? = "2022-01".toYearMonthOrNull() // 2022-01
 * val invalidYearMonth: YearMonth? = "2022-13".toYearMonthOrNull() // null
 * ```
 *
 * @return 변환된 [YearMonth] 인스턴스 또는 변환 실패 시 null
 * @since 0.3.0
 */
fun String.toYearMonthOrNull(): YearMonth? {
    return toYearMonthOrNull(formatter = FORMATTER_YEAR_MONTH)
}

/**
 * [String]을 지정된 포맷의 [YearMonth]로 변환합니다.
 * 변환에 실패하면 null을 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val validYearMonth: YearMonth? = "2022/01".toYearMonthOrNull("yyyy/MM") // 2022-01
 * val invalidYearMonth: YearMonth? = "2022/13".toYearMonthOrNull("yyyy/MM") // null
 * ```
 *
 * @param format 날짜 문자열의 포맷
 * @return 변환된 [YearMonth] 인스턴스 또는 변환 실패 시 null
 * @since 0.3.0
 */
fun String.toYearMonthOrNull(
    format: String,
): YearMonth? {
    return toYearMonthOrNull(formatter = format.toDateTimeFormatter())
}

/**
 * [String]을 지정된 [DateTimeFormatter]를 사용하여 [YearMonth]로 변환합니다.
 * 변환에 실패하면 null을 반환합니다.
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
 */
fun String.toYearMonthOrNull(
    formatter: DateTimeFormatter,
): YearMonth? {
    return try {
        toYearMonth(formatter = formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * 문자열을 [LocalDate]로 변환합니다.
 *
 * ```kotlin
 * val date: LocalDate = "2022-01-01".toLocalDate()
 * ```
 *
 * @param format 날짜 형식
 * @return [LocalDate] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @throws IllegalArgumentException 날짜 포맷이 유효하지 않은 경우
 */
fun String.toLocalDate(
    format: String = "yyyy-MM-dd",
): LocalDate = LocalDate.parse(this, format.toDateTimeFormatter())

/**
 * 문자열을 [LocalDate]로 변환합니다.
 *
 * ```kotlin
 * val date: LocalDate = "2022-01-01".toLocalDate(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
 * ```
 *
 * @param formatter [DateTimeFormatter] 인스턴스
 * @return [LocalDate] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 */
fun String.toLocalDate(
    formatter: DateTimeFormatter,
): LocalDate = LocalDate.parse(this, formatter)

/**
 * 문자열을 [LocalDate]로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * ```kotlin
 * val date: LocalDate? = "2022-01-01".toLocalDateOrNull()
 * ```
 *
 * @param format 날짜 형식
 * @return [LocalDate] 인스턴스
 */
fun String.toLocalDateOrNull(
    format: String = "yyyy-MM-dd",
): LocalDate? = try {
    toLocalDate(format)
} catch (e: Exception) {
    null
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
    return toLocalTime(formatter = DateTimeFormatter.ISO_LOCAL_TIME)
}

/**
 * 문자열을 [LocalTime]로 변환합니다.
 *
 * ```kotlin
 * val format = "HH:mm:ss"
 * val time: LocalTime = "00:00:00".toLocalTime(format)
 * ```
 *
 * @param format 시간 포맷 문자열
 * @return [LocalTime] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @throws IllegalArgumentException 시간 포맷이 유효하지 않은 경우
 * @since 0.2.0
 */
fun String.toLocalTime(
    format: String,
): LocalTime {
    return toLocalTime(formatter = format.toDateTimeFormatter())
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
    return toLocalTimeOrNull(formatter = DateTimeFormatter.ISO_LOCAL_TIME)
}

/**
 * 문자열을 [LocalTime]로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * ```kotlin
 * val format = "HH:mm:ss"
 * val time: LocalTime? = "00:00:00".toLocalTimeOrNull(format)
 * ```
 *
 * @param format 날짜 형식 문자열
 * @return [LocalTime] 인스턴스
 * @since 0.2.0
 */
fun String.toLocalTimeOrNull(
    format: String,
): LocalTime? {
    return toLocalTimeOrNull(formatter = format.toDateTimeFormatter())
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
