package io.github.harryjhin.java.time.extension

import java.time.Period
import java.time.Year
import java.time.temporal.TemporalAmount

/**
 * [Year] 인스턴스를 [Period]로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val year = Year.of(2022)
 * val amount: TemporalAmount = 1.years.amounts
 * println(year + amount) // 2023
 * ```
 *
 * @receiver [Year] 인스턴스
 * @return [TemporalAmount] 인스턴스
 */
val Year.amounts: TemporalAmount
    get() = Period.ofYears(value)