package io.github.harryjhin.java.time.extension

import java.time.Month
import java.time.Period
import java.time.temporal.TemporalAmount

/**
 * [Month] 인스턴스를 [Period]로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val amount: TemporalAmount = 1.months.amounts
 * println(LocalDate.of(2022, 1, 1) + amount) // 2022-02-01
 * ```
 *
 * @receiver [Month] 인스턴스
 * @return [TemporalAmount] 인스턴스
 */
val Month.amounts: TemporalAmount
    get() = Period.ofMonths(value)