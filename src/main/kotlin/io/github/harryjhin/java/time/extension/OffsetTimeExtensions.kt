package io.github.harryjhin.java.time.extension

import java.time.Duration
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.OffsetTime

/**
 * [OffsetTime]의 시간을 나타내는 [Duration] 인스턴스를 반환합니다.
 *
 * @receiver [OffsetTime]
 * @return 시간을 나타내는 [Duration] 인스턴스
 * @since 0.14.0
 * @sample io.github.harryjhin.java.time.extension.OffsetTimeExtensionsTest.hours
 */
val OffsetTime.hours: Duration
    get() = Duration.ofHours(hour.toLong())

/**
 * [OffsetTime]의 분을 나타내는 [Duration] 인스턴스를 반환합니다.
 *
 * @receiver [OffsetTime]
 * @return 분을 나타내는 [Duration] 인스턴스
 * @since 0.14.0
 * @sample io.github.harryjhin.java.time.extension.OffsetTimeExtensionsTest.minutes
 */
val OffsetTime.minutes: Duration
    get() = Duration.ofMinutes(minute.toLong())

/**
 * [OffsetTime]의 초를 나타내는 [Duration] 인스턴스를 반환합니다.
 *
 * @receiver [OffsetTime]
 * @return 초를 나타내는 [Duration] 인스턴스
 * @since 0.14.0
 * @sample io.github.harryjhin.java.time.extension.OffsetTimeExtensionsTest.seconds
 */
val OffsetTime.seconds: Duration
    get() = Duration.ofSeconds(second.toLong())

/**
 * [OffsetTime]의 나노초를 밀리초 단위까지 나타내는 [Duration] 인스턴스를 반환합니다.
 *
 * @receiver [OffsetTime]
 * @return 나노초를 밀리초 단위까지 나타내는 [Duration] 인스턴스
 * @since 0.14.0
 * @sample io.github.harryjhin.java.time.extension.OffsetTimeExtensionsTest.milliseconds
 */
val OffsetTime.milliseconds: Duration
    get() = Duration.ofNanos(nano / 1_000_000L * 1_000_000L)

/**
 * [OffsetTime]의 나노초를 마이크로초 단위까지 나타내는 [Duration] 인스턴스를 반환합니다.
 *
 * @receiver [OffsetTime]
 * @return 나노초를 마이크로초 단위까지 나타내는 [Duration] 인스턴스
 * @since 0.14.0
 * @sample io.github.harryjhin.java.time.extension.OffsetTimeExtensionsTest.microseconds
 */
val OffsetTime.microseconds: Duration
    get() = Duration.ofNanos(nano / 1_000L * 1_000L)

/**
 * [OffsetTime]의 나노초를 나노초 단위까지 나타내는 [Duration] 인스턴스를 반환합니다.
 *
 * @receiver [OffsetTime]
 * @return 나노초를 나노초 단위까지 나타내는 [Duration] 인스턴스
 * @since 0.14.0
 * @sample io.github.harryjhin.java.time.extension.OffsetTimeExtensionsTest.nanoseconds
 */
val OffsetTime.nanoseconds: Duration
    get() = Duration.ofNanos(nano.toLong())

/**
 * [OffsetTime]을 [LocalDate]와 결합하여 [OffsetDateTime]으로 변환합니다.
 *
 * @receiver [OffsetTime]
 * @param date [LocalDate]
 * @return 결합된 [OffsetDateTime]
 * @since 0.14.0
 * @sample io.github.harryjhin.java.time.extension.OffsetTimeExtensionsTest.at
 */
infix fun OffsetTime.at(date: LocalDate): OffsetDateTime {
    return date.atTime(this)
}

/**
 * 두 [OffsetTime] 사이의 기간을 [Duration]으로 계산합니다.
 *
 * @receiver 시작 시점
 * @param endOffsetTime 끝 시점
 * @return 시작 시점부터 끝 시점까지의 기간
 * @since 0.14.0
 * @sample io.github.harryjhin.java.time.extension.OffsetTimeExtensionsTest.between
 */
infix fun OffsetTime.between(
    endOffsetTime: OffsetTime,
): Duration {
    return Duration.between(this, endOffsetTime)
}
