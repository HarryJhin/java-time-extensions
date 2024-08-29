package io.github.harryjhin.java.time.extension

import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.Period
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class LongExtensionsTest {

    @Test
    fun years() {
        // Given
        val year = 2022L

        // When
        val actual: Period = year.years // P2022Y

        // Then
        assertEquals(
            expected = Period.ofYears(2022),
            actual = actual,
        )

        // Fail case
        assertFailsWith(ArithmeticException::class) {
            (Int.MAX_VALUE + 1L).years // long overflow: 2147483648
        }

        // Fail case
        assertFailsWith(ArithmeticException::class) {
            (Int.MIN_VALUE - 1L).years // long underflow: -2147483649
        }
    }

    @Test
    fun months() {
        // Given
        val month = 1L

        // When
        val actual: Period = month.months // P1M

        // Then
        assertEquals(
            expected = Period.ofMonths(1),
            actual = actual,
        )

        // Fail case
        assertFailsWith(ArithmeticException::class) {
            (Int.MAX_VALUE + 1L).months // long overflow: long overflow: 2147483648
        }

        // Fail case
        assertFailsWith(ArithmeticException::class) {
            (Int.MIN_VALUE - 1L).months // long underflow: -2147483649
        }
    }

    @Test
    fun days() {
        // Given
        val day = 1L

        // When
        val actual: Period = day.days // P1D

        // Then
        assertEquals(
            expected = Period.ofDays(1),
            actual = actual,
        )

        // Fail case
        assertFailsWith(ArithmeticException::class) {
            (Int.MAX_VALUE + 1L).days // long overflow: long overflow: 2147483648
        }

        // Fail case
        assertFailsWith(ArithmeticException::class) {
            (Int.MIN_VALUE - 1L).days // long underflow: -2147483649
        }
    }

    @Test
    fun hours() {
        // Given
        val hour = 1L

        // When
        val actual: Duration = hour.hours // PT1H

        // Then
        assertEquals(
            expected = Duration.ofHours(1),
            actual = actual,
        )
    }

    @Test
    fun minutes() {
        // Given
        val minute = 1L

        // When
        val actual: Duration = minute.minutes // PT1M

        // Then
        assertEquals(
            expected = Duration.ofMinutes(1),
            actual = actual,
        )
    }

    @Test
    fun seconds() {
        // Given
        val second = 1L

        // When
        val actual: Duration = second.seconds // PT1S

        // Then
        assertEquals(
            expected = Duration.ofSeconds(1),
            actual = actual,
        )
    }

    @Test
    fun milliseconds() {
        // Given
        val millisecond = 1L

        // When
        val actual: Duration = millisecond.milliseconds // PT0.001S

        // Then
        assertEquals(
            expected = Duration.ofMillis(1),
            actual = actual,
        )
    }

    @Test
    fun microseconds() {
        // Given
        val microsecond = 1L

        // When
        val actual: Duration = microsecond.microseconds // PT0.000001S

        // Then
        assertEquals(
            expected = Duration.ofNanos(1_000),
            actual = actual,
        )
    }

    @Test
    fun nanoseconds() {
        // Given
        val nanosecond = 1L

        // When
        val actual: Duration = nanosecond.nanoseconds // PT0.000000001S

        // Then
        assertEquals(
            expected = Duration.ofNanos(1),
            actual = actual,
        )
    }

    @Test
    fun toIntExact() {
        // Given
        val overflow: Long = Int.MAX_VALUE + 1L

        // When
        assertFailsWith(ArithmeticException::class) {
            overflow.toIntExact() // long overflow: 2147483648
        }

        // Given
        val underflow: Long = Int.MIN_VALUE - 1L

        // When
        assertFailsWith(ArithmeticException::class) {
            underflow.toIntExact() // long overflow: -2147483649
        }
    }

    @Test
    fun toZoneOffset() {
        // Given
        val second = 9L * 60 * 60

        // When
        val zoneOffset: ZoneOffset = second.toZoneOffset()

        // Then
        assertEquals(
            expected = ZoneOffset.ofHours(9),
            actual = zoneOffset,
        )
    }

    @Test
    fun toLocalDateTime() {
        // Given
        val epochMilli = System.currentTimeMillis()

        // When
        val dateTime: LocalDateTime = epochMilli.toLocalDateTime()

        // Then
        assertEquals(
            expected = Instant.ofEpochMilli(epochMilli).atZone(ZoneId.systemDefault()).toLocalDateTime(),
            actual = dateTime,
        )
    }

    @Test
    fun toZonedDateTime() {
        // Given
        val epochMilli = System.currentTimeMillis()

        // When
        val zonedDateTime: ZonedDateTime = epochMilli.toZonedDateTime()

        // Then
        assertEquals(
            expected = Instant.ofEpochMilli(epochMilli).atZone(ZoneId.systemDefault()),
            actual = zonedDateTime,
        )
    }

    @Test
    fun toZonedDateTimeWithString() {
        // Given
        val epochMilli = 0L

        // When
        val zonedDateTime: ZonedDateTime = epochMilli.toZonedDateTime("Asia/Seoul")

        // Then
        assertEquals(
            expected = "1970-01-01T09:00+09:00[Asia/Seoul]",
            actual = zonedDateTime.toString(),
        )
    }
}