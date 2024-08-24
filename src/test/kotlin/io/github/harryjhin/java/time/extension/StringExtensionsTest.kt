package io.github.harryjhin.java.time.extension

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class StringExtensionsTest {

    @Test
    fun years() {
        // Given
        val text = "2022"

        // When
        val year = text.years

        // Then
        assertEquals(
            expected = "P2022Y",
            actual = year.toString(),
        )
    }

    @Test
    fun months() {
        // Given
        val text = "1"

        // When
        val month = text.months

        // Then
        assertEquals(
            expected = "P1M",
            actual = month.toString(),
        )
    }

    @Test
    fun days() {
        // Given
        val text = "1"

        // When
        val day = text.days

        // Then
        assertEquals(
            expected = "P1D",
            actual = day.toString(),
        )
    }

    @Test
    fun hours() {
        // Given
        val text = "1"

        // When
        val hour = text.hours

        // Then
        assertEquals(
            expected = "PT1H",
            actual = hour.toString(),
        )
    }

    @Test
    fun minutes() {
        // Given
        val text = "1"

        // When
        val minute = text.minutes

        // Then
        assertEquals(
            expected = "PT1M",
            actual = minute.toString(),
        )
    }

    @Test
    fun seconds() {
        // Given
        val text = "1"

        // When
        val second = text.seconds

        // Then
        assertEquals(
            expected = "PT1S",
            actual = second.toString(),
        )
    }

    @Test
    fun milliseconds() {
        // Given
        val text = "1"

        // When
        val millisecond = text.milliseconds

        // Then
        assertEquals(
            expected = "PT0.001S",
            actual = millisecond.toString(),
        )
    }

    @Test
    fun microseconds() {
        // Given
        val text = "1"

        // When
        val microsecond = text.microseconds

        // Then
        assertEquals(
            expected = "PT0.000001S",
            actual = microsecond.toString(),
        )
    }

    @Test
    fun nanoseconds() {
        // Given
        val text = "1"

        // When
        val nanosecond = text.nanoseconds

        // Then
        assertEquals(
            expected = "PT0.000000001S",
            actual = nanosecond.toString(),
        )
    }

    @Test
    fun toYear1() {
        // Given
        val text = "2022"

        // When
        val year = text.toYear()

        // Then
        assertEquals(
            expected = "2022".toYear(),
            actual = year,
        )
        assertFails {
            "2022-01".toYear()
        }
    }

    @Test
    fun toYear2() {
        // Given
        val text = "22"

        // When
        val year = text.toYear("yy")

        // Then
        assertEquals(
            expected = "2022".toYear(),
            actual = year,
        )
    }

    @Test
    fun toYear3() {
        // Given
        val text = "22"

        // When

        // Then
        assertFails {
            text.toYear()
        }
    }

    @Test
    fun toYearOrNull1() {
        // Given
        val text = "22"

        // When
        val year = text.toYearOrNull()

        // Then
        assertEquals(
            expected = null,
            actual = year,
        )
    }

    @Test
    fun toYearMonth() {
        // Given
        val text = "2022-01"

        // When
        val yearMonth = text.toYearMonth()

        // Then
        assertEquals(
            expected = "2022-01".toYearMonth(),
            actual = yearMonth,
        )
        assertFails {
            "2022-01-01".toYearMonth()
        }
    }

    @Test
    fun toLocalDate() {
        // Given
        val text = "2022-01-01"

        // When
        val date = text.toLocalDate()

        // Then
        assertEquals(
            expected = "2022-01-01".toLocalDate(),
            actual = date,
        )
    }

    @Test
    fun toLocalDateOrNull() {
        // Given
        val text = "2022-01-01"

        // When
        val date = text.toLocalDateOrNull()

        // Then
        assertEquals(
            expected = "2022-01-01".toLocalDate(),
            actual = date,
        )
    }

    @Test
    fun toLocalDateOrNullReturnsNull() {
        // Given
        val text = "00:00:00"

        // When
        val date = text.toLocalDateOrNull()

        // Then
        assertEquals(
            expected = null,
            actual = date,
        )
    }

    @Test
    fun toLocalTime() {
        // Given
        val text = "00:00:00"

        // When
        val time = text.toLocalTime()

        // Then
        assertEquals(
            expected = "00:00:00".toLocalTime(),
            actual = time,
        )
    }

    @Test
    fun toLocalTimeOrNull() {
        // Given
        val text = "00:00:00"

        // When
        val time = text.toLocalTimeOrNull()

        // Then
        assertEquals(
            expected = "00:00:00".toLocalTime(),
            actual = time,
        )
    }

    @Test
    fun toLocalTimeOrNullReturnsNull() {
        // Given
        val text = "2022-01-01"

        // When
        val time = text.toLocalTimeOrNull()

        // Then
        assertEquals(
            expected = null,
            actual = time,
        )
    }
}