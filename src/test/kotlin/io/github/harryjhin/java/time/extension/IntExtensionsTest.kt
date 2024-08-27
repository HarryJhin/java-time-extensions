package io.github.harryjhin.java.time.extension

import kotlin.test.Test
import kotlin.test.assertEquals

class IntExtensionsTest {

    @Test
    fun toZoneOffset() {
        // Given
        val second = 9 * 60 * 60

        // When
        val zoneOffset = second.toZoneOffset()

        // Then
        assertEquals(
            expected = "+09:00",
            actual = zoneOffset.toString()
        )
    }
}