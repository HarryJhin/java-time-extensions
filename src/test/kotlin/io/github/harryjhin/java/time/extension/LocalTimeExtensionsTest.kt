package io.github.harryjhin.java.time.extension

import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalTimeExtensionsTest {

    @Test
    fun hours() {
        // Given
        val time: LocalTime = "12:00:30".toLocalTime()

        // When
        val hours: Duration = time.hours

        // Then
        assertEquals(
            expected = Duration.ofHours(12),
            actual = hours,
        )
    }

    @Test
    fun minutes() {
        // Given
        val time: LocalTime = "12:30:00".toLocalTime()

        // When
        val minutes: Duration = time.minutes

        // Then
        assertEquals(
            expected = Duration.ofMinutes(30),
            actual = minutes,
        )
    }

    @Test
    fun seconds() {
        // Given
        val time: LocalTime = "12:00:30".toLocalTime()

        // When
        val seconds: Duration = time.seconds

        // Then
        assertEquals(
            expected = Duration.ofSeconds(30),
            actual = seconds,
        )
    }

    @Test
    fun milliseconds() {
        // Given
        val time: LocalTime = "12:00:00.500".toLocalTime("HH:mm:ss.SSS")

        // When
        val milliseconds: Duration = time.milliseconds

        // Then
        assertEquals(
            expected = Duration.ofMillis(500),
            actual = milliseconds,
        )
    }

    @Test
    fun microseconds() {
        // Given
        val time: LocalTime = "12:00:00.500000".toLocalTime("HH:mm:ss.SSSSSS")

        // When
        val microseconds: Duration = time.microseconds

        // Then
        assertEquals(
            expected = Duration.ofNanos(500_000),
            actual = microseconds,
        )
    }

    @Test
    fun nanoseconds() {
        // Given
        val time: LocalTime = "12:00:00.500000000".toLocalTime("HH:mm:ss.SSSSSSSSS")

        // When
        val nanoseconds: Duration = time.nanoseconds

        // Then
        assertEquals(
            expected = Duration.ofNanos(500_000_000),
            actual = nanoseconds,
        )
    }

    @Test
    fun plus() {
        // Given
        val time = "00:00:00".toLocalTime()

        // When
        val plusOneHour = time + 1.hours
        val plusOneHourOneMinute = time + 1.hours + 1.minutes
        val plusOneHourOneMinuteOneSecond = time + 1.hours + 1.minutes + 1.seconds

        // Then
        assertEquals(
            expected = "01:00:00".toLocalTime(),
            actual = plusOneHour,
        )
        assertEquals(
            expected = "01:01:00".toLocalTime(),
            actual = plusOneHourOneMinute,
        )
        assertEquals(
            expected = "01:01:01".toLocalTime(),
            actual = plusOneHourOneMinuteOneSecond,
        )
    }

    @Test
    fun plusAssign() {
        // Given
        var time = "00:00:00".toLocalTime()

        // When
        time += 1.hours

        // Then
        assertEquals(
            expected = "01:00:00".toLocalTime(),
            actual = time,
        )
    }

    @Test
    fun minus() {
        // Given
        val time = "01:01:01".toLocalTime()

        // When
        val minusOneHour = time - 1.hours
        val minusOneHourOneMinute = time - 1.hours - 1.minutes
        val minusOneHourOneMinuteOneSecond = time - 1.hours - 1.minutes - 1.seconds

        // Then
        assertEquals(
            expected = "00:01:01".toLocalTime(),
            actual = minusOneHour,
        )
        assertEquals(
            expected = "00:00:01".toLocalTime(),
            actual = minusOneHourOneMinute,
        )
        assertEquals(
            expected = "00:00:00".toLocalTime(),
            actual = minusOneHourOneMinuteOneSecond,
        )
    }

    @Test
    fun minusAssign() {
        // Given
        var time = "01:01:01".toLocalTime()

        // When
        time -= 1.hours

        // Then
        assertEquals(
            expected = "00:01:01".toLocalTime(),
            actual = time,
        )
    }

    @Test
    fun toDuration() {
        // Given
        val time: LocalTime = "01:01:01".toLocalTime()

        // When
        val duration: Duration = time.toDuration()

        // Then
        assertEquals(
            expected = Duration.ofHours(1).plusMinutes(1).plusSeconds(1),
            actual = duration,
        )
    }

    @Test
    fun atDate() {
        // Given
        val time: LocalTime = "12:00:00".toLocalTime()
        val date: LocalDate = "2022-01-01".toLocalDate()

        // When
        val dateTime: LocalDateTime = time at date

        // Then
        assertEquals(
            expected = LocalDateTime.of(2022, 1, 1, 12, 0, 0),
            actual = dateTime,
        )
    }

    @Test
    fun between() {
        // Given
        val start: LocalTime = "12:00:00".toLocalTime()

        // When
        val actual: Duration = start between "12:00:30".toLocalTime() // PT30S

        // Then
        assertEquals(
            expected = Duration.ofSeconds(30),
            actual = actual,
        )

        // When
        val actual2: Duration = start between "12:30:00".toLocalTime() // PT30M

        // Then
        assertEquals(
            expected = Duration.ofMinutes(30),
            actual = actual2,
        )

        // When
        val actual3: Duration = start between "13:00:00".toLocalTime() // PT1H

        // Then
        assertEquals(
            expected = Duration.ofHours(1),
            actual = actual3,
        )

        // When
        val actual4: Duration = start between "13:30:30".toLocalTime() // PT1H30M30S

        // Then
        assertEquals(
            expected = Duration.ofHours(1).plusMinutes(30).plusSeconds(30),
            actual = actual4,
        )

        // When
        val actual5: Duration = start between "10:30:30".toLocalTime() // PT-1H-29M-30S

        // Then
        assertEquals(
            expected = Duration.ofHours(-1).plusMinutes(-29).plusSeconds(-30),
            actual = actual5,
        )
    }
}