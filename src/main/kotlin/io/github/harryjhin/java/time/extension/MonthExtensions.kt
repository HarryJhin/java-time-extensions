package io.github.harryjhin.java.time.extension

import java.time.Month
import java.time.Period

/**
 * [Month]를 월(month) 단위의 [Period]로 변환합니다.
 *
 * 예시:
 * ```kotlin
 * val month: Period = Month.JANUARY.months // P1M
 * ```
 *
 * @return 지정된 월 수를 나타내는 [Period] 인스턴스
 * @since 0.3.0
 */
val Month.months: Period
    get() = this.value.months