package blog.jinhyun.java.time

import java.time.LocalDate
import java.time.YearMonth

/**
 * [LocalDate]의 연도와 월 정보를 [YearMonth]로 변환합니다.
 *
 * ```kotlin
 * val date = LocalDate.of(2022, 1, 1)
 * val yearMonth = date.toYearMonth()
 * println(yearMonth) // 2022-01
 * ```
 *
 * @receiver [LocalDate] 객체
 * @return [YearMonth] 객체
 */
fun LocalDate.toYearMonth(): YearMonth = YearMonth.of(year, month)
