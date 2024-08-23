package io.github.harryjhin.java.time.extension.date

import io.github.harryjhin.java.time.extension.primitive.months
import io.github.harryjhin.java.time.extension.primitive.years
import java.time.LocalDate
import java.time.YearMonth
import kotlin.test.Test
import kotlin.test.assertEquals

class JtLocalDateExtensionsTest {

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
        val plusOneYear = date + 1.years
        val plusOneMonth = date + 1.months

        // Then
        assertEquals(
            actual = plusOneYear,
            expected = LocalDate.of(2023, 1, 1),
        )
        assertEquals(
            actual = plusOneMonth,
            expected = LocalDate.of(2022, 2, 1),
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
            expected = LocalDate.of(2023, 1, 1),
        )

        // When
        date += 1.months

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
        val minusOneYear = date - 1.years
        val minusOneMonth = date - 1.months

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
        date -= 1.years

        // Then
        assertEquals(
            actual = date,
            expected = LocalDate.of(2021, 1, 1),
        )

        // When
        date -= 1.months

        // Then
        assertEquals(
            actual = date,
            expected = LocalDate.of(2020, 12, 1),
        )
    }
}