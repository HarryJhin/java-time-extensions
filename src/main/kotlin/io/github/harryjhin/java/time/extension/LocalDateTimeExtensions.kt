package io.github.harryjhin.java.time.extension

import java.time.DateTimeException
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.Month
import java.time.MonthDay
import java.time.OffsetDateTime
import java.time.Period
import java.time.Year
import java.time.YearMonth
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.zone.ZoneRulesException

/**
 * [LocalDateTime]의 연도 정보를 [Year]로 변환합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val year: Period = dateTime.years
 * println(year) // P2022Y
 * ```
 *
 * @return `year`를 [Period]로 변환한 객체
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.years
 */
val LocalDateTime.years: Period
    get() = Period.ofYears(year)

/**
 * [LocalDateTime]의 월 정보를 [Month]로 변환합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val month: Period = dateTime.months
 * println(month) // P1M
 * ```
 *
 * @return `month`를 [Period]로 변환한 객체
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.months
 */
val LocalDateTime.months: Period
    get() = Period.ofMonths(monthValue)

/**
 * [LocalDateTime]의 일 정보를 [Period]로 변환합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val day: Period = dateTime.days
 * println(day) // P2D
 * ```
 *
 * @return `day`를 [Period]로 변환한 객체
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.days
 */
val LocalDateTime.days: Period
    get() = Period.ofDays(dayOfMonth)

/**
 * [LocalDateTime]의 시간 정보를 [Duration]으로 변환합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 1, 1, 1, 1)
 * val hour: Duration = dateTime.hours
 * println(hour) // PT1H
 * ```
 *
 * @return `hour`를 [Duration]으로 변환한 객체
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.hours
 */
val LocalDateTime.hours: Duration
    get() = Duration.ofHours(hour.toLong())

/**
 * [LocalDateTime]의 분 정보를 [Duration]으로 변환합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val minute: Duration = dateTime.minutes
 * println(minute) // PT4M
 * ```
 *
 * @return `minute`를 [Duration]으로 변환한 객체
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.minutes
 */
val LocalDateTime.minutes: Duration
    get() = Duration.ofMinutes(minute.toLong())

/**
 * [LocalDateTime.time]의 초 정보를 [Duration]으로 변환합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val second: Duration = dateTime.seconds
 * println(second) // PT5S
 * ```
 *
 * @return `second`를 [Duration]으로 변환한 객체
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.seconds
 */
val LocalDateTime.seconds: Duration
    get() = Duration.ofSeconds(second.toLong())

/**
 * [LocalDateTime.time]의 `nano`초를 밀리초 단위까지 [Duration]으로 변환합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val millisecond: Duration = dateTime.milliseconds
 * println(millisecond) // PT0.123S
 * ```
 *
 * @return `nano`초를 밀리초 단위로 변환한 [Duration] 객체
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.milliseconds
 */
val LocalDateTime.milliseconds: Duration
    get() = Duration.ofMillis(nano / 1_000_000L)

/**
 * [LocalDateTime.time]의 `nano`초를 마이크로초 단위까지 [Duration]으로 변환합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val microsecond: Duration = dateTime.microseconds
 * println(microsecond) // PT0.123456S
 * ```
 *
 * @return `nano`초를 마이크로초 단위로 변환한 [Duration] 객체
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.microseconds
 */
val LocalDateTime.microseconds: Duration
    get() = Duration.ofNanos(nano / 1_000L)

/**
 * [LocalDateTime.time]의 `nano`초를 [Duration]으로 변환합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val nanosecond: Duration = dateTime.nanoseconds
 * println(nanosecond) // PT0.123456789S
 * ```
 *
 * @return `nano`초를 [Duration]으로 변환한 객체
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.nanoseconds
 */
val LocalDateTime.nanoseconds: Duration
    get() = Duration.ofNanos(nano.toLong())

/**
 * [LocalDateTime]의 연도 정보를 [Year]로 변환합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val year: Year = dateTime.toYear()
 * println(year) // 2022
 * ```
 *
 * @return 변환된 [Year] 객체
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.toYear
 */
fun LocalDateTime.toYear(): Year {
    return Year.from(this)
}

/**
 * [LocalDateTime]의 월 정보를 [Month]로 변환합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val month: Month = dateTime.toMonth()
 * println(month) // JANUARY
 * ```
 *
 * @return 변환된 [Month] 객체
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.toMonth
 */
