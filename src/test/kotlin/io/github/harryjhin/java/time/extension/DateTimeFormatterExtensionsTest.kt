package io.github.harryjhin.java.time.extension

import java.time.format.DateTimeFormatter
import kotlin.test.Test
import kotlin.test.assertFails
import kotlin.test.assertNull
import kotlin.test.assertTrue

class DateTimeFormatterExtensionsTest {

    @Test
    fun stringToDateTimeFormatter() {
        // Given
        val formatter: DateTimeFormatter =
            "yyyy-MM-dd".toDateTimeFormatter() // Value(YearOfEra,4,19,EXCEEDS_PAD)'-'Value(MonthOfYear,2)'-'Value(DayOfMonth,2)

        // Then
        assertTrue {
            formatter.toString() == DateTimeFormatter.ofPattern("yyyy-MM-dd").toString()
        }
    }

    @Test
    fun stringToDateTimeFormatterFail() {
        // Given

        // When

        // Then
        assertFails {
            "T".toDateTimeFormatter()
        }
    }

    @Test
    fun stringToDateTimeFormatterOrNull() {
        // Given
        val formatter: DateTimeFormatter? = "T".toDateTimeFormatterOrNull() // null

        // Then
        assertNull(formatter)
    }
}