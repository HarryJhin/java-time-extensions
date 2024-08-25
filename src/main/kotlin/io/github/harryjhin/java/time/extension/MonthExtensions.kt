package io.github.harryjhin.java.time.extension

import java.time.Month
import java.time.MonthDay
import java.time.Period
import java.time.Year
import java.time.YearMonth

/**
 * [Month]를 월(month) 단위의 [Period]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val month: Period = Month.JANUARY.months // P1M
 * ```
 *
 * @return 지정된 월 수를 나타내는 [Period] 인스턴스
 * @since 0.3.0
 */
val Month.months: Period
    get() = this.value.months

/**
 * [Month]에 [dayOfMonth]를 결합하여 [MonthDay]를 생성합니다.
 *
 * 이 함수는 중위 표기법을 사용하여 가독성 있게 [MonthDay]를 생성할 수 있습니다.
 *
 * 예시:
 * ```kotlin
 * val monthDay = Month.JANUARY at 1 // --01-01
 * ```
 *
 * @param dayOfMonth 결합할 일(day) 값
 * @return 생성된 [MonthDay] 인스턴스
 * @since 0.5.0
 * @sample io.github.harryjhin.java.time.extension.MonthExtensionsTest.atDayOfMonth
 */
infix fun Month.at(dayOfMonth: Int): MonthDay {
    return MonthDay.of(this, dayOfMonth)
}

/**
 * [Month]에 [Year]를 결합하여 [YearMonth]를 생성합니다.
 *
 * 이 함수는 중위 표기법을 사용하여 가독성 있게 [YearMonth]를 생성할 수 있습니다.
 *
 * 예시:
 * ```kotlin
 * val yearMonth = Month.JANUARY at Year.of(2022) // 2022-01
 * ```
 *
 * @param year 결합할 [Year]
 * @return 생성된 [YearMonth] 인스턴스
 * @since 0.5.0
 * @sample io.github.harryjhin.java.time.extension.MonthExtensionsTest.atYear
 */
infix fun Month.at(year: Year): YearMonth {
    return year at this
}