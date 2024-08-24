package io.github.harryjhin.java.time.extension

import java.time.LocalDate
import java.time.Period
import java.time.YearMonth

/**
 * [YearMonth]를 연(Year) 단위의 [Period]로 변환합니다.
 *
 * ```kotlin
 * val year: Period = YearMonth.of(2022, 1).years // P2022Y
 * ```
 *
 * @return 지정된 연 수를 나타내는 [Period] 인스턴스
 * @since 0.3.0
 */
val YearMonth.years: Period
    get() = this.year.years

/**
 * [YearMonth]를 월(month) 단위의 [Period]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val month: Period = YearMonth.of(2022, 1).months // P1M
 * ```
 *
 * @return 지정된 월 수를 나타내는 [Period] 인스턴스
 * @since 0.3.0
 */
val YearMonth.months: Period
    get() = this.monthValue.months

infix fun YearMonth.at(dayOfMonth: Int): LocalDate {
    return this.atDay(dayOfMonth)
}