package io.github.harryjhin.java.time.extension

import java.time.ZoneOffset
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
}