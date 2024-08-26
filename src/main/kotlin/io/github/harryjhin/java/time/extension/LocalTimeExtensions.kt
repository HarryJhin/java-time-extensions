package io.github.harryjhin.java.time.extension

import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

/**
 * [LocalTime]의 시(hour) 정보를 [Duration]으로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val hours: Duration = LocalTime.of(12, 0, 30).hours // PT12H
 * ```
 *
 * @return 시(hour) 정보를 나타내는 [Duration] 인스턴스
 * @since 0.10.0
 * @sample io.github.harryjhin.java.time.extension.LocalTimeExtensionsTest.hours
 */
val LocalTime.hours: Duration
    get() = Duration.ofHours(this.hour.toLong())

/**
 * [LocalTime]의 분(minute) 정보를 [Duration]으로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val minutes: Duration = LocalTime.of(12, 30, 0).minutes // PT12M
 * ```
 *
 * @return 분(minute) 정보를 나타내는 [Duration] 인스턴스
 * @since 0.10.0
 * @sample io.github.harryjhin.java.time.extension.LocalTimeExtensionsTest.minutes
 */
val LocalTime.minutes: Duration
    get() = Duration.ofMinutes(this.minute.toLong())

/**
 * [LocalTime]의 초(second) 정보를 [Duration]으로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val seconds: Duration = LocalTime.of(12, 0, 30).seconds // PT30S
 * ```
 *
 * @return 초(second) 정보를 나타내는 [Duration] 인스턴스
 * @since 0.10.0
 * @sample io.github.harryjhin.java.time.extension.LocalTimeExtensionsTest.seconds
 */
val LocalTime.seconds: Duration
    get() = Duration.ofSeconds(this.second.toLong())

/**
 * [LocalTime]의 밀리초(millisecond) 정보를 [Duration]으로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val milliseconds: Duration = LocalTime.of(12, 0, 0, 500_000).milliseconds // PT0.5S
 * ```
 *
 * @return 밀리초(millisecond) 정보를 나타내는 [Duration] 인스턴스
 * @since 0.10.0
 * @sample io.github.harryjhin.java.time.extension.LocalTimeExtensionsTest.milliseconds
 */
val LocalTime.milliseconds: Duration
    get() = Duration.ofMillis(this.nano.toLong() / 1_000_000)

/**
 * [LocalTime]의 마이크로초(microsecond) 정보를 [Duration]으로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val microseconds: Duration = LocalTime.of(12, 0, 0, 500).microseconds // PT0.0005S
 * ```
 *
 * @return 마이크로초(microsecond) 정보를 나타내는 [Duration] 인스턴스
 * @since 0.10.0
 * @sample io.github.harryjhin.java.time.extension.LocalTimeExtensionsTest.microseconds
 */
val LocalTime.microseconds: Duration
    get() = Duration.ofNanos(this.nano.toLong() / 1_000)

/**
 * [LocalTime]의 나노초(nanosecond) 정보를 [Duration]으로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val nanoseconds: Duration = LocalTime.of(12, 0, 0, 500).nanoseconds // PT0.0000005S
 * ```
 *
 * @return 나노초(nanosecond) 정보를 나타내는 [Duration] 인스턴스
 * @since 0.10.0
 * @sample io.github.harryjhin.java.time.extension.LocalTimeExtensionsTest.nanoseconds
 */
val LocalTime.nanoseconds: Duration
    get() = Duration.ofNanos(this.nano.toLong())

/**
 * [LocalTime]의 시(hour), 분(minute), 초(second), 나노초(nanosecond) 정보를 [Duration]으로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val duration: Duration = LocalTime.of(12, 0, 30, 500).toDuration() // PT12H30M30.0000005S
 * ```
 *
 * @return 시(hour), 분(minute), 초(second), 나노초(nanosecond) 정보를 나타내는 [Duration] 인스턴스
 * @since 0.10.0
 * @sample io.github.harryjhin.java.time.extension.LocalTimeExtensionsTest.toDuration
 */
fun LocalTime.toDuration(): Duration {
    return Duration.ofHours(this.hour.toLong())
        .plusMinutes(this.minute.toLong())
        .plusSeconds(this.second.toLong())
        .plusNanos(this.nano.toLong())
}

/**
 * [LocalTime]에 [LocalDate]를 결합하여 [LocalDateTime]를 생성합니다.
 *
 * 이 함수는 중위 표기법을 사용하여 가독성 있게 [LocalDateTime]를 생성할 수 있습니다.
 *
 * 예시:
 * ```kotlin
 * val dateTime = LocalTime.of(12, 0, 30) at LocalDate.of(2022, 1, 1) // 2022-01-01T12:00:30
 * ```
 *
 * @param date 결합할 [LocalDate]
 * @return 생성된 [LocalDateTime] 인스턴스
 * @since 0.10.0
 * @sample io.github.harryjhin.java.time.extension.LocalTimeExtensionsTest.atDate
 */
infix fun LocalTime.at(date: LocalDate): LocalDateTime {
    return LocalDateTime.of(date, this)
}