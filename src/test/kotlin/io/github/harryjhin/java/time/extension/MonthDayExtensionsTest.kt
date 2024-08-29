package io.github.harryjhin.java.time.extension

import java.time.MonthDay
import java.time.Period
import java.time.Year
import kotlin.test.Test
import kotlin.test.assertEquals

class MonthDayExtensionsTest {

    @Test
    fun months() {
        // Given
        val monthDay: MonthDay = MonthDay.of(1, 1)

        // When
        val period: Period = monthDay.months

        // Then
        assertEquals(
            expected = "P1M",
            actual = period.toString(),
        )
    }

    @Test
    fun days() {
        // Given
        val monthDay: MonthDay = MonthDay.of(1, 1)

        // When
        val period: Period = monthDay.days

        // Then
        assertEquals(
            expected = "P1D",
            actual = period.toString(),
        )
    }

    @Test
    fun atYear() {
        // Given
        val monthDay: MonthDay = MonthDay.of(1, 1)
        val year: Year = Year.of(2022)

        // When
        val date = monthDay at year

        // Then
        assertEquals(
            expected = "2022-01-01",
            actual = date.toString(),
        )
    }
}