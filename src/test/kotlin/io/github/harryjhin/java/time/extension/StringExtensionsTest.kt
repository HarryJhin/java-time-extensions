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