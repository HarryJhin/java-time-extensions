package io.github.harryjhin.java.time.extension

import java.time.format.DateTimeFormatter
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class DateTimeFormatterExtensionsTest {

    @Test
    fun toDateTimeFormatterReturnsSingleton() {
        // Given
        val formatter1: DateTimeFormatter = "yyyy-MM-dd".toDateTimeFormatter()
        val formatter2: DateTimeFormatter = "yyyy-MM-dd".toDateTimeFormatter()

        assertEquals(
            expected = formatter1,
            actual = formatter2,
        )

        assertNotEquals(
            illegal = DateTimeFormatter.ofPattern("yyyyMMdd"),
            actual = formatter1,
        )
    }
}