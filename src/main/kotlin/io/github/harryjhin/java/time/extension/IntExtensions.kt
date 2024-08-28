package io.github.harryjhin.java.time.extension

import java.time.DateTimeException
import java.time.DayOfWeek
import java.time.Duration
import java.time.Month
import java.time.Period
import java.time.Year
import java.time.ZoneOffset
import java.time.format.DateTimeParseException

/**
 * [Int]를 연도로 해석하고 [Period]로 변환합니다.
 *
 * @return 지정된 연 기간을 나타내는 [Period] 인스턴스
 * @throws DateTimeParseException 지정된 연도가 유효하지 않은 경우 발생합니다.
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.years
 */
val Int.years: Period
    get() = Period.ofYears(this)

/**
 * [Int]를 월로 해석하고 [Period]로 변환합니다.
 *
 * @return 지정된 월 기간을 나타내는 [Period] 인스턴스
 * @throws DateTimeParseException 지정된 월이 유효하지 않은 경우 발생합니다.
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.months
 */
val Int.months: Period
    get() = Period.ofMonths(this)

/**
 * [Int]를 일로 해석하고 [Period]로 변환합니다.
 *
 * @return 지정된 일 수를 나타내는 [Period] 인스턴스
 * @throws DateTimeParseException 지정된 일이 유효하지 않은 경우 발생합니다.
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.days
 */
val Int.days: Period
    get() = Period.ofDays(this)

/**
 * [Int]를 시로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 시 기간을 나타내는 [Duration] 인스턴스
 * @throws DateTimeParseException 지정된 시가 유효하지 않은 경우 발생합니다.
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.hours
 */
val Int.hours: Duration
    get() = this.toLong().hours

/**
 * [Int]를 분으로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 분 기간을 나타내는 [Duration] 인스턴스
 * @throws DateTimeParseException 지정된 분이 유효하지 않은 경우 발생합니다.
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.minutes
 */
val Int.minutes: Duration
    get() = this.toLong().minutes

/**
 * [Int]를 초로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 초 기간을 나타내는 [Duration] 인스턴스
 * @throws DateTimeParseException 지정된 초가 유효하지 않은 경우 발생합니다.
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.seconds
 */
val Int.seconds: Duration
    get() = this.toLong().seconds

/**
 * [Int]를 밀리초로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 밀리초 기간을 나타내는 [Duration] 인스턴스
 * @throws DateTimeParseException 지정된 밀리초가 유효하지 않은 경우 발생합니다.
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.milliseconds
 */
val Int.milliseconds: Duration
    get() = this.toLong().milliseconds

/**
 * [Int]를 마이크로초로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 마이크로초 기간을 나타내는 [Duration] 인스턴스
 * @throws DateTimeParseException 지정된 마이크로초가 유효하지 않은 경우 발생합니다.
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.microseconds
 */
val Int.microseconds: Duration
    get() = this.toLong().microseconds

/**
 * [Int]를 나노초로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 나노초 기간을 나타내는 [Duration] 인스턴스
 * @throws DateTimeParseException 지정된 나노초가 유효하지 않은 경우 발생합니다.
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.nanoseconds
 */
val Int.nanoseconds: Duration
    get() = this.toLong().nanoseconds

/**
 * [Int]를 [Year]로 변환합니다.
 *
 * @return 지정된 연도를 나타내는 [Year] 인스턴스
 * @since 0.5.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.toYear
 */
fun Int.toYear(): Year {
    return Year.of(this)
}

/**
 * [Int]를 [Year]로 변환합니다.
 *
 * 변환 중에 예외가 발생하면 `null`을 반환합니다.
 *
 * @return 지정된 연도를 나타내는 [Year] 인스턴스 또는 `null`
 * @since 0.5.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.toYearOrNull
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
 * @return 지정된 월을 나타내는 [Month] 인스턴스
 * @since 0.5.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.toMonth
 */
fun Int.toMonth(): Month {
    return Month.of(this)
}

/**
 * [Int]를 [Month]로 변환합니다.
 *
 * 변환 중에 예외가 발생하면 `null`을 반환합니다.
 *
 * @return 지정된 월을 나타내는 [Month] 인스턴스 또는 `null`
 * @since 0.5.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.toMonthOrNull
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
 * @return 지정된 요일을 나타내는 [DayOfWeek] 인스턴스
 * @throws DateTimeException 지정된 요일이 존재하지 않는 경우 발생합니다.
 * @since 0.5.0
 * @sample io.github.harryjhin.java.time.extension.IntExtensionsTest.toDayOfWeek
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