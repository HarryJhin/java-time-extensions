package io.github.harryjhin.java.time.extension

import java.time.Period
import java.time.YearMonth
import java.time.temporal.TemporalAmount

/**
 * [YearMonth] 인스턴스를 [Period]로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val amount: TemporalAmount = YearMonth.of(1, 1).amounts
 * println(YearMonth.of(2022, 1) + amount) // 2023-02
 * ```
 *
 * @receiver [YearMonth] 인스턴스
 * @return [TemporalAmount] 인스턴스
 */
val YearMonth.amounts: TemporalAmount
    get() = Period.ofYears(year).plusMonths(monthValue.toLong())