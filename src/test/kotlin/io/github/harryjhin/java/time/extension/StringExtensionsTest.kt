package io.github.harryjhin.java.time.extension

import java.time.DateTimeException
import java.time.LocalDateTime
import java.time.Month
import java.time.OffsetDateTime
import java.time.OffsetTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

class StringExtensionsTest {

    @Test
    fun years() {
        // Given
        val text = "2022"

        // When
        val year = text.years

        // Then
        assertEquals(
            expected = "P2022Y",
            actual = year.toString(),
        )
    }

    @Test
    fun months() {
        // Given
        val text = "1"

        // When
        val month = text.months

        // Then
        assertEquals(
            expected = "P1M",
            actual = month.toString(),
        )
    }

    @Test
    fun days() {
        // Given
        val text = "1"

        // When
        val day = text.days

        // Then
        assertEquals(
            expected = "P1D",
            actual = day.toString(),
        )
    }

    @Test
    fun hours() {
        // Given
        val text = "1"

        // When
        val hour = text.hours

        // Then
        assertEquals(
            expected = "PT1H",
            actual = hour.toString(),
        )
    }

    @Test
    fun minutes() {
        // Given
        val text = "1"

        // When
        val minute = text.minutes

        // Then
        assertEquals(
            expected = "PT1M",
            actual = minute.toString(),
        )
    }

    @Test
    fun seconds() {
        // Given
        val text = "1"

        // When
        val second = text.seconds

        // Then
        assertEquals(
            expected = "PT1S",
            actual = second.toString(),
        )
    }

    @Test
    fun milliseconds() {
        // Given
        val text = "1"

        // When
        val millisecond = text.milliseconds

        // Then
        assertEquals(
            expected = "PT0.001S",
            actual = millisecond.toString(),
        )
    }

    @Test
    fun microseconds() {
        // Given
        val text = "1"

        // When
        val microsecond = text.microseconds

        // Then
        assertEquals(
            expected = "PT0.000001S",
            actual = microsecond.toString(),
        )
    }

    @Test
    fun nanoseconds() {
        // Given
        val text = "1"

        // When
        val nanosecond = text.nanoseconds

        // Then
        assertEquals(
            expected = "PT0.000000001S",
            actual = nanosecond.toString(),
        )
    }

    @Test
    fun toYear1() {
        // Given
        val text = "2022"

        // When
        val year = text.toYear()

        // Then
        assertEquals(
            expected = "2022".toYear(),
            actual = year,
        )
        assertFails {
            "2022-01".toYear()
        }
    }

    @Test
    fun toYear2() {
        // Given
        val text = "22"

        // When
        val year = text.toYear("yy")

        // Then
        assertEquals(
            expected = "2022".toYear(),
            actual = year,
        )
    }

    @Test
    fun toYear3() {
        // Given
        val text = "22"

        // When

        // Then
        assertFails {
            text.toYear()
        }
    }

    @Test
    fun toYearOrNull1() {
        // Given
        val text = "22"

        // When
        val year = text.toYearOrNull()

        // Then
        assertEquals(
            expected = null,
            actual = year,
        )
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
        val text = "2022-01"

        // When
        val yearMonth = text.toYearMonth()

        // Then
        assertEquals(
            expected = "2022-01".toYearMonth(),
            actual = yearMonth,
        )
        assertFails {
            "2022-01-01".toYearMonth()
        }
    }

    @Test
    fun toLocalDate() {
        // Given
        val text = "2022-01-01"

        // When
        val date = text.toLocalDate()

        // Then
        assertEquals(
            expected = "2022-01-01".toLocalDate(),
            actual = date,
        )
    }

    @Test
    fun toLocalDateOrNull() {
        // Given
        val text = "2022-01-01"

        // When
        val date = text.toLocalDateOrNull()

        // Then
        assertEquals(
            expected = "2022-01-01".toLocalDate(),
            actual = date,
        )
    }

    @Test
    fun toLocalDateOrNullReturnsNull() {
        // Given
        val text = "00:00:00"

        // When
        val date = text.toLocalDateOrNull()

        // Then
        assertEquals(
            expected = null,
            actual = date,
        )
    }

    @Test
    fun toLocalTime() {
        // Given
        val text = "00:00:00"

        // When
        val time = text.toLocalTime()

        // Then
        assertEquals(
            expected = "00:00:00".toLocalTime(),
            actual = time,
        )
    }

    @Test
    fun toLocalTimeOrNull() {
        // Given
        val text = "00:00:00"

        // When
        val time = text.toLocalTimeOrNull()

        // Then
        assertEquals(
            expected = "00:00:00".toLocalTime(),
            actual = time,
        )
    }

    @Test
    fun toLocalTimeOrNullReturnsNull() {
        // Given
        val text = "2022-01-01"

        // When
        val time = text.toLocalTimeOrNull()

        // Then
        assertEquals(
            expected = null,
            actual = time,
        )
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
        val text = "2022-01-01T00:00:00"

        // When
        val dateTime: LocalDateTime = text.toLocalDateTime()

        // Then
        assertEquals(
            expected = LocalDateTime.of(2022, 1, 1, 0, 0, 0),
            actual = dateTime,
        )
    }

    @Test
    fun toLocalDateTimeWithPattern() {
        // Given
        val text = "2022-01-01T00:00"

        // When
        val dateTime: LocalDateTime = text.toLocalDateTime("yyyy-MM-dd'T'HH:mm")

        // Then
        assertEquals(
            expected = LocalDateTime.of(2022, 1, 1, 0, 0),
            actual = dateTime,
        )
    }

    @Test
    fun toLocalDateTimeWithDateTimeFormatter() {
        // Given
        val text = "2022-01-01T00:00"

        // When
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
        val dateTime: LocalDateTime = text.toLocalDateTime(formatter)

        // Then
        assertEquals(
            expected = LocalDateTime.of(2022, 1, 1, 0, 0),
            actual = dateTime,
        )
    }

    @Test
    fun toLocalDateTimeOrNull() {
        // Given
        val text = "2022-01-01T00:00"

        // When
        val dateTime: LocalDateTime? = text.toLocalDateTimeOrNull()

        // Then
        assertEquals(
            expected = null,
            actual = dateTime,
        )
    }

    @Test
    fun toLocalDateTimeOrNullWithPattern() {
        // Given
        val text = "2022-01-01T00:00"

        // When
        val dateTime: LocalDateTime? = text.toLocalDateTimeOrNull("yy-MM-dd'T'HH:mm")

        // Then
        assertEquals(
            expected = null,
            actual = dateTime,
        )
    }

    @Test
    fun toLocalDateTimeOrNullWithDateTimeFormatter() {
        // Given
        val text = "2022-01-01T00:00"

        // When
        val formatter = DateTimeFormatter.ofPattern("yy-MM-dd'T'HH:mm")
        val dateTime: LocalDateTime? = text.toLocalDateTimeOrNull(formatter)

        // Then
        assertEquals(
            expected = null,
            actual = dateTime,
        )
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