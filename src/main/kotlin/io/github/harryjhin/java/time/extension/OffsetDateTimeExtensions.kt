package io.github.harryjhin.java.time.extension

import java.time.Duration
import java.time.OffsetDateTime
import java.time.Period

/**
 * [OffsetDateTime]의 연도 정보를 [Period]로 변환합니다.
 *
 * @return `year`를 [Period]로 변환한 객체
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.OffsetDateTimeExtensionsTest.years
 */
val OffsetDateTime.years: Period
    get() = Period.ofYears(year)

/**
 * [OffsetDateTime]의 월 정보를 [Period]로 변환합니다.
 *
 * @return `month`를 [Period]로 변환한 객체
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.OffsetDateTimeExtensionsTest.months
 */
val OffsetDateTime.months: Period
    get() = Period.ofMonths(monthValue)

/**
 * [OffsetDateTime]의 일 정보를 [Period]로 변환합니다.
 *
 * @return `day`를 [Period]로 변환한 객체
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.OffsetDateTimeExtensionsTest.days
 */
val OffsetDateTime.days: Period
    get() = Period.ofDays(dayOfMonth)

/**
 * [OffsetDateTime]의 시간 정보를 [Duration]으로 변환합니다.
 *
 * @return `hour`를 [Duration]으로 변환한 객체
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.OffsetDateTimeExtensionsTest.hours
 */
val OffsetDateTime.hours: Duration
    get() = Duration.ofHours(hour.toLong())

/**
 * [OffsetDateTime]의 분 정보를 [Duration]으로 변환합니다.
 *
 * @return `minute`를 [Duration]으로 변환한 객체
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.OffsetDateTimeExtensionsTest.minutes
 */
val OffsetDateTime.minutes: Duration
    get() = Duration.ofMinutes(minute.toLong())

/**
 * [OffsetDateTime]의 초 정보를 [Duration]으로 변환합니다.
 *
 * @return `second`를 [Duration]으로 변환한 객체
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.OffsetDateTimeExtensionsTest.seconds
 */
val OffsetDateTime.seconds: Duration
    get() = Duration.ofSeconds(second.toLong())

/**
 * [OffsetDateTime]의 `nano`초 정보를 밀리초 단위의 [Duration]으로 변환합니다.
 *
 * @return `nano`초를 밀리초로 변환한 객체
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.OffsetDateTimeExtensionsTest.milliseconds
 */
val OffsetDateTime.milliseconds: Duration
    get() = Duration.ofMillis(nano.toLong() / 1_000_000)

/**
 * [OffsetDateTime]의 `nano`초 정보를 마이크로초 단위의 [Duration]으로 변환합니다.
 *
 * @return `nano`초를 마이크로초로 변환한 객체
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.OffsetDateTimeExtensionsTest.microseconds
 */
val OffsetDateTime.microseconds: Duration
    get() = Duration.ofNanos(nano.toLong() / 1_000)

/**
 * [OffsetDateTime]의 `nano`초 정보를 나노초 단위의 [Duration]으로 변환합니다.
 *
 * @return `nano`초를 나노초로 변환한 객체
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.OffsetDateTimeExtensionsTest.nanoseconds
 */
val OffsetDateTime.nanoseconds: Duration
    get() = Duration.ofNanos(nano.toLong())

/**
 * [OffsetDateTime]과 [endOffsetDateTime] 사이의 시간 차이를 [Duration]으로 계산합니다.
 *
 * @param endOffsetDateTime 끝 [OffsetDateTime] 인스턴스
 * @return 두 [OffsetDateTime] 사이의 시간 차이
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.OffsetDateTimeExtensionsTest.between
 */
infix fun OffsetDateTime.between(
    endOffsetDateTime: OffsetDateTime
): Duration {
    return Duration.between(this, endOffsetDateTime)
}