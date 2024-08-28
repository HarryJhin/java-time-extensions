package io.github.harryjhin.java.time.extension

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class LongExtensionsTest {

    @Test
    fun overflowOoIntExact() {
        // Given
        val overflow: Long = Int.MAX_VALUE + 1L

        // When
        assertFails {
            overflow.toIntExact()
        }
    }

    @Test
    fun underflowOoIntExact() {
        // Given
        val underflow: Long = Int.MIN_VALUE - 1L

        // When
        assertFails {
            underflow.toIntExact()
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