fun LocalDateTime.toMonth(): Month {
    return Month.from(this)
}

/**
 * [LocalDateTime]의 연도와 월 정보를 [YearMonth]로 변환합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val yearMonth: YearMonth = dateTime.toYearMonth()
 * println(yearMonth) // 2022-01
 * ```
 *
 * @return 변환된 [YearMonth] 객체
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.toYearMonth
 */
fun LocalDateTime.toYearMonth(): YearMonth {
    return YearMonth.from(this)
}

/**
 * [LocalDateTime]의 월과 일 정보를 [MonthDay]로 변환합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val monthDay: MonthDay = dateTime.toMonthDay()
 * println(monthDay) // --01-01
 * ```
 *
 * @return 변환된 [MonthDay] 객체
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.toMonthDay
 */
fun LocalDateTime.toMonthDay(): MonthDay {
    return MonthDay.from(this)
}

/**
 * [LocalDateTime]의 요일 정보를 [DayOfWeek]로 변환합니다.
 *
 * @return 변환된 [DayOfWeek] 객체
 * @since 0.13.2
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.toDayOfWeek
 */
fun LocalDateTime.toDayOfWeek(): DayOfWeek {
    return DayOfWeek.from(this)
}

/**
 * [LocalDateTime]과 [ZoneOffset]를 결합하여 [OffsetDateTime]를 생성합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val offset: ZoneOffset = ZoneOffset.ofHours(9)
 * val offsetDateTime: OffsetDateTime = dateTime at offset
 * println(offsetDateTime) // 2022-01-02T03:04:05.123456789+09:00
 * ```
 *
 * @param offset [ZoneOffset]
 * @return 결합된 [OffsetDateTime]
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.atOffset
 */
infix fun LocalDateTime.at(offset: ZoneOffset): OffsetDateTime {
    return this.atOffset(offset)
}

/**
 * [LocalDateTime]과 [hoursOfZoneOffset]를 결합하여 [OffsetDateTime]를 생성합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val offsetDateTime: OffsetDateTime = dateTime at 9
 * println(offsetDateTime) // 2022-01-02T03:04:05.123456789+09:00
 * ```
 *
 * @param hoursOfZoneOffset [ZoneOffset]의 시간 정보
 * @return 결합된 [OffsetDateTime]
 * @throws DateTimeException [hoursOfZoneOffset]이 유효한 시간 정보가 아닐 경우
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.atHoursOfZoneOffset
 */
infix fun LocalDateTime.at(hoursOfZoneOffset: Int): OffsetDateTime {
    return this at ZoneOffset.ofHours(hoursOfZoneOffset)
}

/**
 * [LocalDateTime]과 [ZoneId]를 결합하여 [ZonedDateTime]를 생성합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val zoneId: ZoneId = ZoneId.of("Asia/Seoul")
 * val zonedDateTime: ZonedDateTime = dateTime at zoneId
 * println(zonedDateTime) // 2022-01-02T03:04:05.123456789+09:00[Asia/Seoul]
 * ```
 *
 * @param zoneId [ZoneId]
 * @return 결합된 [ZonedDateTime]
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.atZoneId
 */
infix fun LocalDateTime.at(zoneId: ZoneId): ZonedDateTime {
    return this.atZone(zoneId)
}

/**
 * [LocalDateTime]과 [zoneId]를 결합하여 [ZonedDateTime]를 생성합니다.
 *
 * ```kotlin
 * val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
 * val zonedDateTime: ZonedDateTime = dateTime at "Asia/Seoul"
 * println(zonedDateTime) // 2022-01-02T03:04:05.123456789+09:00[Asia/Seoul]
 * ```
 *
 * @param zoneId [ZoneId]의 ID
 * @return 결합된 [ZonedDateTime]
 * @throws DateTimeException [zoneId]가 유효한 ID가 아닐 경우
 * @throws ZoneRulesException [zoneId]가 찾을 수 없는 지역 ID일 경우
 * @since 0.11.0
 * @sample io.github.harryjhin.java.time.extension.LocalDateTimeExtensionsTest.atZoneIdString
 */
infix fun LocalDateTime.at(zoneId: String): ZonedDateTime {
    return this at ZoneId.of(zoneId)
}
