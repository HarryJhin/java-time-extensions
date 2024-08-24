package io.github.harryjhin.java.time.extension

import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter

/**
 * [LocalDate] 인스턴스를 [YearMonth]로 변환합니다.
 *
 * @receiver [LocalDate] 객체
 * @return [YearMonth] 객체
 */
fun LocalDate.toYearMonth(): YearMonth = YearMonth.of(year, month)

/**
 * [LocalDate] 인스턴스를 [pattern] 형식으로 포맷팅합니다.
 *
 * 예시)
 * ```kotlin
 * val date = LocalDate.of(2022, 1, 1)
 * val formatted: String = date.toFormattedString("yyyy-MM-dd")
 * ```
 *
 * @receiver [LocalDate] 객체
 * @param pattern 날짜 형식
 * @return 날짜 문자열
 */
fun LocalDate.toFormattedString(
    pattern: String = "yyyy-MM-dd",
): String = this.format(pattern.toDateTimeFormatter())

/**
 * [LocalDate] 인스턴스를 [formatter]로 포맷팅합니다.
 *
 * 예시)
 * ```kotlin
 * val date = LocalDate.of(2022, 1, 1)
 * val formatted: String = date.toFormattedString(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
 * ```
 *
 * @receiver [LocalDate] 객체
 * @param formatter [DateTimeFormatter] 객체
 * @return 날짜 문자열
 */
fun LocalDate.toFormattedString(
    formatter: DateTimeFormatter,
): String = this.format(formatter)

/**
 * [LocalDate] 인스턴스를 [display]로 포맷팅합니다.
 *
 * 예시)
 * ```kotlin
 * val date = LocalDate.of(2022, 1, 1)
 * val formatted: String = date.toFormattedString(JavaTimeDisplay.DEFAULT)
 * ```
 *
 * @receiver [LocalDate] 객체
 * @param display [JavaTimeDisplay] 인스턴스
 * @return 날짜 문자열
 */
fun LocalDate.toFormattedString(
    display: JavaTimeDisplay,
): String = this.format(display.dateFormatter)
