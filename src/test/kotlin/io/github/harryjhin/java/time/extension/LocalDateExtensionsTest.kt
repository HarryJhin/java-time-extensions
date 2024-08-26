package io.github.harryjhin.java.time.extension

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Month
import java.time.MonthDay
import java.time.Period
import java.time.Year
import java.time.YearMonth
import kotlin.test.Test
import kotlin.test.assertEquals

class LocalDateExtensionsTest {

    @Test
    fun years() {
        // Given
        val date: LocalDate = "2022-01-01".toLocalDate()

        // When
        val years: Period = date.years

        // Then
        assertEquals(
            actual = years,
            expected = Period.ofYears(2022),
        )
    }

    @Test
    fun months() {
        // Given
        val date: LocalDate = "2022-01-01".toLocalDate()

        // When
        val months: Period = date.months

        // Then
        assertEquals(
            actual = months,
            expected = Period.ofMonths(1),
        )
    }

    @Test
    fun days() {
        // Given
        val date: LocalDate = "2022-01-01".toLocalDate()

        // When
        val days: Period = date.days

        // Then
        assertEquals(
            expected = Period.ofDays(1),
            actual = days,
        )
    }

    @Test
    fun plus() {
        // Given
        val date: LocalDate = "2022-01-01".toLocalDate()

        // When
        val plusOneYear: LocalDate = date + 1L.years
        val plusOneMonth: LocalDate = date + 1.months
        val plusOneDay: LocalDate = date + 1.days

        // Then
        assertEquals(
            expected = LocalDate.of(2023, 1, 1),
            actual = plusOneYear,
        )
        assertEquals(
            expected = LocalDate.of(2022, 2, 1),
            actual = plusOneMonth,
        )
        assertEquals(
            expected = LocalDate.of(2022, 1, 2),
            actual = plusOneDay,
        )
    }

    @Test
    fun plusAssign() {
        // Given
        var date: LocalDate = "2022-01-01".toLocalDate()

        // When
        date += 1.years

        // Then
        assertEquals(
            expected = LocalDate.of(2023, 1, 1),
            actual = date,
        )

        // When
        date += 1.months

        // Then
        assertEquals(
            expected = LocalDate.of(2023, 2, 1),
            actual = date,
        )

        // When
        date += 1L.days

        // Then
        assertEquals(
            expected = LocalDate.of(2023, 2, 2),
            actual = date,
        )
    }

    @Test
    fun minus() {
        // Given
        val date: LocalDate = "2022-01-01".toLocalDate()

        // When
        val minusOneYear: LocalDate = date - 1.years
        val minusOneMonth: LocalDate = date - 1.months
        val minusOneDay: LocalDate = date - 1.days

        // Then
        assertEquals(
            expected = LocalDate.of(2021, 1, 1),
            actual = minusOneYear,
        )
        assertEquals(
            expected = LocalDate.of(2021, 12, 1),
            actual = minusOneMonth,
        )
        assertEquals(
            expected = LocalDate.of(2021, 12, 31),
            actual = minusOneDay,
        )
    }

    @Test
    fun minusAssign() {
        // Given
        var date: LocalDate = "2022-01-01".toLocalDate()

        // When
        date -= 1.years

        // Then
        assertEquals(
            expected = LocalDate.of(2021, 1, 1),
            actual = date,
        )

        // When
        date -= "1".months

        // Then
        assertEquals(
            expected = LocalDate.of(2020, 12, 1),
            actual = date,
        )

        // When
        date -= 1L.days

        // Then
        assertEquals(
            expected = LocalDate.of(2020, 11, 30),
            actual = date,
        )
    }

    @Test
    fun toYear() {
        // Given
        val date: LocalDate = "2022-01-01".toLocalDate()

        // When
        val year: Year = date.toYear()

        // Then
        assertEquals(
            expected = Year.of(2022),
            actual = year,
        )
    }

    @Test
    fun toMonth() {
        // Given
        val date: LocalDate = "2022-01-01".toLocalDate()

        // When
        val month: Month = date.toMonth()

        // Then
        assertEquals(
            expected = Month.JANUARY,
            actual = month,
        )
    }

    @Test
    fun toYearMonth() {
        // Given
        val date: LocalDate = "2022-01-01".toLocalDate()

        // When
        val yearMonth: YearMonth = date.toYearMonth()

        // Then
        assertEquals(
            expected = YearMonth.of(2022, 1),
            actual = yearMonth,
        )
    }

    @Test
    fun toMonthDay() {
        // Given
        val date: LocalDate = "2022-01-01".toLocalDate()

        // When
        val monthDay: MonthDay = date.toMonthDay()

        // Then
        assertEquals(
            expected = MonthDay.of(1, 1),
            actual = monthDay,
        )
    }

    @Test
    fun atLocalTime() {
        // Given
        val date: LocalDate = "2022-01-01".toLocalDate()
        val time: LocalTime = "12:34:56".toLocalTime()

        // When
        val dateTime: LocalDateTime = date at time

        // Then
        assertEquals(
            expected = LocalDateTime.of(2022, 1, 1, 12, 34, 56),
            actual = dateTime,
        )
    }
}