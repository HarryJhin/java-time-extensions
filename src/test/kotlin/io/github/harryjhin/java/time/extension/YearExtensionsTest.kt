package io.github.harryjhin.java.time.extension

import kotlin.test.Test
import kotlin.test.assertEquals

class YearExtensionsTest {

    @Test
    fun plus() {
        // Given
        val year = 2022.years

        // When
        val plusOneYear = year + 1.years

        // Then
        assertEquals(
            actual = plusOneYear,
            expected = 2023.years,
        )
    }

    @Test
    fun plusAssign() {
        // Given
        var year = 2022.years

        // When
        year += 1.years

        // Then
        assertEquals(
            actual = year,
            expected = 2023.years,
        )
    }

    @Test
    fun minus() {
        // Given
        val year = 2022.years

        // When
        val minusOneYear = year - 1.years

        // Then
        assertEquals(
            actual = minusOneYear,
            expected = 2021.years,
        )
    }

    @Test
    fun minusAssign() {
        // Given
        var year = 2022.years

        // When
        year -= 1.years

        // Then
        assertEquals(
            actual = year,
            expected = 2021.years,
        )
    }
}