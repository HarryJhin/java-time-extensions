package io.github.harryjhin.java.time.extension

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Month
import java.time.MonthDay
import java.time.Period
import java.time.Year
import java.time.YearMonth

/**
 * [LocalDate] 인스턴스를 [YearMonth]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val date = LocalDate.of(2022, 1, 1)
 * val year: Period = date.years // P2022Y
 * ```
 *
 * @return year 값을 가진 [Period] 인스턴스
 * @since 0.9.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateExtensionsTest.years
 */
val LocalDate.years: Period
    get() = Period.ofYears(year)

/**
 * [LocalDate] 인스턴스를 [Period]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val date = LocalDate.of(2022, 1, 1)
 * val month: Period = date.months // P1M
 * ```
 *
 * @return monthValue 값을 가진 [Period] 인스턴스
 * @since 0.9.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateExtensionsTest.months
 */
val LocalDate.months: Period
    get() = Period.ofMonths(monthValue)

/**
 * [LocalDate] 인스턴스를 [YearMonth]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val date = LocalDate.of(2022, 1, 1)
 * val day: Period = date.days // P1D
 * ```
 *
 * @return dayOfMonth 값을 가진 [Period] 인스턴스
 * @since 0.9.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateExtensionsTest.days
 */
val LocalDate.days: Period
    get() = Period.ofDays(dayOfMonth)

/**
 * [LocalDate] 인스턴스를 [Year]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val date = LocalDate.of(2022, 1, 1)
 * val year: Year = date.toYear() // 2022
 * ```
 *
 * @return 변환된 [Year] 인스턴스
 * @since 0.9.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateExtensionsTest.toYear
 */
fun LocalDate.toYear(): Year {
    return Year.from(this)
}

/**
 * [LocalDate] 인스턴스를 [Month]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val date = LocalDate.of(2022, 1, 1)
 * val month: Month = date.toMonth() // JANUARY
 * ```
 *
 * @return 변환된 [Month] 인스턴스
 * @since 0.9.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateExtensionsTest.toMonth
 */
fun LocalDate.toMonth(): Month {
    return Month.from(this)
}

/**
 * [LocalDate] 인스턴스를 [YearMonth]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val date = LocalDate.of(2022, 1, 1)
 * val yearMonth: YearMonth = date.toYearMonth() // 2022-01
 * ```
 *
 * @return [YearMonth] 인스턴스
 * @since 0.9.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateExtensionsTest.toYearMonth
 */
fun LocalDate.toYearMonth(): YearMonth {
    return YearMonth.from(this)
}

/**
 * [LocalDate] 인스턴스를 [MonthDay]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val date = LocalDate.of(2022, 1, 1)
 * val monthDay: MonthDay = date.toMonthDay() // --01-01
 * ```
 *
 * @return [MonthDay] 인스턴스
 * @since 0.9.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateExtensionsTest.toMonthDay
 */
fun LocalDate.toMonthDay(): MonthDay {
    return MonthDay.from(this)
}

/**
 * [LocalDate]에 [LocalTime]을 결합하여 [LocalDateTime]를 생성합니다.
 *
 * 이 함수는 중위 표기법을 사용하여 가독성 있게 [LocalDateTime]를 생성할 수 있습니다.
 *
 * 예시:
 * ```kotlin
 * val dateTime = LocalDate.of(2022, 1, 1) at LocalTime.of(0, 0) // 2022-01-01T00:00
 * ```
 *
 * @param time 결합할 [LocalTime]
 * @return 생성된 [LocalDateTime] 인스턴스
 * @since 0.9.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateExtensionsTest.atLocalTime
 */
infix fun LocalDate.at(
    time: LocalTime,
): LocalDateTime {
    return this.atTime(time)
}