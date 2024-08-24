package io.github.harryjhin.java.time.extension

import java.time.Duration
import java.time.Period

/**
 * [Long]을 연(Year) 단위의 [Period]로 변환합니다.
 *
 * ```kotlin
 * val year: Period = 2022L.years // P2022Y
 * ```
 *
 * @return 지정된 연 수를 나타내는 [Period] 인스턴스
 * @since 0.3.0
 */
val Long.years: Period
    get() = this.toInt().years

/**
 * [Long]을 월(month) 단위의 [Period]로 변환합니다.
 *
 * ```kotlin
 * val month: Period = 3L.months // P3M
 * ```
 *
 * @return 지정된 월 수를 나타내는 [Period] 인스턴스
 * @since 0.3.0
 */
val Long.months: Period
    get() = this.toInt().months

/**
 * [Long]을 일(day) 단위의 [Period]으로 변환합니다.
 *
 * ```kotlin
 * val day: Period = 1L.days // P1D
 * ```
 *
 * @return 지정된 일 수를 나타내는 [Period] 인스턴스
 * @since 0.3.0
 */
val Long.days: Period
    get() = this.toInt().days

/**
 * [Long]을 시간(hour) 단위의 [Duration]으로 변환합니다.
 *
 * ```kotlin
 * val hour: Duration = 1L.hours // PT1H
 * ```
 *
 * @return 지정된 시간 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 */
val Long.hours: Duration
    get() = Duration.ofHours(this)

/**
 * [Long]을 분(minute) 단위의 [Duration]으로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val minute: Duration = 1L.minutes // PT1M
 * ```
 *
 * @return 지정된 분 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 */
val Long.minutes: Duration
    get() = Duration.ofMinutes(this)

/**
 * [Long]을 초(second) 단위의 [Duration]으로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val second: Duration = 1L.seconds // PT1S
 * ```
 *
 * @return 지정된 초 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 */
val Long.seconds: Duration
    get() = Duration.ofSeconds(this)

/**
 * [Long]을 밀리초(millisecond) 단위의 [Duration]으로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val millisecond: Duration = 1L.milliseconds // PT0.001S
 * ```
 *
 * @return 지정된 밀리초 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 */
val Long.milliseconds: Duration
    get() = Duration.ofMillis(this)

/**
 * [Long]을 마이크로초(microsecond) 단위의 [Duration]으로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val microsecond: Duration = 1L.microseconds // PT0.000001S
 * ```
 *
 * @return 지정된 마이크로초 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 */
val Long.microseconds: Duration
    get() = Duration.ofNanos(this * 1000)

/**
 * [Long]을 나노초(nanosecond) 단위의 [Duration]으로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val nanosecond: Duration = 1L.nanoseconds // PT0.000000001S
 * ```
 *
 * @return 지정된 나노초 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 */
val Long.nanoseconds: Duration
    get() = Duration.ofNanos(this)