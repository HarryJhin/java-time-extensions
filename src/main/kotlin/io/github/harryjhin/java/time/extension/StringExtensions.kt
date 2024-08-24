package io.github.harryjhin.java.time.extension

import java.time.LocalDate
import java.time.LocalTime
import java.time.Month
import java.time.Year
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.Locale

/**
 * [String]을 [Year]로 변환합니다.
 *
 * ```kotlin
 * val year: Year = "2022".years
 * ```
 *
 * @return [Year] 인스턴스
 * @since 0.1.2
 */
val String.years: Year
    get() = this.toInt().years

/**
 * [String]을 [Month]로 변환합니다.
 *
 * ```kotlin
 * val month: Month = "1".months
 * ```
 *
 * @return [Month] 인스턴스
 * @since 0.1.2
 */
val String.months: Month
    get() = this.toInt().months

/**
 * [String]을 [HourOfDay]로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val hour: Hour = "1".hours
 * ```
 *
 * @return [HourOfDay] 인스턴스
 * @since 0.2.0
 */
val String.hours: HourOfDay
    get() = HourOfDay.of(this.toInt())

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
