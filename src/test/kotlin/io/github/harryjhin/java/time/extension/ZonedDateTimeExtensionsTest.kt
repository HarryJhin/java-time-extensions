package io.github.harryjhin.java.time.extension

import java.time.Duration
import java.time.Period
import java.time.ZoneId
import java.time.ZonedDateTime
import kotlin.test.Test
import kotlin.test.assertEquals

class ZonedDateTimeExtensionsTest {

    @Test
    fun years() {
        // Given
        val zonedDateTime: ZonedDateTime = ZonedDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneId.of("Asia/Seoul"))

        // When
        val years: Period = zonedDateTime.years

        // Then
        assertEquals(
            expected = Period.ofYears(2022),
            actual = years,
        )
    }

    @Test
    fun months() {
        // Given
        val zonedDateTime: ZonedDateTime = ZonedDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneId.of("Asia/Seoul"))

        // When
        val months: Period = zonedDateTime.months

        // Then
        assertEquals(
            expected = Period.ofMonths(1),
            actual = months,
        )
    }

    @Test
    fun days() {
        // Given
        val zonedDateTime: ZonedDateTime = ZonedDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneId.of("Asia/Seoul"))

        // When
        val days: Period = zonedDateTime.days

        // Then
        assertEquals(
            expected = Period.ofDays(2),
            actual = days,
        )
    }

    @Test
    fun hours() {
        // Given
        val zonedDateTime: ZonedDateTime = ZonedDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneId.of("Asia/Seoul"))

        // When
        val hours: Duration = zonedDateTime.hours

        // Then
        assertEquals(
            expected = Duration.ofHours(3),
            actual = hours,
        )
    }

    @Test
    fun minutes() {
        // Given
        val zonedDateTime: ZonedDateTime = ZonedDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneId.of("Asia/Seoul"))

        // When
        val minutes: Duration = zonedDateTime.minutes

        // Then
        assertEquals(
            expected = Duration.ofMinutes(4),
            actual = minutes,
        )
    }

    @Test
    fun seconds() {
        // Given
        val zonedDateTime: ZonedDateTime = ZonedDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneId.of("Asia/Seoul"))

        // When
        val seconds: Duration = zonedDateTime.seconds

        // Then
        assertEquals(
            expected = Duration.ofSeconds(5),
            actual = seconds,
        )
    }

    @Test
    fun milliseconds() {
        // Given
        val zonedDateTime: ZonedDateTime = ZonedDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneId.of("Asia/Seoul"))

        // When
        val milliseconds: Duration = zonedDateTime.milliseconds

        // Then
        assertEquals(
            expected = Duration.ofMillis(123),
            actual = milliseconds,
        )
    }

    @Test
    fun microseconds() {
        // Given
        val zonedDateTime: ZonedDateTime = ZonedDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneId.of("Asia/Seoul"))

        // When
        val microseconds: Duration = zonedDateTime.microseconds

        // Then
        assertEquals(
            expected = Duration.ofNanos(123_456),
            actual = microseconds,
        )
    }

    @Test
    fun nanoseconds() {
        // Given
        val zonedDateTime: ZonedDateTime = ZonedDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneId.of("Asia/Seoul"))

        // When
        val nanoseconds: Duration = zonedDateTime.nanoseconds

        // Then
        assertEquals(
            expected = Duration.ofNanos(123_456_789),
            actual = nanoseconds,
        )
    }

    @Test
    fun between() {
        // Given
        val startZonedDateTime: ZonedDateTime =
            ZonedDateTime.of(2022, 1, 2, 3, 4, 5, 123_456_789, ZoneId.of("Asia/Seoul"))

        // When
        val duration: Duration = startZonedDateTime between ZonedDateTime.of(
            2022,
            5,
            4,
            3,
            2,
            1,
            123_456_789,
            ZoneId.of("Asia/Seoul")
        ) // PT2927H57M56S

        // Then
        assertEquals(
            expected = Duration.ofHours(2_927).plusMinutes(57).plusSeconds(56),
            actual = duration.also(::println),
        )
    }
}