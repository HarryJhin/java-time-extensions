package io.github.harryjhin.java.time.extension

import java.time.DayOfWeek
import java.time.Duration
import java.time.Month
import java.time.Period
import java.time.Year
import java.time.ZoneOffset
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class IntExtensionsTest {

    @Test
    fun years() {
        // Given

        // When
        val actual: Period = 1.years

        // Then
        assertEquals(
            expected = Period.ofYears(1),
            actual = actual,
        )
    }

    @Test
    fun months() {
        // Given

        // When
        val actual: Period = 1.months

        // Then
        assertEquals(
            expected = Period.ofMonths(1),
            actual = actual,
        )
    }

    @Test
    fun days() {
        // Given

        // When
        val actual: Period = 1.days

        // Then
        assertEquals(
            expected = Period.ofDays(1),
            actual = actual,
        )
    }

    @Test
    fun hours() {
        // Given

        // When
        val actual: Duration = 1.hours

        // Then
        assertEquals(
            expected = Duration.ofHours(1),
            actual = actual,
        )
    }

    @Test
    fun minutes() {
        // Given

        // When
        val actual: Duration = 1.minutes

        // Then
        assertEquals(
            expected = Duration.ofMinutes(1),
            actual = actual,
        )
    }

    @Test
    fun seconds() {
        // Given

        // When
        val actual: Duration = 1.seconds

        // Then
        assertEquals(
            expected = Duration.ofSeconds(1),
            actual = actual,
        )
    }

    @Test
    fun milliseconds() {
        // Given

        // When
        val actual: Duration = 1.milliseconds

        // Then
        assertEquals(
            expected = Duration.ofMillis(1),
            actual = actual,
        )
    }

    @Test
    fun microseconds() {
        // Given

        // When
        val actual: Duration = 1.microseconds

        // Then
        assertEquals(
            expected = Duration.ofNanos(1_000),
            actual = actual,
        )
    }

    @Test
    fun nanoseconds() {
        // Given

        // When
        val actual: Duration = 1.nanoseconds

        // Then
        assertEquals(
            expected = Duration.ofNanos(1),
            actual = actual,
        )
    }

    @Test
    fun toYear() {
        // Given

        // When
        val actual: Year = 2022.toYear()

        // Then
        assertEquals(
            expected = Year.of(2022),
            actual = actual,
        )
    }

    @Test
    fun toYearOrNull() {
        // Given
        val text = "${Year.MAX_VALUE + 1}"

        // When
        val exception = assertFails {
            text.toYear()
        }

        // Then
        assertEquals(
            expected = "java.time.format.DateTimeParseException: Text '$text' could not be parsed at index 0",
            actual = exception.toString()
        )

        // When
        val actual: Year? = text.toYearOrNull()

        // Then
        assertEquals(
            expected = null,
            actual = actual,
        )
    }

    @Test
    fun toMonth() {
        // Given

        // When
        val actual: Month = 1.toMonth()

        // Then
        assertEquals(
            expected = Month.JANUARY,
            actual = actual,
        )
    }

    @Test
    fun toMonthOrNull() {
        // Given

        // When
        val actual: Month? = 13.toMonthOrNull()

        // Then
        assertEquals(
            expected = null,
            actual = actual,
        )
    }

    @Test
    fun toDayOfWeek() {
        // Given

        // When
        val actual: DayOfWeek = 1.toDayOfWeek()

        // Then
        assertEquals(
            expected = DayOfWeek.MONDAY,
            actual = actual,
        )
    }

    @Test
    fun toZoneOffset() {
        // Given
        val second = 9 * 60 * 60

        // When
        val zoneOffset: ZoneOffset = second.toZoneOffset()

        // Then
        assertEquals(
            expected = ZoneOffset.ofHours(9),
            actual = zoneOffset,
        )
    }
}