package io.github.harryjhin.java.time.extension

import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAccessor

/**
 * [TemporalAccessor]를 [pattern]에 맞게 포맷팅된 문자열로 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val date: LocalDate = LocalDate.of(2022, 1, 1)
 * val formattedDate: String = date.toString("yyyy-MM-dd") // 2022-01-01
 * ```
 *
 * @param pattern 포맷팅 패턴
 * @return 포맷팅된 문자열
 * @since 0.8.0
 */
@JvmName("toFormattedString")
fun TemporalAccessor.toString(
    pattern: String,
): String {
    val formatter = pattern.toDateTimeFormatter()
    return toString(formatter)
}

/**
 * [TemporalAccessor]를 [formatter]에 맞게 포맷팅된 문자열로 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val date: LocalDate = LocalDate.of(2022, 1, 1)
 * val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
 * val formattedDate: String = date.toString(formatter) // 2022-01-01
 * ```
 *
 * @param formatter 포맷터
 * @return 포맷팅된 문자열
 * @since 0.8.0
 */
@JvmName("toFormattedString")
fun TemporalAccessor.toString(
    formatter: DateTimeFormatter,
): String {
    return formatter.format(this)
}