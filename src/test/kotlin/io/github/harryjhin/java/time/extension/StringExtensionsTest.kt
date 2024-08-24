package io.github.harryjhin.java.time.extension

import kotlin.test.Test
import kotlin.test.assertEquals

class StringExtensionsTest {

    @Test
    fun years() {
        // Given
        val text = "2022"

        // When
        val year = text.years

        // Then
        assertEquals(
            expected = 2022,
            actual = year.value,
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
            expected = 1,
            actual = month.value,
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
            expected = 1,
            actual = hour.value,
        )
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