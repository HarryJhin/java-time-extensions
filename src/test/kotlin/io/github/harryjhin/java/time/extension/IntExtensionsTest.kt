package io.github.harryjhin.java.time.extension

import java.time.DateTimeException
import java.time.DayOfWeek
import java.time.Duration
import java.time.Month
import java.time.Period
import java.time.Year
import java.time.ZoneOffset
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

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

        // Fail cases
        assertFailsWith(DateTimeException::class) {
            (Year.MAX_VALUE + 1).toYear()
        }
    }

    @Test
    fun toYearOrNull() {
        // Given

        // When
        val actual: Year? = 2022.toYearOrNull()

        // Then
        assertEquals(
            expected = Year.of(2022),
            actual = actual,
        )

        // Fail cases
        assertNull((Year.MAX_VALUE + 1).toYearOrNull())
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

        // Fail cases
        assertFailsWith(DateTimeException::class) {
            8.toDayOfWeek()
        }
    }

    @Test
    fun toZoneOffset() {
        // Given
        val second = 9 * 60 * 60 // 32_400

        // When
        val actual: ZoneOffset = second.toZoneOffset() // +09:00

        // Then
        assertEquals(
            expected = ZoneOffset.ofHours(9),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(DateTimeException::class) {
            (18 * 60 * 60 + 1).toZoneOffset() // 64_801
        }
    }
}