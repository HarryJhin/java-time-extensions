package io.github.harryjhin.java.time.extension.string

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.Locale

/**
 * 문자열을 [DateTimeFormatter]로 변환합니다.
 *
 * ```kotlin
 * val formatter: DateTimeFormatter = "yyyy-MM-dd".toDateTimeFormatter()
 * ```
 *
 * @receiver 변환할 문자열
 * @return [DateTimeFormatter] 객체
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
 * @receiver 변환할 문자열
 * @param format 날짜 형식
 * @return [LocalDate] 객체
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
 * @receiver 변환할 문자열
 * @param formatter [DateTimeFormatter] 객체
 * @return [LocalDate] 객체
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
 * @receiver 변환할 문자열
 * @param format 날짜 형식
 * @return [LocalDate] 객체
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
 * @receiver 변환할 문자열
 * @param formatter [DateTimeFormatter] 객체
 * @return [LocalDate] 객체
 */
fun String.toLocalDateOrNull(
    formatter: DateTimeFormatter,
): LocalDate? = try {
    toLocalDate(formatter)
} catch (e: Exception) {
    null
}

/**
 * 문자열을 [LocalDate]로 변환합니다.
 *
 * ```kotlin
 * val date: LocalDate = "2022-01-01".toLocalDate()
 * ```
 *
 * @receiver 변환할 문자열
 * @param format 날짜 형식
 * @return [LocalDate] 객체
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @throws IllegalArgumentException 날짜 포맷이 유효하지 않은 경우
 */
fun String.toLocalTime(
    format: String = "HH:mm:ss",
): LocalDate = LocalDate.parse(this, format.toDateTimeFormatter())

/**
 * 문자열을 [LocalDate]로 변환합니다.
 *
 * ```kotlin
 * val date: LocalDate = "2022-01-01".toLocalDate(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
 * ```
 *
 * @receiver 변환할 문자열
 * @param formatter [DateTimeFormatter] 객체
 * @return [LocalDate] 객체
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 */
fun String.toLocalTime(
    formatter: DateTimeFormatter,
): LocalDate = LocalDate.parse(this, formatter)

/**
 * 문자열을 [LocalDate]로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * ```kotlin
 * val date: LocalDate? = "2022-01-01".toLocalDateOrNull()
 * ```
 *
 * @receiver 변환할 문자열
 * @param format 날짜 형식
 * @return [LocalDate] 객체
 */
fun String.toLocalTimeOrNull(
    format: String = "HH:mm:ss",
): LocalDate? = try {
    toLocalDate(format)
} catch (e: Exception) {
    null
}
