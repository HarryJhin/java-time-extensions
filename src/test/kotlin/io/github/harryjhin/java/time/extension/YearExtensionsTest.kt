package io.github.harryjhin.java.time.extension

import java.time.Month
import java.time.MonthDay
import java.time.Year
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class YearExtensionsTest {

    @Test
    fun plus() {
        // Given
        val year = "2022".toYear()

        // When
        val plusOneYear = year + 1.years

        // Then
        assertEquals(
            actual = plusOneYear,
            expected = "2023".toYear(),
        )
    }

    @Test
    fun plusAssign() {
        // Given
        var year = "2022".toYear()

        // When
        year += 1.years

        // Then
        assertEquals(
            actual = year,
            expected = "2023".toYear(),
        )
    }

    @Test
    fun minus() {
        // Given
        val year = "2022".toYear()

        // When
        val minusOneYear: Year = year - 1.years

        // Then
        assertEquals(
            actual = minusOneYear,
            expected = "2021".toYear(),
        )
    }

    @Test
    fun minusAssign() {
        // Given
        var year = "2022".toYear()

        // When
        year -= 1.years

        // Then
        assertEquals(
            actual = year,
            expected = Year.of(2021),
        )
    }

    @Test
    fun at() {
        // Given
        val year = "2022".toYear()

        // When
        val yearMonth = year at Month.JANUARY

        // Then
        assertEquals(
            actual = yearMonth,
            expected = "2022-01".toYearMonth(),
        )

        // When
        val date = year at MonthDay.of(1, 1)

        // Then
        assertEquals(
            actual = date,
            expected = "2022-01-01".toLocalDate(),
        )

        // When
        val date2 = year at 1

        // Then
        assertEquals(
            actual = date2,
            expected = "2022-01-01".toLocalDate(),
        )

        // When
        assertFails {
            year at 366
        }
    }
}