package io.github.harryjhin.java.time.extension

import java.time.LocalDate
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.fail

class HourOfDayTest {

    @Test
    fun now() {
        // Given

        // When
        try {
            HourOfDay.now()
        } catch (e: Exception) {
            fail("Should not throw any exception")
        }

        // Then
    }

    @Test
    fun of() {
        // Given
        val hour = HourOfDay.of(1)

        // When

        // Then
        assertEquals(
            expected = 1,
            actual = hour.value,
        )
    }

    @Test
    fun from() {
        // Given
        val time = "01:00:00".toLocalTime()

        // When
        val hour = HourOfDay.from(time)

        // Then
        assertEquals(
            expected = 1,
            actual = hour.value,
        )
        assertFails {
            HourOfDay.from(LocalDate.now())
        }
    }

    @Test
    fun parse() {
        // Given
        val text = "01"

        // When
        val hour = HourOfDay.parse(text)

        // Then
        assertEquals(
            expected = 1,
            actual = hour.value,
        )
    }

    @Test
    fun plus() {
        // Given
        val hour = 1.hours

        // When
        val plusOneHour = hour + 1.hours.amounts

        // Then
        assertEquals(
            expected = 2.hours,
            actual = plusOneHour,
        )
    }

    @Test
    fun minus() {
        // Given
        val hour = "2".hours

        // When
        val minusOneHour = hour - "1".hours.amounts

        // Then
        assertEquals(
            expected = "1".hours,
            actual = minusOneHour,
        )
    }

    @Test
    fun overflow() {
        // Given
        val hour = 0L.hours

        // When
        assertFails {
            hour + 24L.hours.amounts
        }

        // Then
    }

    @Test
    fun underflow() {
        // Given
        val hour = 0L.hours

        // When
        assertFails {
            hour - 1L.hours.amounts
        }

        // Then
    }

    @Test
    fun isBefore() {
        // Given
        val hour = 1.hours

        // When
        val isBefore = hour.isBefore(2.hours)

        // Then
        assertEquals(
            expected = true,
            actual = isBefore,
        )
    }

    @Test
    fun isAfter() {
        // Given
        val hour = 1.hours

        // When
        val isAfter = hour.isAfter(2.hours)

        // Then
        assertEquals(
            expected = false,
            actual = isAfter,
        )
    }

    @Test
    fun compareTo() {
        // Given
        val hour = 1.hours

        // When
        val greater = hour.compareTo(0.hours)
        val same = hour.compareTo(1.hours)
        val less = hour.compareTo(2.hours)

        // Then
        assertEquals(
            expected = 1,
            actual = greater,
        )
        assertEquals(
            expected = 0,
            actual = same,
        )
        assertEquals(
            expected = -1,
            actual = less,
        )
    }

    @Test
    fun equals() {
        // Given
        val hour = 1.hours

        // When
        val equals = hour == 1.hours
        val notEquals = hour == 2.hours

        // Then
        assertEquals(
            expected = true,
            actual = equals,
        )
        assertEquals(
            expected = false,
            actual = notEquals,
        )
    }
}