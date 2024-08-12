package io.github.harryjhin.java.time.extension

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.test.Test
import kotlin.test.assertEquals

class JavaTimeDisplayTest {

    @Test
    fun displayLocalDate() {
        // Given
        val date = LocalDate.of(2022, 1, 1)

        // When
        val actual = JavaTimeDisplay.format(date)

        // Then
        assertEquals(
            actual = actual,
            expected = "2022년 1월 1일 (토)",
        )
    }

    @Test
    fun displayLocalTime() {
        // Given
        val time = LocalTime.of(0, 0, 0)

        // When
        val actual = JavaTimeDisplay.format(time)

        // Then
        assertEquals(
            actual = actual,
            expected = "0시 0분 0초",
        )
    }

    @Test
    fun displayLocalDateTime() {
        // Given
        val dateTime = LocalDateTime.of(2022, 1, 1, 0, 0, 0)

        // When
        val actual = JavaTimeDisplay.format(dateTime)

        // Then
        assertEquals(
            actual = actual,
            expected = "2022년 1월 1일 (토) 0시 0분 0초",
        )
    }

    @Test
    fun configureJavaTimeDisplay() {
        // Given
        val javaTimeDisplay = JavaTimeDisplay {
            dateTimePattern = "yyyy-MM-dd'T'HH:mm:ss"
        }
        val dateTime = LocalDateTime.of(2022, 1, 1, 0, 0, 0)

        // When
        val actual = javaTimeDisplay.format(dateTime)

        // Then
        assertEquals(
            actual = actual,
            expected = "2022-01-01T00:00:00",
        )
    }
}