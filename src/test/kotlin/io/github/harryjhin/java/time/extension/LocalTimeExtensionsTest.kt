package io.github.harryjhin.java.time.extension

import kotlin.test.Test
import kotlin.test.assertEquals

class LocalTimeExtensionsTest {

    @Test
    fun plus() {
        // Given
        val time = "00:00:00".toLocalTime()

        // When
        val plusOneHour = time + 1.hours.amounts
        val plusOneHourOneMinuteOneSecond = time + "01:01:01".toLocalTime().amounts

        // Then
        assertEquals(
            expected = "01:00:00".toLocalTime(),
            actual = plusOneHour,
        )
        assertEquals(
            expected = "01:01:01".toLocalTime(),
            actual = plusOneHourOneMinuteOneSecond,
        )
    }
}