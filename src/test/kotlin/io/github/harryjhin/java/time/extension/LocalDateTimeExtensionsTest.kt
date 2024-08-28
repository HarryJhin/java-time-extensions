package io.github.harryjhin.java.time.extension

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
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalDateTimeExtensionsTest {

    @Test
    fun plus() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        var actual: LocalDateTime = dateTime + 1.years // 2023-01-02T03:04:05.123456789

        // Then
        assertEquals(
            expected = LocalDateTime.of(2023, 1, 2, 3, 4, 5, 123_456_789),
            actual = actual,
        )

        // When
        actual += 1.months // 2023-02-02T03:04:05.123456789

        // Then
        assertEquals(
            expected = LocalDateTime.of(2023, 2, 2, 3, 4, 5, 123_456_789),
            actual = actual,
        )

        // When
        actual += 1.days // 2023-02-03T03:04:05.123456789

        // Then
        assertEquals(
            expected = LocalDateTime.of(2023, 2, 3, 3, 4, 5, 123_456_789),
            actual = actual,
        )

        // When
        actual += 1.hours // 2023-02-03T04:04:05.123456789

        // Then
        assertEquals(
            expected = LocalDateTime.of(2023, 2, 3, 4, 4, 5, 123_456_789),
            actual = actual,
        )

        // When
        actual += 1.minutes // 2023-02-03T04:05:05.123456789

        // Then
        assertEquals(
            expected = LocalDateTime.of(2023, 2, 3, 4, 5, 5, 123_456_789),
            actual = actual,
        )

        // When
        actual += 1.seconds // 2023-02-03T04:05:06.123456789

        // Then
        assertEquals(
            expected = LocalDateTime.of(2023, 2, 3, 4, 5, 6, 123_456_789),
            actual = actual,
        )
    }

    @Test
    fun minus() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        var actual: LocalDateTime = dateTime - 1.years // 2021-01-02T03:04:05.123456789

        // Then
        assertEquals(
            expected = LocalDateTime.of(2021, 1, 2, 3, 4, 5, 123_456_789),
            actual = actual,
        )

        // When
        actual -= 1.months // 2020-12-02T03:04:05.123456789

        // Then
        assertEquals(
            expected = LocalDateTime.of(2020, 12, 2, 3, 4, 5, 123_456_789),
            actual = actual,
        )

        // When
        actual -= 1.days // 2020-12-01T03:04:05.123456789

        // Then
        assertEquals(
            expected = LocalDateTime.of(2020, 12, 1, 3, 4, 5, 123_456_789),
            actual = actual,
        )

        // When
        actual -= 1.hours // 2020-12-01T02:04:05.123456789

        // Then
        assertEquals(
            expected = LocalDateTime.of(2020, 12, 1, 2, 4, 5, 123_456_789),
            actual = actual,
        )

        // When
        actual -= 1.minutes // 2020-12-01T02:03:05.123456789

        // Then
        assertEquals(
            expected = LocalDateTime.of(2020, 12, 1, 2, 3, 5, 123_456_789),
            actual = actual,
        )

        // When
        actual -= 1.seconds // 2020-12-01T02:03:04.123456789

        // Then
        assertEquals(
            expected = LocalDateTime.of(2020, 12, 1, 2, 3, 4, 123_456_789),
            actual = actual,
        )
    }

    @Test
    fun years() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        val year: Period = dateTime.years // P2022Y

        // Then
        assertEquals(
            expected = Period.ofYears(2022),
            actual = year,
        )
    }

    @Test
    fun months() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        val month: Period = dateTime.months // P1M

        // Then
        assertEquals(
            expected = Period.ofMonths(1),
            actual = month,
        )
    }

    @Test
    fun days() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        val day: Period = dateTime.days // P2D

        // Then
        assertEquals(
            expected = Period.ofDays(2),
            actual = day,
        )
    }

    @Test
    fun hours() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        val hour: Duration = dateTime.hours // PT3H

        // Then
        assertEquals(
            expected = Duration.ofHours(3),
            actual = hour,
        )
    }

    @Test
    fun minutes() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        val minute: Duration = dateTime.minutes // PT4M

        // Then
        assertEquals(
            expected = Duration.ofMinutes(4),
            actual = minute,
        )
    }

    @Test
    fun seconds() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        val second: Duration = dateTime.seconds // PT5S

        // Then
        assertEquals(
            expected = Duration.ofSeconds(5),
            actual = second,
        )
    }

    @Test
    fun milliseconds() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        val millisecond: Duration = dateTime.milliseconds // PT0.123S

        // Then
        assertEquals(
            expected = Duration.ofMillis(123),
            actual = millisecond,
        )
    }

    @Test
    fun microseconds() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        val microsecond: Duration = dateTime.microseconds // PT0.000123456S

        // Then
        assertEquals(
            expected = Duration.ofNanos(123_456),
            actual = microsecond,
        )
    }

    @Test
    fun nanoseconds() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        val nanosecond: Duration = dateTime.nanoseconds // PT0.123456789S

        // Then
        assertEquals(
            expected = Duration.ofNanos(123_456_789),
            actual = nanosecond,
        )
    }

    @Test
    fun toYear() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        val year = dateTime.toYear() // 2022

        // Then
        assertEquals(
            expected = Year.of(2022),
            actual = year,
        )
    }

    @Test
    fun toMonth() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        val month: Month = dateTime.toMonth() // JANUARY

        // Then
        assertEquals(
            expected = Month.JANUARY,
            actual = month,
        )
    }

    @Test
    fun toYearMonth() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        val yearMonth = dateTime.toYearMonth() // 2022-01

        // Then
        assertEquals(
            expected = YearMonth.of(2022, 1),
            actual = yearMonth,
        )
    }

    @Test
    fun toMonthDay() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        val monthDay = dateTime.toMonthDay() // --01-02

        // Then
        assertEquals(
            expected = MonthDay.of(1, 2),
            actual = monthDay,
        )
    }

    @Test
    fun toDayOfWeek() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)

        // When
        val dayOfWeek = dateTime.toDayOfWeek() // SUNDAY

        // Then
        assertEquals(
            expected = DayOfWeek.SUNDAY,
            actual = dayOfWeek,
        )
    }

    @Test
    fun atOffset() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
        val offset: ZoneOffset = ZoneOffset.ofHours(9)

        // When
        val offsetDateTime = (dateTime at (offset)) // 2022-01-02T03:04:05.123456789+09:00

        // Then
        assertEquals(
            expected = OffsetDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, offset),
            actual = offsetDateTime,
        )
    }

    @Test
    fun atHoursOfZoneOffset() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
        val hoursOfZoneOffset = 9

        // When
        val offsetDateTime = (dateTime at hoursOfZoneOffset) // 2022-01-02T03:04:05.123456789+09:00

        // Then
        assertEquals(
            expected = OffsetDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneOffset.ofHours(hoursOfZoneOffset)),
            actual = offsetDateTime,
        )
    }

    @Test
    fun atZoneId() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
        val zoneId = ZoneId.of("Asia/Seoul")

        // When
        val zonedDateTime = (dateTime at zoneId) // 2022-01-02T03:04:05.123456789+09:00[Asia/Seoul]

        // Then
        assertEquals(
            expected = ZonedDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, zoneId),
            actual = zonedDateTime,
        )
    }

    @Test
    fun atZoneIdString() {
        // Given
        val dateTime: LocalDateTime = LocalDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789)
        val zoneId = "Asia/Seoul"

        // When
        val zonedDateTime = (dateTime at zoneId) // 2022-01-02T03:04:05.123456789+09:00[Asia/Seoul]

        // Then
        assertEquals(
            expected = ZonedDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneId.of(zoneId)),
            actual = zonedDateTime,
        )
    }
}