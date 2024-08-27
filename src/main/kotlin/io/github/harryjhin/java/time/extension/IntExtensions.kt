package io.github.harryjhin.java.time.extension

import java.time.DateTimeException
import java.time.DayOfWeek
import java.time.Duration
import java.time.Month
import java.time.Period
import java.time.Year
import java.time.ZoneOffset

/**
 * [Int]를 연(Year) 단위의 [Period]로 변환합니다.
 *
 * ```kotlin
 * val year: Period = 2022.years // P2022Y
 * ```
 *
 * @return 지정된 연 수를 나타내는 [Period] 인스턴스
 * @since 0.3.0
 */
val Int.years: Period
    get() = Period.ofYears(this)

/**
 * [Int]를 월(month) 단위의 [Period]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val month: Period = 3.months // P3M
 * ```
 *
 * @return 지정된 월 수를 나타내는 [Period] 인스턴스
 * @since 0.3.0
 */
val Int.months: Period
    get() = Period.ofMonths(this)

/**
 * [Int]를 일(day) 단위의 [Period]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val day: Period = 14.days // P14D
 * ```
 *
 * @return 지정된 일 수를 나타내는 [Period] 인스턴스
 * @since 0.3.0
 */
val Int.days: Period
    get() = Period.ofDays(this)

/**
 * [Int]를 시간(hour) 단위의 [Duration]으로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val hour: Duration = 1.hours // PT1H
 * ```
 *
 * @return 지정된 시간 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 */
val Int.hours: Duration
    get() = this.toLong().hours

/**
 * [Int]를 분(minute) 단위의 [Duration]으로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val minute: Duration = 1.minutes // PT1M
 * ```
 *
 * @return 지정된 분 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 */
val Int.minutes: Duration
    get() = this.toLong().minutes

/**
 * [Int]를 초(second) 단위의 [Duration]으로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val second: Duration = 1.seconds // PT1S
 * ```
 *
 * @return 지정된 초 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 */
val Int.seconds: Duration
    get() = this.toLong().seconds

/**
 * [Int]를 밀리초(millisecond) 단위의 [Duration]으로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val millisecond: Duration = 1.milliseconds // PT0.001S
 * ```
 *
 * @return 지정된 밀리초 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 */
val Int.milliseconds: Duration
    get() = this.toLong().milliseconds

/**
 * [Int]를 마이크로초(microsecond) 단위의 [Duration]으로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val microsecond: Duration = 1.microseconds // PT0.000001S
 * ```
 *
 * @return 지정된 마이크로초 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 */
val Int.microseconds: Duration
    get() = this.toLong().microseconds

/**
 * [Int]를 나노초(nanosecond) 단위의 [Duration]으로 변환합니다.
 *
 * 예시)
 * ```kotlin
 * val nanosecond: Duration = 1.nanoseconds // PT0.000000001S
 * ```
 *
 * @return 지정된 나노초 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 */
val Int.nanoseconds: Duration
    get() = this.toLong().nanoseconds

/**
 * [Int]를 [Year]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val year: Year = 2022.toYear() // 2022
 * ```
 *
 * @return 지정된 연도를 나타내는 [Year] 인스턴스
 * @since 0.5.0
 */
fun Int.toYear(): Year {
    return Year.of(this)
}

/**
 * [Int]를 [Year]로 변환합니다.
 *
 * 변환 중에 예외가 발생하면 `null`을 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val year: Year? = 2022.toYearOrNull() // 2022
 * ```
 *
 * @return 지정된 연도를 나타내는 [Year] 인스턴스 또는 `null`
 * @since 0.5.0
 */
fun Int.toYearOrNull(): Year? {
    return try {
        this.toYear()
    } catch (e: Exception) {
        null
    }
}

/**
 * [Int]를 [Month]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val month: Month = 1.toMonth() // JANUARY
 * ```
 *
 * @return 지정된 월을 나타내는 [Month] 인스턴스
 * @since 0.5.0
 */
fun Int.toMonth(): Month {
    return Month.of(this)
}

/**
 * [Int]를 [Month]로 변환합니다.
 *
 * 변환 중에 예외가 발생하면 `null`을 반환합니다.
 *
 * 예시:
 * ```kotlin
 * val month: Month? = 13.toMonthOrNull() // null
 * ```
 *
 * @return 지정된 월을 나타내는 [Month] 인스턴스 또는 `null`
 * @since 0.5.0
 */
fun Int.toMonthOrNull(): Month? {
    return try {
        this.toMonth()
    } catch (e: Exception) {
        null
    }
}

/**
 * [Int]를 [DayOfWeek]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val dayOfWeek: DayOfWeek = 1.toDayOfWeek() // MONDAY
 * ```
 *
 * @return 지정된 요일을 나타내는 [DayOfWeek] 인스턴스
 * @since 0.5.0
 */
fun Int.toDayOfWeek(): DayOfWeek {
    return DayOfWeek.of(this)
}

/**
 * 전체 오프셋(초단위)[Int]을 사용하여 [ZoneOffset] 인스턴스를 생성합니다.
 *
 * 전체 오프셋은 `-18:00`에서 `+18:00` 범위 내에 있어야 하며, 이는 `-64800`에서 `64800` 사이의 값입니다.
 *
 * @return 지정된 오프셋을 나타내는 [ZoneOffset] 인스턴스를 반환합니다.
 * @throws DateTimeException 오프셋이 지정된 범위 내에 있지 않은 경우 발생합니다.
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.toZoneOffset
 */
fun Int.toZoneOffset(): ZoneOffset {
    return ZoneOffset.ofTotalSeconds(this)
}