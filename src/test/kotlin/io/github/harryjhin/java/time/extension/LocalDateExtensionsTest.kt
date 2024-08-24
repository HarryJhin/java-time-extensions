package io.github.harryjhin.java.time.extension

import java.time.LocalDate
import java.time.YearMonth
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalDateExtensionsTest {

    @Test
    fun toYearMonth() {
        // Given
        val date = LocalDate.of(2022, 1, 1)

        // When
        val yearMonth = date.toYearMonth()

        // Then
        assertEquals(
            actual = yearMonth,
            expected = YearMonth.of(2022, 1),
        )
    }

    @Test
    fun plus() {
        // Given
        val date = LocalDate.of(2022, 1, 1)

        // When
        val plusOneYear = date + 1L.years.amounts
        val plusOneMonth = date + 1.months.amounts
        val plusOneYearOneMonth = date + YearMonth.of(1, 1).amounts
        val plusOneYearOneMonthOneDay = date + LocalDate.of(1, 1, 1).amounts

        // Then
        assertEquals(
            actual = plusOneYear,
            expected = LocalDate.of(2023, 1, 1),
        )
        assertEquals(
            actual = plusOneMonth,
            expected = LocalDate.of(2022, 2, 1),
        )
        assertEquals(
            actual = plusOneYearOneMonth,
            expected = LocalDate.of(2023, 2, 1),
        )
        assertEquals(
            actual = plusOneYearOneMonthOneDay,
            expected = LocalDate.of(2023, 2, 2),
        )
    }

    @Test
    fun plusAssign() {
        // Given
        var date = LocalDate.of(2022, 1, 1)

        // When
        date += 1.years.amounts

        // Then
        assertEquals(
            actual = date,
            expected = LocalDate.of(2023, 1, 1),
        )

        // When
        date += 1L.months.amounts

        // Then
        assertEquals(
            actual = date,
            expected = LocalDate.of(2023, 2, 1),
        )
    }

    @Test
    fun minus() {
        // Given
        val date = LocalDate.of(2022, 1, 1)

        // When
        val minusOneYear = date - "1".years.amounts
        val minusOneMonth = date - 1.months.amounts

        // Then
        assertEquals(
            actual = minusOneYear,
            expected = LocalDate.of(2021, 1, 1),
        )
        assertEquals(
            actual = minusOneMonth,
            expected = LocalDate.of(2021, 12, 1),
        )
    }

    @Test
    fun minusAssign() {
        // Given
        var date = LocalDate.of(2022, 1, 1)

        // When
        date -= 1.years.amounts

        // Then
        assertEquals(
            actual = date,
            expected = LocalDate.of(2021, 1, 1),
        )

        // When
        date -= "1".months.amounts

        // Then
        assertEquals(
            actual = date,
            expected = LocalDate.of(2020, 12, 1),
        )
    }
}