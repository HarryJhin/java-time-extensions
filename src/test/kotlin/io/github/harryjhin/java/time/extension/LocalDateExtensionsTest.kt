package io.github.harryjhin.java.time.extension

import java.time.LocalDate
import java.time.YearMonth
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalDateExtensionsTest {

    @Test
    fun toYearMonth() {
        // Given
        val date = "2022-01-01".toLocalDate()

        // When
        val yearMonth = date.toYearMonth()

        // Then
        assertEquals(
            actual = yearMonth,
            expected = "2022-01".toYearMonth(),
        )
    }

    @Test
    fun plus() {
        // Given
        val date = LocalDate.of(2022, 1, 1)

        // When
        val plusOneYear = date + 1L.years
        val plusOneMonth = date + 1.months
        val plusOneDay = date + 1.days

        // Then
        assertEquals(
            actual = plusOneYear,
            expected = "2023-01-01".toLocalDate(),
        )
        assertEquals(
            actual = plusOneMonth,
            expected = "2022-02-01".toLocalDate(),
        )
        assertEquals(
            actual = plusOneDay,
            expected = "2022-01-02".toLocalDate(),
        )
    }

    @Test
    fun plusAssign() {
        // Given
        var date = LocalDate.of(2022, 1, 1)

        // When
        date += 1.years

        // Then
        assertEquals(
            actual = date,
            expected = "2023-01-01".toLocalDate(),
        )

        // When
        date += 1.months

        // Then
        assertEquals(
            actual = date,
            expected = "2023-02-01".toLocalDate(),
        )

        // When
        date += 1L.days

        // Then
        assertEquals(
            actual = date,
            expected = "2023-02-02".toLocalDate(),
        )
    }

    @Test
    fun minus() {
        // Given
        val date = LocalDate.of(2022, 1, 1)

        // When
        val minusOneYear = date - 1.years
        val minusOneMonth = date - 1.months
        val minusOneDay = date - 1.days

        // Then
        assertEquals(
            actual = minusOneYear,
            expected = "2021-01-01".toLocalDate(),
        )
        assertEquals(
            actual = minusOneMonth,
            expected = "2021-12-01".toLocalDate(),
        )
        assertEquals(
            actual = minusOneDay,
            expected = "2021-12-31".toLocalDate(),
        )
    }

    @Test
    fun minusAssign() {
        // Given
        var date = "2022-01-01".toLocalDate()

        // When
        date -= 1.years

        // Then
        assertEquals(
            actual = date,
            expected = "2021-01-01".toLocalDate(),
        )

        // When
        date -= "1".months

        // Then
        assertEquals(
            actual = date,
            expected = "2020-12-01".toLocalDate(),
        )

        // When
        date -= 1L.days

        // Then
        assertEquals(
            actual = date,
            expected = "2020-11-30".toLocalDate(),
        )
    }
}