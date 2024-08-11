package blog.jinhyun.java.time.extension.date

import java.time.LocalDate
import java.time.YearMonth

/**
 * [LocalDate]의 연도와 월 정보를 [YearMonth]로 변환합니다.
 *
 * @receiver [LocalDate] 객체
 * @return [YearMonth] 객체
 * @sample blog.jinhyun.java.time.extension.JtLocalDateExtensionsTest.toYearMonth
 */
fun LocalDate.toYearMonth(): YearMonth = YearMonth.of(year, month)