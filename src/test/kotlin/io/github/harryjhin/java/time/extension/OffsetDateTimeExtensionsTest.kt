package io.github.harryjhin.java.time.extension

import java.time.Duration
import java.time.OffsetDateTime
import java.time.Period
import java.time.ZoneOffset
import kotlin.test.Test
import kotlin.test.assertEquals

class OffsetDateTimeExtensionsTest {

    @Test
    fun years() {
        // Given
        val offsetDateTime: OffsetDateTime = OffsetDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneOffset.UTC)

        // When
        val years: Period = offsetDateTime.years

        // Then
        assertEquals(
            expected = Period.ofYears(2022),
            actual = years
        )
    }

    @Test
    fun months() {
        // Given
        val offsetDateTime: OffsetDateTime = OffsetDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneOffset.UTC)

        // When
        val months: Period = offsetDateTime.months

        // Then
        assertEquals(
            expected = Period.ofMonths(1),
            actual = months
        )
    }

    @Test
    fun days() {
        // Given
        val offsetDateTime: OffsetDateTime = OffsetDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneOffset.UTC)

        // When
        val days: Period = offsetDateTime.days

        // Then
        assertEquals(
            expected = Period.ofDays(2),
            actual = days
        )
    }

    @Test
    fun hours() {
        // Given
        val offsetDateTime: OffsetDateTime = OffsetDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneOffset.UTC)

        // When
        val hours: Duration = offsetDateTime.hours

        // Then
        assertEquals(
            expected = Duration.ofHours(3),
            actual = hours
        )
    }

    @Test
    fun minutes() {
        // Given
        val offsetDateTime: OffsetDateTime = OffsetDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneOffset.UTC)

        // When
        val minutes: Duration = offsetDateTime.minutes

        // Then
        assertEquals(
            expected = Duration.ofMinutes(4),
            actual = minutes
        )
    }

    @Test
    fun seconds() {
        // Given
        val offsetDateTime: OffsetDateTime = OffsetDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneOffset.UTC)

        // When
        val seconds: Duration = offsetDateTime.seconds

        // Then
        assertEquals(
            expected = Duration.ofSeconds(5),
            actual = seconds
        )
    }

    @Test
    fun milliseconds() {
        // Given
        val offsetDateTime: OffsetDateTime = OffsetDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneOffset.UTC)

        // When
        val milliseconds: Duration = offsetDateTime.milliseconds

        // Then
        assertEquals(
            expected = Duration.ofMillis(123),
            actual = milliseconds
        )
    }

    @Test
    fun microseconds() {
        // Given
        val offsetDateTime: OffsetDateTime = OffsetDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneOffset.UTC)

        // When
        val microseconds: Duration = offsetDateTime.microseconds

        // Then
        assertEquals(
            expected = Duration.ofNanos(123_456),
            actual = microseconds
        )
    }

    @Test
    fun nanoseconds() {
        // Given
        val offsetDateTime: OffsetDateTime = OffsetDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneOffset.UTC)

        // When
        val nanoseconds: Duration = offsetDateTime.nanoseconds

        // Then
        assertEquals(
            expected = Duration.ofNanos(123_456_789),
            actual = nanoseconds
        )
    }

    @Test
    fun between() {
        // Given
        val start: OffsetDateTime = OffsetDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneOffset.UTC)

        // When
        val duration: Duration = start between OffsetDateTime.of(2022, 1, 2, 3, 4, 10, 123_456_789, ZoneOffset.UTC)

        // Then
        assertEquals(
            expected = Duration.ofSeconds(5),
            actual = duration
        )

        // When
        val duration2: Duration = start between OffsetDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneOffset.ofHours(9))

        // Then
        assertEquals(
            expected = Duration.ofHours(-9),
            actual = duration2
        )
    }
}