package io.github.harryjhin.java.time.extension

import kotlin.test.Test
import kotlin.test.assertFails

class LongExtensionsTest {

    @Test
    fun toIntExact() {
        // Given
        val overflow: Long = Int.MAX_VALUE + 1L

        // When
        assertFails {
            overflow.toIntExact()
        }
    }
}