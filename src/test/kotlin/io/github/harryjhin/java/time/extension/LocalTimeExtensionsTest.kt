package io.github.harryjhin.java.time.extension

import kotlin.test.Test
import kotlin.test.assertEquals

class LocalTimeExtensionsTest {

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
}