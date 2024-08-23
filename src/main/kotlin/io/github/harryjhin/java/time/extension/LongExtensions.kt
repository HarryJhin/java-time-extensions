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