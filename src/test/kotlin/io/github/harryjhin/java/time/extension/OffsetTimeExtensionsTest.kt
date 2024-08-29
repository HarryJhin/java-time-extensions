package io.github.harryjhin.java.time.extension

import java.time.Duration
import java.time.OffsetDateTime
import java.time.OffsetTime
import java.time.ZoneOffset
import kotlin.test.Test
import kotlin.test.assertEquals

class OffsetTimeExtensionsTest {

    @Test
    fun hours() {
        // Given
        val offsetTime: OffsetTime = "12:00:00+09:00".toOffsetTime()

        // When
        val hours: Duration = offsetTime.hours // PT12H

        // Then
        assertEquals(
            expected = Duration.ofHours(12),
            actual = hours,
        )
    }

    @Test
    fun minutes() {
        // Given
        val offsetTime: OffsetTime = "12:30:00+09:00".toOffsetTime()

        // When
        val minutes: Duration = offsetTime.minutes // PT30M

        // Then
        assertEquals(
            expected = Duration.ofMinutes(30),
            actual = minutes,
        )
    }

    @Test
    fun seconds() {
        // Given
        val offsetTime: OffsetTime = "12:30:30+09:00".toOffsetTime()

        // When
        val seconds: Duration = offsetTime.seconds // PT30S

        // Then
        assertEquals(
            expected = Duration.ofSeconds(30),
            actual = seconds,
        )
    }

    @Test
    fun milliseconds() {
        // Given
        val offsetTime: OffsetTime = "12:30:30.123+09:00".toOffsetTime("HH:mm:ss.SSSXXX")

        // When
        val milliseconds: Duration = offsetTime.milliseconds // PT0.123S

        // Then
        assertEquals(
            expected = Duration.ofNanos(123_000_000),
            actual = milliseconds,
        )
    }

    @Test
    fun microseconds() {
        // Given
        val offsetTime: OffsetTime = "12:30:30.123456+09:00".toOffsetTime("HH:mm:ss.SSSSSSXXX")

        // When
        val microsecond: Duration = offsetTime.microseconds // PT0.123456S

        // Then
        assertEquals(
            expected = Duration.ofNanos(123_456_000),
            actual = microsecond,
        )
    }

    @Test
    fun nanoseconds() {
        // Given
        val offsetTime: OffsetTime = "12:30:30.123456789+09:00".toOffsetTime("HH:mm:ss.SSSSSSSSSXXX")

        // When
        val nanoseconds: Duration = offsetTime.nanoseconds // PT0.123456789S

        // Then
        assertEquals(
            expected = Duration.ofNanos(123_456_789),
            actual = nanoseconds,
        )
    }

    @Test
    fun plus() {
        // Given
        var offsetTime: OffsetTime = "12:00:00+09:00".toOffsetTime()

        // When
        offsetTime += 1.hours

        // Then
        assertEquals(
            expected = OffsetTime.of(13, 0, 0, 0, ZoneOffset.ofHours(9)),
            actual = offsetTime,
        )

        // When
        offsetTime += 30.minutes

        // Then
        assertEquals(
            expected = OffsetTime.of(13, 30, 0, 0, ZoneOffset.ofHours(9)),
            actual = offsetTime,
        )

        // When
        offsetTime += 30.seconds

        // Then
        assertEquals(
            expected = OffsetTime.of(13, 30, 30, 0, ZoneOffset.ofHours(9)),
            actual = offsetTime,
        )
    }

    @Test
    fun minus() {
        // Given
        var offsetTime: OffsetTime = "12:00:00+09:00".toOffsetTime()

        // When
        offsetTime -= 1.hours

        // Then
        assertEquals(
            expected = OffsetTime.of(11, 0, 0, 0, ZoneOffset.ofHours(9)),
            actual = offsetTime,
        )

        // When
        offsetTime -= 30.minutes

        // Then
        assertEquals(
            expected = OffsetTime.of(10, 30, 0, 0, ZoneOffset.ofHours(9)),
            actual = offsetTime,
        )

        // When
        offsetTime -= 30.seconds

        // Then
        assertEquals(
            expected = OffsetTime.of(10, 29, 30, 0, ZoneOffset.ofHours(9)),
            actual = offsetTime,
        )
    }

    @Test
    fun at() {
        // Given
        val offsetTime: OffsetTime = "12:00:00+09:00".toOffsetTime()

        // When
        val dateTime: OffsetDateTime = offsetTime at "2022-01-01".toLocalDate() // 2022-01-01T12:00+09:00

        // Then
        assertEquals(
            expected = OffsetDateTime.of(2022, 1, 1, 12, 0, 0, 0, ZoneOffset.ofHours(9)),
            actual = dateTime,
        )
    }

    @Test
    fun between() {
        // Given
        val start: OffsetTime = "12:00:00+09:00".toOffsetTime()
        val end: OffsetTime = "13:00:00+09:00".toOffsetTime()

        // When
        val duration: Duration = start between end // PT1H

        // Then
        assertEquals(
            expected = Duration.ofHours(1),
            actual = duration,
        )

        // When
        val duration2: Duration = start between "13:00:00+10:00".toOffsetTime() // PT0S

        // Then
        assertEquals(
            expected = Duration.ofHours(0),
            actual = duration2,
        )
    }
}