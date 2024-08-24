package io.github.harryjhin.java.time.extension

import java.time.MonthDay
import java.time.Period

/**
 * [MonthDay]를 월(month) 단위의 [Period]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val month: Period = MonthDay.of(1, 1).months // P1M
 * ```
 *
 * @return 지정된 월 수를 나타내는 [Period] 인스턴스
 * @since 0.3.0
 */
val MonthDay.months: Period
    get() = this.monthValue.months

/**
 * [MonthDay]를 일(day) 단위의 [Period]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val day: Period = MonthDay.of(1, 1).days // P1D
 * ```
 *
 * @return 지정된 일 수를 나타내는 [Period] 인스턴스
 * @since 0.3.0
 */
val MonthDay.days: Period
    get() = this.dayOfMonth.days