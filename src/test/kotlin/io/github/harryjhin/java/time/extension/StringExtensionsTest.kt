package io.github.harryjhin.java.time.extension

import java.time.DateTimeException
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Month
import java.time.MonthDay
import java.time.OffsetDateTime
import java.time.OffsetTime
import java.time.Period
import java.time.Year
import java.time.YearMonth
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

class StringExtensionsTest {

    @Test
    fun years() {
        // Given
        val text = "2022"

        // When
        val year: Period = text.years // P2022Y

        // Then
        assertEquals(
            expected = Period.ofYears(2022),
            actual = year,
        )

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "2147483648".years // For input string: "2147483648"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "-2147483649".years // For input string: "-2147483649"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "non-numeric strings".years
        }
    }

    @Test
    fun months() {
        // Given
        val text = "1"

        // When
        val month: Period = text.months // P1M

        // Then
        assertEquals(
            expected = Period.ofMonths(1),
            actual = month,
        )

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "2147483648".months // For input string: "2147483648"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "-2147483649".months // For input string: "-2147483649"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "non-numeric strings".minutes
        }
    }

    @Test
    fun days() {
        // Given
        val text = "1"

        // When
        val day: Period = text.days  // P1D

        // Then
        assertEquals(
            expected = Period.ofDays(1),
            actual = day,
        )

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "2147483648".days // For input string: "2147483648"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "-2147483649".days // For input string: "-2147483649"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "non-numeric strings".minutes
        }
    }

    @Test
    fun hours() {
        // Given
        val text = "1"

        // When
        val hour: Duration = text.hours // PT1H

        // Then
        assertEquals(
            expected = Duration.ofHours(1),
            actual = hour,
        )

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "9223372036854775808".hours // For input string: "9223372036854775808"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "-9223372036854775809".hours // For input string: "-9223372036854775809"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "non-numeric strings".minutes
        }
    }

    @Test
    fun minutes() {
        // Given
        val text = "1"

        // When
        val minute: Duration = text.minutes // PT1M

        // Then
        assertEquals(
            expected = Duration.ofMinutes(1),
            actual = minute,
        )

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "9223372036854775808".minutes // For input string: "9223372036854775808"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "-9223372036854775809".minutes // For input string: "-9223372036854775809"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "non-numeric strings".minutes
        }
    }

    @Test
    fun seconds() {
        // Given
        val text = "1"

        // When
        val second = text.seconds // PT1S

        // Then
        assertEquals(
            expected = Duration.ofSeconds(1),
            actual = second,
        )

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "9223372036854775808".seconds // For input string: "9223372036854775808"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "-9223372036854775809".seconds // For input string: "-9223372036854775809"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "non-numeric strings".seconds
        }
    }

    @Test
    fun milliseconds() {
        // Given
        val text = "1"

        // When
        val millisecond: Duration = text.milliseconds // PT0.001S

        // Then
        assertEquals(
            expected = Duration.ofMillis(1),
            actual = millisecond,
        )

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "9223372036854775808".milliseconds // For input string: "9223372036854775808"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "-9223372036854775809".milliseconds // For input string: "-9223372036854775809"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "non-numeric strings".milliseconds
        }
    }

    @Test
    fun microseconds() {
        // Given
        val text = "1"

        // When
        val microsecond: Duration = text.microseconds // PT0.000001S

        // Then
        assertEquals(
            expected = Duration.ofNanos(1_000),
            actual = microsecond,
        )
    }

    @Test
    fun nanoseconds() {
        // Given
        val text = "1"

        // When
        val nanosecond: Duration = text.nanoseconds // PT0.000000001S

        // Then
        assertEquals(
            expected = Duration.ofNanos(1),
            actual = nanosecond,
        )

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "9223372036854775808".nanoseconds // For input string: "9223372036854775808"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "-9223372036854775809".nanoseconds // For input string: "-9223372036854775809"
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "non-numeric strings".nanoseconds
        }
    }

    @Test
    fun toPeriod() {
        // Given

        // When
        val period: Period = "P1Y2M3W4D".toPeriod()

        // Then
        assertEquals(
            expected = Period.of(1, 2, 25),
            actual = period,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "PT20.345S".toPeriod() // Text cannot be parsed to a Period
        }
    }

    @Test
    fun toPeriodOrNull() {
        // Given

        // When
        val period: Period? = "P1Y2M3W4D".toPeriodOrNull()

        // Then
        assertEquals(
            expected = Period.of(1, 2, 25),
            actual = period,
        )

        // Fail cases
        assertNull("PT20.345S".toPeriodOrNull())
    }

    @Test
    fun toDuration() {
        // Given

        // When
        val duration: Duration = "P2DT3H4M".toDuration()

        // Then
        assertEquals(
            expected = Duration.ofDays(2).plusHours(3).plusMinutes(4),
            actual = duration,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "PT20.345".toDuration() // Text cannot be parsed to a Duration
        }
    }

    @Test
    fun toDurationOrNull() {
        // Given

        // When
        val duration: Duration? = "P2DT3H4M".toDurationOrNull()

        // Then
        assertEquals(
            expected = Duration.ofDays(2).plusHours(3).plusMinutes(4),
            actual = duration,
        )

        // Fail cases
        assertNull("PT20.345".toDurationOrNull())
    }

    @Test
    fun toDateTimeFormatter() {
        // Given

        // When
        val formatter: DateTimeFormatter = "yyyy-MM-dd".toDateTimeFormatter()

        // Then
        assertEquals(
            expected = DateTimeFormatter.ofPattern("yyyy-MM-dd").toString(),
            actual = formatter.toString(),
        )

        // Fail cases
        assertFailsWith(IllegalArgumentException::class) {
            "ABC".toDateTimeFormatter() // Unknown pattern letter: C
        }
    }

    @Test
    fun toDateTimeFormatterOrNull() {
        // Given

        // When
        val formatter: DateTimeFormatter? = "yyyy-MM-dd".toDateTimeFormatterOrNull()

        // Then
        assertEquals(
            expected = DateTimeFormatter.ofPattern("yyyy-MM-dd").toString(),
            actual = formatter.toString(),
        )

        // Then
        assertNull("ABC".toDateTimeFormatterOrNull())
    }

    @Test
    fun toYear() {
        // Given

        // When
        val actual: Year = "2022".toYear()

        // Then
        assertEquals(
            expected = Year.of(2022),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "22".toYear() // Text '22' could not be parsed at index 0
        }
    }

    @Test
    fun toYearWithString() {
        // Given

        // When
        val actual: Year = "22".toYear("yy")

        // Then
        assertEquals(
            expected = Year.of(2022),
            actual = actual,
        )

        assertFailsWith(IllegalArgumentException::class) {
            "22".toYear("ABC") // Unknown pattern letter: C
        }

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "2022".toYear("yy") // Text '2022' could not be parsed, unparsed text found at index 2
        }
    }

    @Test
    fun toYearWithDateTimeFormatter() {
        // Given
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yy")

        // When
        val actual: Year = "22".toYear(formatter)

        // Then
        assertEquals(
            expected = Year.of(2022),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "2022".toYear(formatter) // Text '2022' could not be parsed, unparsed text found at index 2
        }
    }

    @Test
    fun toYearOrNull() {
        // Given

        // When
        val actual: Year? = "2022".toYearOrNull()

        // Then
        assertEquals(
            expected = Year.of(2022),
            actual = actual,
        )

        // Fail cases
        assertNull("22".toYearOrNull())
    }

    @Test
    fun toYearOrNullWithString() {
        // Given

        // When
        val actual: Year? = "22".toYearOrNull("yy")

        // Then
        assertEquals(
            expected = Year.of(2022),
            actual = actual,
        )

        // Fail cases
        assertNull("22".toYearOrNull("ABC"))

        // Fail cases
        assertNull("2022".toYearOrNull("yy"))
    }

    @Test
    fun toYearOrNullWithDateTimeFormatter() {
        // Given
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yy")

        // When
        val actual: Year? = "22".toYearOrNull(formatter)

        // Then
        assertEquals(
            expected = Year.of(2022),
            actual = actual,
        )

        // Fail cases
        assertNull("2022".toYearOrNull(formatter))
    }

    @Test
    fun toMonth() {
        // Given
        val text = "1"

        // When
        val month: Month = text.toMonth()

        // Then
        assertEquals(
            expected = Month.JANUARY,
            actual = month,
        )

        // Fail cases
        assertFailsWith(DateTimeException::class) {
            "13".toMonth()
        }

        // Fail cases
        assertFailsWith(NumberFormatException::class) {
            "JAN".toMonth()
        }
    }

    @Test
    fun toMonthOrNull() {
        // Given
        val text = "1"

        // When
        val month: Month? = text.toMonthOrNull()

        // Then
        assertEquals(
            expected = Month.JANUARY,
            actual = month,
        )

        // Fail cases
        assertNull("13".toMonthOrNull())

        // Fail cases
        assertNull("JAN".toMonthOrNull())
    }

    @Test
    fun toYearMonth() {
        // Given

        // When
        val actual: YearMonth = "2022-01".toYearMonth()

        // Then
        assertEquals(
            expected = YearMonth.of(2022, 1),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "2022 01".toYearMonth() // Text '2022 01' could not be parsed at index 4
        }
    }

    @Test
    fun toYearMonthWithString() {
        // Given

        // When
        val actual: YearMonth = "22-01".toYearMonth("yy-MM")

        // Then
        assertEquals(
            expected = YearMonth.of(2022, 1),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(IllegalArgumentException::class) {
            "22-01".toYearMonth("ABC") // Unknown pattern letter: C
        }

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "2022-01".toYearMonth("yy-MM") // Text '2022-01' could not be parsed, unparsed text found at index 7
        }
    }

    @Test
    fun toYearMonthWithDateTimeFormatter() {
        // Given
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM")

        // When
        val actual: YearMonth = "22-01".toYearMonth(formatter)

        // Then
        assertEquals(
            expected = YearMonth.of(2022, 1),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "2022-01".toYearMonth(formatter) // Text '2022-01' could not be parsed, unparsed text found at index 7
        }
    }

    @Test
    fun toYearMonthOrNull() {
        // Given

        // When
        val actual: YearMonth? = "2022-01".toYearMonthOrNull()

        // Then
        assertEquals(
            expected = YearMonth.of(2022, 1),
            actual = actual,
        )

        // Fail cases
        assertNull("2022 01".toYearMonthOrNull())
    }

    @Test
    fun toYearMonthOrNullWithString() {
        // Given

        // When
        val actual: YearMonth? = "22-01".toYearMonthOrNull("yy-MM")

        // Then
        assertEquals(
            expected = YearMonth.of(2022, 1),
            actual = actual,
        )

        // Fail cases
        assertNull("22-01".toYearMonthOrNull("ABC"))

        // Fail cases
        assertNull("2022-01".toYearMonthOrNull("yy-MM"))
    }

    @Test
    fun toYearMonthOrNullWithDateTimeFormatter() {
        // Given
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM")

        // When
        val actual: YearMonth? = "22-01".toYearMonthOrNull(formatter)

        // Then
        assertEquals(
            expected = YearMonth.of(2022, 1),
            actual = actual,
        )

        // Fail cases
        assertNull("2022-01".toYearMonthOrNull(formatter))
    }

    @Test
    fun toMonthDay() {
        // Given

        // When
        val actual: MonthDay = "01-01".toMonthDay()

        // Then
        assertEquals(
            expected = MonthDay.of(1, 1),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "01 01".toMonthDay() // Text '01 01' could not be parsed at index 2
        }
    }

    @Test
    fun toMonthDayWithString() {
        // Given

        // When
        val actual: MonthDay = "01-01".toMonthDay("MM-dd")

        // Then
        assertEquals(
            expected = MonthDay.of(1, 1),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(IllegalArgumentException::class) {
            "01-01".toMonthDay("ABC") // Unknown pattern letter: C
        }

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "01 01".toMonthDay("MM-dd") // Text '01 01' could not be parsed, unparsed text found at index 2
        }
    }

    @Test
    fun toMonthDayWithDateTimeFormatter() {
        // Given
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd")

        // When
        val actual: MonthDay = "01-01".toMonthDay(formatter)

        // Then
        assertEquals(
            expected = MonthDay.of(1, 1),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "01 01".toMonthDay(formatter) // Text '01 01' could not be parsed, unparsed text found at index 2
        }
    }

    @Test
    fun toMonthDayOrNull() {
        // Given

        // When
        val actual: MonthDay? = "01-01".toMonthDayOrNull()

        // Then
        assertEquals(
            expected = MonthDay.of(1, 1),
            actual = actual,
        )

        // Fail cases
        assertNull("01 01".toMonthDayOrNull())
    }

    @Test
    fun toMonthDayOrNullWithString() {
        // Given

        // When
        val actual: MonthDay? = "01-01".toMonthDayOrNull("MM-dd")

        // Then
        assertEquals(
            expected = MonthDay.of(1, 1),
            actual = actual,
        )

        // Fail cases
        assertNull("01-01".toMonthDayOrNull("ABC"))

        // Fail cases
        assertNull("01 01".toMonthDayOrNull("MM-dd"))
    }

    @Test
    fun toMonthDayOrNullWithDateTimeFormatter() {
        // Given
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd")

        // When
        val actual: MonthDay? = "01-01".toMonthDayOrNull(formatter)

        // Then
        assertEquals(
            expected = MonthDay.of(1, 1),
            actual = actual,
        )

        // Fail cases
        assertNull("01 01".toMonthDayOrNull(formatter))
    }

    @Test
    fun toLocalDate() {
        // Given

        // When
        val actual: LocalDate = "2022-01-01".toLocalDate()

        // Then
        assertEquals(
            expected = LocalDate.of(2022, 1, 1),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "22-01-01".toLocalDate() // Text '22-01-01' could not be parsed at index 0
        }
    }

    @Test
    fun toLocalDateWithString() {
        // Given

        // When
        val actual: LocalDate = "22-01-01".toLocalDate("yy-MM-dd")

        // Then
        assertEquals(
            expected = LocalDate.of(2022, 1, 1),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(IllegalArgumentException::class) {
            "22-01-01".toLocalDate("ABC") // Unknown pattern letter: C
        }

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "2022-01-01".toLocalDate("yy-MM-dd") // Text '2022-01-01' could not be parsed, unparsed text found at index 7
        }
    }

    @Test
    fun toLocalDateWithDateTimeFormatter() {
        // Given
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM-dd")

        // When
        val actual: LocalDate = "22-01-01".toLocalDate(formatter)

        // Then
        assertEquals(
            expected = LocalDate.of(2022, 1, 1),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "2022-01-01".toLocalDate(formatter) // Text '2022-01-01' could not be parsed, unparsed text found at index 7
        }
    }

    @Test
    fun toLocalDateOrNull() {
        // Given

        // When
        val actual: LocalDate? = "2022-01-01".toLocalDateOrNull()

        // Then
        assertEquals(
            expected = LocalDate.of(2022, 1, 1),
            actual = actual,
        )

        // Fail cases
        assertNull("20220101".toLocalDateOrNull())
    }

    @Test
    fun toLocalDateOrNullWithString() {
        // Given

        // When
        val actual: LocalDate? = "22-01-01".toLocalDateOrNull("yy-MM-dd")

        // Then
        assertEquals(
            expected = LocalDate.of(2022, 1, 1),
            actual = actual,
        )

        // Fail cases
        assertNull("22-01-01".toLocalDateOrNull("ABC"))

        // Fail cases
        assertNull("2022-01-01".toLocalDateOrNull("yy-MM-dd"))
    }

    @Test
    fun toLocalDateOrNullWithDateTimeFormatter() {
        // Given
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM-dd")

        // When
        val actual: LocalDate? = "22-01-01".toLocalDateOrNull(formatter)

        // Then
        assertEquals(
            expected = LocalDate.of(2022, 1, 1),
            actual = actual,
        )

        // Fail cases
        assertNull("2022-01-01".toLocalDateOrNull(formatter))
    }

    @Test
    fun toLocalTime() {
        // Given

        // When
        val actual: LocalTime = "00:00:00".toLocalTime()

        // Then
        assertEquals(
            expected = LocalTime.of(0, 0, 0),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "000000".toLocalTime() // Text '00:00' could not be parsed, unparsed text found at index 5
        }
    }

    @Test
    fun toLocalTimeWithString() {
        // Given

        // When
        val actual: LocalTime = "00:00".toLocalTime("HH:mm")

        // Then
        assertEquals(
            expected = LocalTime.of(0, 0),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "00:00:00".toLocalTime("HH:mm") // Text '00:00:00' could not be parsed, unparsed text found at index 5
        }

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "00:00".toLocalTime("HH:mm:ss") // Text '00:00' could not be parsed, unparsed text found at index 5
        }
    }

    @Test
    fun toLocalTimeWithDateTimeFormatter() {
        // Given
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")

        // When
        val actual: LocalTime = "00:00".toLocalTime(formatter)

        // Then
        assertEquals(
            expected = LocalTime.of(0, 0),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "00:00:00".toLocalTime(formatter) // Text '00:00:00' could not be parsed, unparsed text found at index 5
        }
    }

    @Test
    fun toLocalTimeOrNull() {
        // Given

        // When
        val actual: LocalTime? = "00:00:00".toLocalTimeOrNull()

        // Then
        assertEquals(
            expected = LocalTime.of(0, 0, 0),
            actual = actual,
        )

        // Fail cases
        assertNull("000000".toLocalTimeOrNull())
    }

    @Test
    fun toLocalTimeOrNullWithString() {
        // Given

        // When
        val actual: LocalTime? = "00:00".toLocalTimeOrNull("HH:mm")

        // Then
        assertEquals(
            expected = LocalTime.of(0, 0),
            actual = actual,
        )

        // Fail cases
        assertNull("00:00:00".toLocalTimeOrNull("ABC"))

        // Fail cases
        assertNull("00:00".toLocalTimeOrNull("HH:mm:ss"))
    }

    @Test
    fun toLocalTimeOrNullWithDateTimeFormatter() {
        // Given
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")

        // When
        val actual: LocalTime? = "00:00".toLocalTimeOrNull(formatter)

        // Then
        assertEquals(
            expected = LocalTime.of(0, 0),
            actual = actual,
        )

        // Fail cases
        assertNull("00:00:00".toLocalTimeOrNull(formatter))
    }

    @Test
    fun toOffsetTime() {
        // Given
        val text = "00:00:00+09:00"

        // When
        val offsetTime: OffsetTime = text.toOffsetTime()

        // Then
        assertEquals(
            expected = OffsetTime.of(0, 0, 0, 0, ZoneOffset.ofHours(9)),
            actual = offsetTime,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "00:00:00".toOffsetTime()
        }
    }

    @Test
    fun toOffsetTimeWithString() {
        // Given
        val text = "00:00:00 +09:00"

        // When
        val offsetTime: OffsetTime = text.toOffsetTime("HH:mm:ss XXX")

        // Then
        assertEquals(
            expected = OffsetTime.of(0, 0, 0, 0, ZoneOffset.ofHours(9)),
            actual = offsetTime,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "00:00:00".toOffsetTime("HH:mm:ss XXX")
        }

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "00:00:00 +09:00".toOffsetTime("HH:mm:ss")
        }
    }

    @Test
    fun toOffsetTimeWithDateTimeFormatter() {
        // Given
        val text = "00:00:00 +09:00"
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss XXX")

        // When
        val offsetTime: OffsetTime = text.toOffsetTime(formatter)

        // Then
        assertEquals(
            expected = OffsetTime.of(0, 0, 0, 0, ZoneOffset.ofHours(9)),
            actual = offsetTime,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "00:00:00".toOffsetTime(formatter)
        }
    }

    @Test
    fun toOffsetTimeOrNull() {
        // Given
        val text = "00:00:00+09:00"

        // When
        val offsetTime: OffsetTime? = text.toOffsetTimeOrNull()

        // Then
        assertEquals(
            expected = OffsetTime.of(0, 0, 0, 0, ZoneOffset.ofHours(9)),
            actual = offsetTime,
        )

        // Fail cases
        assertNull("00:00:00".toOffsetTimeOrNull())
    }

    @Test
    fun toOffsetTimeOrNullWithString() {
        // Given
        val text = "00:00:00 +09:00"

        // When
        val offsetTime: OffsetTime? = text.toOffsetTimeOrNull("HH:mm:ss XXX")

        // Then
        assertEquals(
            expected = OffsetTime.of(0, 0, 0, 0, ZoneOffset.ofHours(9)),
            actual = offsetTime,
        )

        // Fail cases
        assertNull("00:00:00".toOffsetTimeOrNull("HH:mm:ss XXX"))

        // Fail cases
        assertNull("00:00:00 +09:00".toOffsetTimeOrNull("HH:mm:ss"))
    }

    @Test
    fun toOffsetTimeOrNullWithDateTimeFormatter() {
        // Given
        val text = "00:00:00 +09:00"
        val formatter = DateTimeFormatter.ofPattern("HH:mm:ss XXX")

        // When
        val offsetTime: OffsetTime? = text.toOffsetTimeOrNull(formatter)

        // Then
        assertEquals(
            expected = OffsetTime.of(0, 0, 0, 0, ZoneOffset.ofHours(9)),
            actual = offsetTime,
        )

        // Fail cases
        assertNull("00:00:00".toOffsetTimeOrNull(formatter))
    }

    @Test
    fun toLocalDateTime() {
        // Given
        val text = "2022-01-01 00:00"

        // When
        val actual: LocalDateTime = text.toLocalDateTime()

        // Then
        assertEquals(
            expected = LocalDateTime.of(2022, 1, 1, 0, 0),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "2022-01-01T00".toLocalDateTime()
        }
    }

    @Test
    fun toLocalDateTimeWithPattern() {
        // Given
        val text = "20220101 00:00"

        // When
        val actual: LocalDateTime = text.toLocalDateTime("yyyyMMdd HH:mm")

        // Then
        assertEquals(
            expected = LocalDateTime.of(2022, 1, 1, 0, 0),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(IllegalArgumentException::class) {
            "20220101 00:00".toLocalDateTime("ABC") // Unknown pattern letter: C
        }

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "2022-01-01T00:00".toLocalDateTime("yyyyMMdd HH:mm") // Text '2022-01-01T00:00' could not be parsed at index 4
        }
    }

    @Test
    fun toLocalDateTimeWithDateTimeFormatter() {
        // Given
        val text = "20220101 00:00"
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm")

        // When
        val actual: LocalDateTime = text.toLocalDateTime(formatter)

        // Then
        assertEquals(
            expected = LocalDateTime.of(2022, 1, 1, 0, 0),
            actual = actual,
        )

        // Fail cases
        assertFailsWith(DateTimeParseException::class) {
            "2022-01-01T00:00".toLocalDateTime(formatter) // Text '2022-01-01T00:00' could not be parsed at index 4
        }
    }

    @Test
    fun toLocalDateTimeOrNull() {
        // Given
        val text = "2022-01-01T00:00"

        // When
        val actual: LocalDateTime? = text.toLocalDateTimeOrNull()

        // Then
        assertEquals(
            expected = LocalDateTime.of(2022, 1, 1, 0, 0),
            actual = actual,
        )

        // Fail cases
        assertNull("20220101".toLocalDateTimeOrNull())
    }

    @Test
    fun toLocalDateTimeOrNullWithPattern() {
        // Given
        val text = "22-01-01 00:00"

        // When
        val actual: LocalDateTime? = text.toLocalDateTimeOrNull("yy-MM-dd HH:mm")

        // Then
        assertEquals(
            expected = LocalDateTime.of(2022, 1, 1, 0, 0),
            actual = actual,
        )

        // Fail cases
        assertNull("2022-01-01T00:00".toLocalDateTimeOrNull("ABC"))

        // Fail cases
        assertNull("2022-01-01T00:00".toLocalDateTimeOrNull("yy-MM-dd HH:mm"))
    }

    @Test
    fun toLocalDateTimeOrNullWithDateTimeFormatter() {
        // Given
        val text = "22-01-01 00:00"
        val formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm")

        // When
        val actual: LocalDateTime? = text.toLocalDateTimeOrNull(formatter)

        // Then
        assertEquals(
            expected = LocalDateTime.of(2022, 1, 1, 0, 0),
            actual = actual,
        )

        // Fail cases
        assertNull("2022-01-01T00:00".toLocalDateTimeOrNull(formatter))
    }

    @Test
    fun toOffsetDateTime() {
        // Given
        val text = "2022-01-01T00:00:00+09:00"

        // When
        val offsetDateTime = text.toOffsetDateTime()

        // Then
        assertEquals(
            expected = OffsetDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneOffset.ofHours(9)),
            actual = offsetDateTime,
        )
    }

    @Test
    fun toOffsetDateTimeWithPattern() {
        // Given
        val text = "22-01-01T00:00:00+09:00"

        // When
        val offsetDateTime = text.toOffsetDateTime("yy-MM-dd'T'HH:mm:ssXXX")

        // Then
        assertEquals(
            expected = OffsetDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneOffset.ofHours(9)),
            actual = offsetDateTime,
        )
    }

    @Test
    fun toOffsetDateTimeWithDateTimeFormatter() {
        // Given
        val text = "22-01-01T00:00:00+09:00"
        val formatter = DateTimeFormatter.ofPattern("yy-MM-dd'T'HH:mm:ssXXX")

        // When
        val offsetDateTime = text.toOffsetDateTime(formatter)

        // Then
        assertEquals(
            expected = OffsetDateTime.of(2022, 1, 1, 0, 0, 0, 0, ZoneOffset.ofHours(9)),
            actual = offsetDateTime,
        )
    }

    @Test
    fun toOffsetDateTimeOrNull() {
        // Given
        val text = "22-01-01T00:00:00+09:00"

        // When
        val offsetDateTime: OffsetDateTime? = text.toOffsetDateTimeOrNull()

        // Then
        assertEquals(
            expected = null,
            actual = offsetDateTime,
        )
    }

    @Test
    fun toOffsetDateTimeOrNullWithPattern() {
        // Given
        val text = "2022-01-01T00:00:00+09:00"

        // When
        val offsetDateTime: OffsetDateTime? = text.toOffsetDateTimeOrNull("yy-MM-dd'T'HH:mm:ssXXX")

        // Then
        assertEquals(
            expected = null,
            actual = offsetDateTime,
        )
    }

    @Test
    fun toOffsetDateTimeOrNullWithDateTimeFormatter() {
        // Given
        val text = "2022-01-01T00:00:00+09:00"
        val formatter = DateTimeFormatter.ofPattern("yy-MM-dd'T'HH:mm:ssXXX")

        // When
        val offsetDateTime: OffsetDateTime? = text.toOffsetDateTimeOrNull(formatter)

        // Then
        assertEquals(
            expected = null,
            actual = offsetDateTime,
        )
    }

    @Test
    fun toZoneId() {
        // Given
        val text = "UTC+09:00"

        // When
        val zoneId: ZoneId = text.toZoneId()

        // Then
        assertEquals(
            expected = ZoneId.of("UTC+09:00"),
            actual = zoneId,
        )
    }

    @Test
    fun toZoneOffset() {
        // Given
        val text = "+09:00"

        // When
        val zoneOffset: ZoneOffset = text.toZoneOffset()

        // Then
        assertEquals(
            expected = ZoneOffset.ofHours(9),
            actual = zoneOffset,
        )
    }
}