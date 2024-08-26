package io.github.harryjhin.java.time.extension

import kotlin.test.Test
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
}