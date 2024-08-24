package io.github.harryjhin.java.time.extension

import java.time.Month
import java.time.Year

/**
 * [Long]을 [Year]로 변환합니다.
 *
 * ```kotlin
 * val year: Year = 2022L.years
 * ```
 *
 * @return [Year] 인스턴스
 * @since 0.1.2
 */
val Long.years: Year
    get() = this.toInt().years

/**
 * [Long]을 [Month]로 변환합니다.
 *
 * ```kotlin
 * val month: Month = 1L.months
 * ```
 *
 * @return [Month] 인스턴스
 * @since 0.1.2
 */
val Long.months: Month
    get() = this.toInt().months

/**
 * [Long]을 [HourOfDay]로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val hour: Hour = 1L.hours
 * ```
 *
 * @return [HourOfDay] 인스턴스
 * @since 0.2.0
 */
val Long.hours: HourOfDay
    get() = HourOfDay.of(this.toInt())

/**
 * [Long]을 [MinuteOfHour]로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val minute: MinuteOfHour = 1L.minutes
 * ```
 *
 * @return [MinuteOfHour] 인스턴스
 * @since 0.2.0
 */
val Long.minutes: MinuteOfHour
    get() = this.toInt().minutes

/**
 * [Long]을 [SecondOfMinute]로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val second: SecondOfMinute = 1L.seconds
 * ```
 *
 * @return [SecondOfMinute] 인스턴스
 * @since 0.2.0
 */
val Long.seconds: SecondOfMinute
    get() = this.toInt().seconds