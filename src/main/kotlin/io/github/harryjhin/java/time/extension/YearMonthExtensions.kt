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
 * @sample io.github.harryjhin.java.time.extension.YearMonthExtensionsTest.years
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
 * @sample io.github.harryjhin.java.time.extension.YearMonthExtensionsTest.months
 */
val YearMonth.months: Period
    get() = this.monthValue.months

/**
 * [YearMonth]에 일(day)를 결합하여 [LocalDate]를 생성합니다.
 *
 * 이 함수는 중위 표기법을 사용하여 가독성 있게 [LocalDate]를 생성할 수 있습니다.
 *
 * 예시:
 * ```kotlin
 * val date = YearMonth.of(2022, 1) at 1 // 2022-01-01
 * ```
 *
 * @param dayOfMonth 결합할 일(day)
 * @return 생성된 [LocalDate] 인스턴스
 * @since 0.6.0
 * @sample io.github.harryjhin.java.time.extension.YearMonthExtensionsTest.atDayOfMonth
 */
infix fun YearMonth.at(dayOfMonth: Int): LocalDate {
    return this.atDay(dayOfMonth)
}

/**
 * [YearMonth]와 [endYearMonth] 사이의 차이를 [Period]로 계산합니다.
 *
 * @param endYearMonth 종료 연월
 * @return 차이를 나타내는 [Period] 인스턴스
 * @since 0.11.2
 * @sample io.github.harryjhin.java.time.extension.YearMonthExtensionsTest.between
 */
infix fun YearMonth.between(
    endYearMonth: YearMonth,
): Period {
    val month = (endYearMonth.year - this.year) * 12 + (endYearMonth.monthValue - this.monthValue)
    val year = month / 12
    val monthOfYear = month % 12
    return Period.ofYears(year).plusMonths(monthOfYear.toLong())
}