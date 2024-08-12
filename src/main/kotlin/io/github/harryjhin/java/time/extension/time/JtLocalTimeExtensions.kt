package io.github.harryjhin.java.time.extension.time

import io.github.harryjhin.java.time.extension.string.toDateTimeFormatter
import java.time.DateTimeException
import java.time.LocalTime
import java.time.format.DateTimeFormatter

/**
 * [LocalTime] 객체를 문자열로 변환합니다.
 *
 * ```kotlin
 * val time = LocalTime.of(0, 0, 0)
 * println(time.toFormatString()) // 00:00:00
 * ```
 *
 * @receiver [LocalTime] 객체
 * @param format 시간 형식
 * @return 시간 문자열
 * @throws IllegalArgumentException 시간 포맷이 유효하지 않은 경우
 * @throws DateTimeException 시간 형식이 유효하지 않은 경우
 */
fun LocalTime.toFormattedString(
    format: String = "HH:mm:ss",
): String = this.format(format.toDateTimeFormatter())

/**
 * [LocalTime] 객체를 문자열로 변환합니다.
 *
 * ```kotlin
 * val time = LocalTime.of(0, 0, 0)
 * println(time.toFormatString(DateTimeFormatter.ofPattern("HH:mm:ss"))) // 00:00:00
 * ```
 *
 * @receiver [LocalTime] 객체
 * @param formatter [DateTimeFormatter] 객체
 * @return 시간 문자열
 * @throws DateTimeException 시간 형식이 유효하지 않은 경우
 */
fun LocalTime.toFormattedString(
    formatter: DateTimeFormatter,
): String = this.format(formatter)