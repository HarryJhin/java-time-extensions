package io.github.harryjhin.java.time.extension

import java.time.Period
import java.time.Year

/**
 * [Year]를 연(Year) 단위의 [Period]로 변환합니다.
 *
 * ```kotlin
 * val year: Period = Year.of(2022).years // P2022Y
 * ```
 *
 * @return 지정된 연 수를 나타내는 [Period] 인스턴스
 * @since 0.3.0
 */
val Year.years: Period
    get() = this.value.years