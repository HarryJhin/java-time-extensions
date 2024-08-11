package blog.jinhyun.java.time.extension

import java.time.LocalDate
import java.time.YearMonth
import kotlin.test.Test
import kotlin.test.assertEquals

class JtLocalDateExtensionsTest {

    @Test
    fun toYearMonth() {
        // Given
        val date = LocalDate.of(2022, 1, 1)

        // When
        val yearMonth = date.toYearMonth()

        // Then
        assertEquals(
            actual = yearMonth,
            expected = YearMonth.of(2022, 1),
        )
    }
}