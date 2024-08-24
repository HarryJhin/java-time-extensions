package io.github.harryjhin.java.time.extension

import java.time.DateTimeException
import java.time.LocalDate
import java.time.Month
import java.time.MonthDay
import java.time.Period
import java.time.Year
import java.time.YearMonth

/**
 * [Year]를 연(Year) 단위의 [Period]로 변환합니다.
 *
 * ```kotlin
 * val year: Period = Year.of(2022).years // P2022Y
 * ```
 *
 * @return 지정된 연 수를 나타내는 [Period] 인스턴스
 * @since 0.3.0
 */
val Year.years: Period
    get() = this.value.years

/**
 * [Year]에 [Month]를 결합하여 [YearMonth]를 생성합니다.
 *
 * 이 함수는 중위 표기법을 사용하여 가독성 있게 [YearMonth]를 생성할 수 있습니다.
 *
 * 예시:
 * ```kotlin
 * val yearMonth = Year.of(2022) at Month.JANUARY // 2022-01
 * ```
 *
 * @param month 결합할 [Month]
 * @return 생성된 [YearMonth] 인스턴스
 * @since 0.4.0
 * @sample io.github.harryjhin.java.time.extension.YearExtensionsTest.at
 */
infix fun Year.at(month: Month): YearMonth {
    return this.atMonth(month)
}

/**
 * [Year]에 [MonthDay]를 결합하여 [LocalDate]를 생성합니다.
 *
 * 이 함수는 중위 표기법을 사용하여 가독성 있게 [LocalDate]를 생성할 수 있습니다.
 *
 * 예시:
 * ```kotlin
 * val date = Year.of(2022) at MonthDay.of(1, 1) // 2022-01-01
 * ```
 *
 * @param monthDay 결합할 [MonthDay]
 * @return 생성된 [LocalDate] 인스턴스
 * @since 0.4.0
 * @sample io.github.harryjhin.java.time.extension.YearExtensionsTest.at
 */
infix fun Year.at(monthDay: MonthDay): LocalDate {
    return this.atMonthDay(monthDay)
}

/**
 * [Year]에 연중 일(day of year)을 결합하여 [LocalDate]를 생성합니다.
 *
 * 이 함수는 중위 표기법을 사용하여 가독성 있게 [LocalDate]를 생성할 수 있습니다.
 * 연중 일은 1부터 시작하며, 윤년의 경우 366까지 가능합니다.
 *
 * 예시:
 * ```kotlin
 * val date = Year.of(2022) at 1 // 2022-01-01
 * ```
 *
 * @param dayOfYear 연중 일 (1-365, 윤년의 경우 1-366)
 * @return 생성된 [LocalDate] 인스턴스
 * @throws DateTimeException 유효하지 않은 연중 일이 제공된 경우
 * @since 0.4.0
 * @sample io.github.harryjhin.java.time.extension.YearExtensionsTest.at
 */
infix fun Year.at(dayOfYear: Int): LocalDate {
    return this.atDay(dayOfYear)
}