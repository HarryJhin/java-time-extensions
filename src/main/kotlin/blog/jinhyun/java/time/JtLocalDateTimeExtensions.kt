package blog.jinhyun.java.time

import java.time.LocalDateTime
import java.time.YearMonth

/**
 * [LocalDateTime]의 연도와 월 정보를 [YearMonth]로 변환합니다.
 *
 * ```kotlin
 * val dateTime = LocalDateTime.of(2022, 1, 1, 0, 0)
 * val yearMonth = dateTime.toYearMonth()
 * println(yearMonth) // 2022-01
 * ```
 *
 * @receiver [LocalDateTime] 객체
 * @return [YearMonth] 객체
 */
fun LocalDateTime.toYearMonth() = YearMonth.of(year, month)
