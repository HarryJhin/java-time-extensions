package io.github.harryjhin.java.time.extension

import java.time.LocalDate
import java.time.Month
import java.time.MonthDay
import java.time.Period
import java.time.Year
import java.time.YearMonth
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class MonthExtensionsTest {

    @Test
    fun plus() {
        // Given
        val month: Month = 1.toMonth()

        // When
        val result: Month = month + 1L

        // Then
        assertEquals(
            expected = 2,
            actual = result.value,
        )
    }

    @Test
    fun minus() {
        // Given
        val month: Month = 2.toMonth()

        // When
        val result: Month = month - 1L

        // Then
        assertEquals(
            expected = 1,
            actual = result.value,
        )
    }

    @Test
    fun months() {
        // Given
        val month: Month = 1.toMonth()

        // When
        val result: Period = month.months

        // Then
        assertEquals(
            expected = "P1M",
            actual = result.toString(),
        )
    }

    @Test
    fun atDayOfMonth() {
        // Given
        val month: Month = 1.toMonth()

        // When
        val result: MonthDay = month at 1

        // Then
        assertEquals(
            expected = MonthDay.of(month, 1),
            actual = result,
        )
    }

    @Test
    fun atYear() {
        // Given
        val month: Month = 1.toMonth()
        val year: Year = 2022.toYear()

        // When
        val result: YearMonth = month at year

        // Then
        assertEquals(
            expected = YearMonth.of(year.value, month.value),
            actual = result,
        )
    }

    @Test
    fun atYearAtDayOfMonth() {
        // Given
        val month: Month = 1.toMonth()

        // When
        val date: LocalDate = month at 2022.toYear() at 1

        // Then
        assertEquals(
            expected = LocalDate.of(2022, 1, 1),
            actual = date,
        )
    }

    @Test
    fun intToMonth() {
        // Given
        val month: Int = 1

        // When
        val result: Month = month.toMonth()

        // Then
        assertEquals(
            expected = Month.of(month),
            actual = result,
        )
    }

    @Test
    fun intToMonthFail() {
        // Given
        val month: Int = Month.entries.size + 1

        // When
        assertFails {
            month.toMonth()
        }
    }

    @Test
    fun intToMonthOrNull() {
        // Given
        val month: Int = Month.entries.size + 1

        // When
        val result: Month? = month.toMonthOrNull()

        // Then
        assertEquals(
            expected = null,
            actual = result,
        )
    }

    @Test
    fun longToMonth() {
        // Given
        val month: Long = 1L

        // When
        val result: Month = month.toMonth()

        // Then
        assertEquals(
            expected = Month.of(month.toInt()),
            actual = result,
        )
    }

    @Test
    fun longToMonthFail() {
        // Given
        val month: Long = Month.entries.size + 1L

        // When
        assertFails {
            month.toMonth()
        }
    }

    @Test
    fun longToMonthOrNull() {
        // Given
        val month: Long = Month.entries.size + 1L

        // When
        val result: Month? = month.toMonthOrNull()

        // Then
        assertEquals(
            expected = null,
            actual = result,
        )
    }
}