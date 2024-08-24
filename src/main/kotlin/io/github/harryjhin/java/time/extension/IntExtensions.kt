package io.github.harryjhin.java.time.extension

import java.time.Month
import java.time.Year

/**
 * [Int]를 [Year]로 변환합니다.
 *
 * ```kotlin
 * val year: Year = 2022.years
 * ```
 *
 * @return [Year] 인스턴스
 * @since 0.1.0
 */
val Int.years: Year
    get() = Year.of(this)

/**
 * [Int]를 [Month]로 변환합니다.
 *
 * ```kotlin
 * val month: Month = 1.months
 * ```
 *
 * @return [Month] 인스턴스
 * @since 0.1.0
 */
val Int.months: Month
    get() = Month.of(this)

/**
 * [Int]를 [HourOfDay]로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val hour: Hour = 1.hours
 * ```
 *
 * @return [HourOfDay] 인스턴스
 * @since 0.2.0
 */
val Int.hours: HourOfDay
    get() = HourOfDay.of(this)
