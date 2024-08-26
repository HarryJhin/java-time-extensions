package io.github.harryjhin.java.time.extension

import java.time.DateTimeException
import java.time.LocalDate
import java.time.MonthDay
import java.time.Period
import java.time.Year

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

/**
 * [MonthDay]에 [Year]를 결합하여 [LocalDate]를 생성합니다.
 *
 * 이 함수는 중위 표기법을 사용하여 가독성 있게 [LocalDate]를 생성할 수 있습니다.
 *
 * 예시:
 * ```kotlin
 * val date: LocalDate = MonthDay.of(1, 1) at Year.of(2022) // 2022-01-01
 * ```
 *
 * @param year 결합할 [Year]
 * @return 생성된 [LocalDate] 인스턴스
 * @throws DateTimeException 연도 값이 유효하지 않은 경우
 * @since 0.8.0
 */
infix fun MonthDay.at(year: Year): LocalDate {
    return this.atYear(year.value)
}

/**
 * [MonthDay]에 [year]를 결합하여 [LocalDate]를 생성합니다.
 *
 * 이 함수는 중위 표기법을 사용하여 가독성 있게 [LocalDate]를 생성할 수 있습니다.
 *
 * 예시:
 * ```kotlin
 * val date: LocalDate = MonthDay.of(1, 1) at 2022 // 2022-01-01
 * ```
 *
 * @param year 결합할 연도 값
 * @return 생성된 [LocalDate] 인스턴스
 * @throws DateTimeException 연도 값이 유효하지 않은 경우
 * @since 0.8.0
 */
infix fun MonthDay.at(year: Int): LocalDate {
    return this.atYear(year)
}