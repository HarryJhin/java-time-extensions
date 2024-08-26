package io.github.harryjhin.java.time.extension

import java.time.MonthDay
import java.time.Period
import java.time.Year
import java.time.format.DateTimeFormatter
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

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

    @Test
    fun stringToMonthDay() {
        // Given
        val string = "01-01"

        // When
        val monthDay = string.toMonthDay()
        println(monthDay.toString("MM-dd"))

        // Then
        assertEquals(
            expected = MonthDay.of(1, 1),
            actual = monthDay,
        )
    }

    @Test
    fun stringToMonthDayWithPattern() {
        // Given
        val string = "01-01"
        val pattern = "MM-dd"

        // When
        val monthDay: MonthDay = string.toMonthDay(pattern)

        // Then
        assertEquals(
            expected = MonthDay.of(1, 1),
            actual = monthDay,
        )
    }

    @Test
    fun stringToMonthDayWithFormatter() {
        // Given
        val string = "01-01"
        val formatter: DateTimeFormatter = "MM-dd".toDateTimeFormatter()

        // When
        val monthDay: MonthDay = string.toMonthDay(formatter)

        // Then
        assertEquals(
            expected = MonthDay.of(1, 1),
            actual = monthDay,
        )
    }

    @Test
    fun stringToMonthDayFail() {
        // Given
        val string = "01-32"

        // When
        assertFails {
            string.toMonthDay()
        }

        // Then
    }

    @Test
    fun stringToMonthDayOrNull() {
        // Given
        val string = "01-32"

        // When
        val monthDay = string.toMonthDayOrNull()

        // Then
        assertEquals(
            expected = null,
            actual = monthDay,
        )
    }

    @Test
    fun stringToMonthDayOrNullWithPattern() {
        // Given
        val string = "01-32"
        val pattern = "MM-dd"

        // When
        val monthDay = string.toMonthDayOrNull(pattern)

        // Then
        assertEquals(
            expected = null,
            actual = monthDay,
        )
    }

    @Test
    fun stringToMonthDayOrNullWithFormatter() {
        // Given
        val string = "01-32"
        val formatter: DateTimeFormatter = "MM-dd".toDateTimeFormatter()

        // When
        val monthDay = string.toMonthDayOrNull(formatter)

        // Then
        assertEquals(
            expected = null,
            actual = monthDay,
        )
    }
}