package io.github.harryjhin.java.time.extension

import java.time.Period
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class YearMonthExtensionsTest {

    @Test
    fun stringToYearMonth() {
        // Given
        val yearMonth: YearMonth = "2022-01".toYearMonth()

        // Then
        assertEquals(
            expected = YearMonth.of(2022, 1),
            actual = yearMonth,
        )
    }

    @Test
    fun stringToYearMonthFormat() {
        // Given
        val yearMonth: YearMonth = "22-01".toYearMonth("yy-MM")

        // Then
        assertEquals(
            expected = YearMonth.of(2022, 1),
            actual = yearMonth,
        )
    }

    @Test
    fun stringToYearMonthFormatter() {
        // Given
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM")
        val yearMonth: YearMonth = "22-01".toYearMonth(formatter)

        // Then
        assertEquals(
            expected = YearMonth.of(2022, 1),
            actual = yearMonth,
        )
    }

    @Test
    fun stringToYearMonthFail() {
        // When
        assertFails {
            "2022-13".toYearMonth()
        }
    }

    @Test
    fun stringToYearMonthOrNull() {
        // Given
        val yearMonth: YearMonth? = "22-01".toYearMonthOrNull()

        // Then
        assertEquals(
            expected = null,
            actual = yearMonth,
        )
    }

    @Test
    fun stringToYearMonthOrNullFormat() {
        // Given
        val yearMonth: YearMonth? = "2022-01".toYearMonthOrNull("yy-MM")

        // Then
        assertEquals(
            expected = null,
            actual = yearMonth,
        )
    }

    @Test
    fun stringToYearMonthOrNullFormatter() {
        // Given
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM")
        val yearMonth: YearMonth? = "2022-01".toYearMonthOrNull(formatter)

        // Then
        assertEquals(
            expected = null,
            actual = yearMonth,
        )
    }

    @Test
    fun years() {
        // Given
        val yearMonth: YearMonth = "2022-01".toYearMonth()

        // When
        val years: Period = yearMonth.years

        // Then
        assertEquals(
            expected = "P2022Y",
            actual = years.toString(),
        )
    }

    @Test
    fun months() {
        // Given
        val yearMonth: YearMonth = "2022-01".toYearMonth()

        // When
        val months: Period = yearMonth.months

        // Then
        assertEquals(
            expected = "P1M",
            actual = months.toString(),
        )
    }

    @Test
    fun plus() {
        // Given
        val yearMonth: YearMonth = "2022-01".toYearMonth()

        // When
        val plusOneMonth: YearMonth = yearMonth + 1.months

        // Then
        assertEquals(
            actual = plusOneMonth,
            expected = "2022-02".toYearMonth(),
        )
    }

    @Test
    fun plusAssign() {
        // Given
        var yearMonth: YearMonth = "2022-01".toYearMonth()

        // When
        yearMonth += 1.months

        // Then
        assertEquals(
            actual = yearMonth,
            expected = "2022-02".toYearMonth(),
        )
    }

    @Test
    fun minus() {
        // Given
        val yearMonth: YearMonth = "2022-01".toYearMonth()

        // When
        val minusOneMonth: YearMonth = yearMonth - 1.months

        // Then
        assertEquals(
            actual = minusOneMonth,
            expected = "2021-12".toYearMonth(),
        )
    }

    @Test
    fun minusAssign() {
        // Given
        var yearMonth: YearMonth = "2022-01".toYearMonth()

        // When
        yearMonth -= 1.months

        // Then
        assertEquals(
            actual = yearMonth,
            expected = "2021-12".toYearMonth(),
        )
    }

    @Test
    fun atDayOfMonth() {
        // Given
        val yearMonth = "2022-01".toYearMonth()

        // When
        val date = yearMonth at 1

        // Then
        assertEquals(
            actual = date,
            expected = "2022-01-01".toLocalDate(),
        )
    }

    @Test
    fun between() {
        // Given
        val startYearMonth: YearMonth = "2022-01".toYearMonth()

        // When
        val actual: Period = startYearMonth between "2022-02".toYearMonth()

        // Then
        assertEquals(
            expected = Period.ofMonths(1),
            actual = actual,
        )

        // When
        val actual2: Period = startYearMonth between "2023-01".toYearMonth()

        // Then
        assertEquals(
            expected = Period.ofYears(1),
            actual = actual2,
        )

        // When
        val actual3: Period = startYearMonth between "2023-02".toYearMonth()

        // Then
        assertEquals(
            expected = Period.ofYears(1).plusMonths(1),
            actual = actual3,
        )
    }
}