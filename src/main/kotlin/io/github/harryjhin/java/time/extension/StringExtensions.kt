package io.github.harryjhin.java.time.extension

import java.time.DateTimeException
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Month
import java.time.MonthDay
import java.time.OffsetDateTime
import java.time.OffsetTime
import java.time.Period
import java.time.Year
import java.time.YearMonth
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

/**
 * [String]을 연도(`year`)로 해석하고 [Period]로 변환합니다.
 *
 * @return 지정된 연 기간을 나타내는 [Period] 인스턴스
 * @throws NumberFormatException [String]이 [Int]의 범위를 벗어난 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.years
 */
val String.years: Period
    get() = this.toInt().years

/**
 * [String]을 월(`month`)로 해석하고 [Period]로 변환합니다.
 *
 * @return 지정된 월 기간을 나타내는 [Period] 인스턴스
 * @throws NumberFormatException [String]이 [Int]의 범위를 벗어난 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.months
 */
val String.months: Period
    get() = this.toInt().months

/**
 * [String]을 일(`day`)로 해석하고 [Period]로 변환합니다.
 *
 * @return 지정된 일 기간을 나타내는 [Period] 인스턴스
 * @throws NumberFormatException [String]이 [Int]의 범위를 벗어난 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.days
 */
val String.days: Period
    get() = this.toInt().days

/**
 * [String]을 시(`hour`)로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 시 기간을 나타내는 [Duration] 인스턴스
 * @throws NumberFormatException [String]이 [Long]의 범위를 벗어난 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.hours
 */
val String.hours: Duration
    get() = this.toLong().hours

/**
 * [String]을 분(`minute`)으로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 분 기간을 나타내는 [Duration] 인스턴스
 * @throws NumberFormatException [String]이 [Long]의 범위를 벗어난 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.minutes
 */
val String.minutes: Duration
    get() = this.toLong().minutes

/**
 * [String]을 초(`second`)로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 초 기간을 나타내는 [Duration] 인스턴스
 * @throws NumberFormatException [String]이 [Long]의 범위를 벗어난 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.seconds
 */
val String.seconds: Duration
    get() = this.toLong().seconds

/**
 * [String]을 밀리초(`millisecond`)로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 밀리초 기간을 나타내는 [Duration] 인스턴스
 * @throws NumberFormatException [String]이 [Long]의 범위를 벗어난 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.milliseconds
 */
val String.milliseconds: Duration
    get() = this.toLong().milliseconds

/**
 * [String]을 마이크로초(`microsecond`)로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 마이크로초 기간을 나타내는 [Duration] 인스턴스
 * @throws NumberFormatException [String]이 [Long]의 범위를 벗어난 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.microseconds
 */
val String.microseconds: Duration
    get() = this.toLong().microseconds

/**
 * [String]을 나노초(`nanosecond`)로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 나노초 기간을 나타내는 [Duration] 인스턴스
 * @throws NumberFormatException [String]이 [Long]의 범위를 벗어난 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.nanoseconds
 */
val String.nanoseconds: Duration
    get() = this.toLong().nanoseconds

/**
 * [String]을 날짜 기간으로 해석하고 [Period]로 파싱합니다.
 *
 * 파싱할 문자열은 ISO-8601 기간 형식인 `PnYnMnD`와 `PnW`에 기반으로 하며,
 * 주(`week`)는 정확히 7일로 간주됩니다.
 *
 * [String]은 선택적으로 부호(`+`, `-`)로 시작할 수 있으며,
 * 음수인 경우 전체 기간이 음수로 처리됩니다.
 * 다음은 `P` 또는 `p`가 와야 합니다.
 * 이후에는 각각 숫자와 접미사로 구성된 네가지 섹션이 있습니다.
 * 섹션의 접미사는 년(`Y`), 월(`M`), 주(`W`), 일(`D`)을 나타내며,
 * 대소문자를 구분하지 않습니다.
 * 접미사는 순서대로 나타나야 합니다.
 * 최소한 네 가지 섹션 중 하나는 반드시 존재해야 합니다.
 * 각 섹션은 하나 이상의 숫자로 구성되어야 하며,
 * 숫자는 음수(`-`) 또는 양수 기호(`+`)로 시작할 수 있습니다.
 *
 * 예시:
 * - `P2Y`: "2년"으로 파싱됩니다.
 * - `P3M`: "3개월"으로 파싱됩니다.
 * - `P4W`: "4주"로 파싱됩니다.
 * - `P5D`: "5일"로 파싱됩니다.
 * - `P1Y2M3D`: "1년 2개월 3일"로 파싱됩니다.
 * - `P1Y2M3W4D`: "1년 2개월 25일"로 파싱됩니다.
 * - `P-1Y2M`: "-1년 +2개월"로 파싱됩니다.
 * - `-P1Y2M`: "-1년 -2개월"로 파싱됩니다.
 *
 * @receiver `PnYnMnD` 또는 `PnW` 형식의 문자열
 * @return 파싱된 [Period] 인스턴스
 * @throws DateTimeParseException 문자열 파싱을 할 수 없는 경우
 * @since 0.14.4
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toPeriod
 */
fun String.toPeriod(): Period {
    return Period.parse(this)
}

/**
 * [String]을 날짜 기간으로 해석하고 [Period]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * 파싱할 문자열은 ISO-8601 기간 형식인 `PnYnMnD`와 `PnW`에 기반으로 하며,
 * 주(`week`)는 정확히 7일로 간주됩니다.
 *
 * [String]은 선택적으로 부호(`+`, `-`)로 시작할 수 있으며,
 * 음수인 경우 전체 기간이 음수로 처리됩니다.
 * 다음은 `P` 또는 `p`가 와야 합니다.
 * 이후에는 각각 숫자와 접미사로 구성된 네가지 섹션이 있습니다.
 * 섹션의 접미사는 년(`Y`), 월(`M`), 주(`W`), 일(`D`)을 나타내며,
 * 대소문자를 구분하지 않습니다.
 * 접미사는 순서대로 나타나야 합니다.
 * 최소한 네 가지 섹션 중 하나는 반드시 존재해야 합니다.
 * 각 섹션은 하나 이상의 숫자로 구성되어야 하며,
 * 숫자는 음수(`-`) 또는 양수 기호(`+`)로 시작할 수 있습니다.
 *
 * 예시:
 * - `P2Y`: "2년"으로 파싱됩니다.
 * - `P3M`: "3개월"으로 파싱됩니다.
 * - `P4W`: "4주"로 파싱됩니다.
 * - `P5D`: "5일"로 파싱됩니다.
 * - `P1Y2M3D`: "1년 2개월 3일"로 파싱됩니다.
 * - `P1Y2M3W4D`: "1년 2개월 25일"로 파싱됩니다.
 * - `P-1Y2M`: "-1년 +2개월"로 파싱됩니다.
 * - `-P1Y2M`: "-1년 -2개월"로 파싱됩니다.
 *
 * @receiver `PnYnMnD` 또는 `PnW` 형식의 문자열
 * @return 파싱된 [Period] 인스턴스 또는 `null`
 * @throws DateTimeParseException 문자열 파싱을 할 수 없는 경우
 * @since 0.14.4
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toPeriodOrNull
 */
fun String.toPeriodOrNull(): Period? {
    return try {
        toPeriod()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 시간 기간으로 해석하고 [Duration]로 파싱합니다.
 *
 * 수용되는 형식은 ISO-8601 duration 형식 `PnDTnHnMn.nS`를 기반으로 하며,
 * 일(`day`)는 정확히 24시간으로 간주됩니다.
 *
 * [String]은 선택적으로 부호(`+`, `-`)로 시작할 수 있으며,
 * 음수인 경우 전체 기간이 음수로 처리됩니다.
 * 다음은 `P` 또는 `p`가 와야 합니다.
 * 이후에는 각각 숫자와 접미사로 구성된 네가지 섹션이 있습니다.
 * 섹션에는 일, 시간, 분, 초를 나타내는 `D`, `H`, `M`, `S`와 같은 접미사가 있으며,
 * 대소문자를 구분하지 않습니다.
 * 접미사는 순차적으로 나타나야 합니다.
 * `T`는 시간, 분, 초 섹션의 첫 번째 항목 앞에 나타나야 합니다.
 * 네가지 섹션 중 최소 하나가 있어야 하며,
 * `T`가 있으면 `T` 뒤에 적어도 하나의 섹션이 있어야 합니다.
 * 각 섹션은 하나 이상의 숫자로 구성되어야 하며, 숫자는 음수(`-`) 또는 양수 기호(`+`)로 시작할 수 있습니다.
 * 초의 숫자는 선택적으로 소수점(`.`, `,`)을 포함할 수 있습니다.
 * 소수점은 최대 9자리까지 허용됩니다.
 *
 * 예시:
 *
 * - `PT20.345S`: "20.345초"로 파싱됩니다.
 * - `PT15M`: "15분"으로 파싱됩니다.
 * - `PT10H`: "10시간"으로 파싱됩니다.
 * - `P2D`: "48시간"로 파싱됩니다.
 * - `P2DT3H4M`: "51시간 4분"으로 파싱됩니다.
 * - `P-6H3M`: "-6시간 +3분"으로 파싱됩니다.
 * - `-PT6H3M`: "-6시간 -3분"으로 파싱됩니다.
 * - `-PT-6H+3M`: "+6시간 -3분"으로 파싱됩니다.
 *
 * @receiver `PnDTnHnMn.nS` 형식의 문자열
 * @return 파싱된 [Duration] 인스턴스
 * @throws DateTimeParseException 문자열 파싱을 할 수 없는 경우
 * @since 0.14.4
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toDuration
 */
fun String.toDuration(): Duration {
    return Duration.parse(this)
}

/**
 * [String]을 시간 기간으로 해석하고 [Duration]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * 수용되는 형식은 ISO-8601 duration 형식 `PnDTnHnMn.nS`를 기반으로 하며,
 * 일(`day`)는 정확히 24시간으로 간주됩니다.
 *
 * [String]은 선택적으로 부호(`+`, `-`)로 시작할 수 있으며,
 * 음수인 경우 전체 기간이 음수로 처리됩니다.
 * 다음은 `P` 또는 `p`가 와야 합니다.
 * 이후에는 각각 숫자와 접미사로 구성된 네가지 섹션이 있습니다.
 * 섹션에는 일, 시간, 분, 초를 나타내는 `D`, `H`, `M`, `S`와 같은 접미사가 있으며,
 * 대소문자를 구분하지 않습니다.
 * 접미사는 순차적으로 나타나야 합니다.
 * `T`는 시간, 분, 초 섹션의 첫 번째 항목 앞에 나타나야 합니다.
 * 네가지 섹션 중 최소 하나가 있어야 하며,
 * `T`가 있으면 `T` 뒤에 적어도 하나의 섹션이 있어야 합니다.
 * 각 섹션은 하나 이상의 숫자로 구성되어야 하며, 숫자는 음수(`-`) 또는 양수 기호(`+`)로 시작할 수 있습니다.
 * 초의 숫자는 선택적으로 소수점(`.`, `,`)을 포함할 수 있습니다.
 * 소수점은 최대 9자리까지 허용됩니다.
 *
 * 예시:
 *
 * - `PT20.345S`: "20.345초"로 파싱됩니다.
 * - `PT15M`: "15분"으로 파싱됩니다.
 * - `PT10H`: "10시간"으로 파싱됩니다.
 * - `P2D`: "48시간"로 파싱됩니다.
 * - `P2DT3H4M`: "51시간 4분"으로 파싱됩니다.
 * - `P-6H3M`: "-6시간 +3분"으로 파싱됩니다.
 * - `-PT6H3M`: "-6시간 -3분"으로 파싱됩니다.
 * - `-PT-6H+3M`: "+6시간 -3분"으로 파싱됩니다.
 *
 * @receiver `PnDTnHnMn.nS` 형식의 문자열
 * @return 파싱된 [Duration] 인스턴스 또는 `null`
 * @throws DateTimeParseException 문자열 파싱을 할 수 없는 경우
 * @since 0.14.4
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toDurationOrNull
 */
fun String.toDurationOrNull(): Duration? {
    return try {
        toDuration()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 날짜 및 시간 형식으로 해석하고 [DateTimeFormatter]으로 파싱합니다.
 *
 * [String]이 라이브러리 기본 형식과 일치하는 경우 새롭게 생성하지 않고,
 * 싱글톤 객체를 반환합니다.
 *
 * 기본 형식은 `src/main/resources/java-time-extensions.properties` 파일에서 재정의 할 수 있습니다.
 *
 * java-time-extensions.properties 파일의 예시:
 *
 * ```properties
 * # 기본값: yyyy-MM-dd
 * pattern.local-date=yyyyMMdd
 * # 기본값: yyyy-MM-dd'T'HH:mm:ss
 * pattern.local-date-time=yyyy-MM-dd HH:mm:ss
 * # 기본값: HH:mm:ss
 * pattern.local-time=HHmmss
 * # 기본값: MM-dd
 * pattern.month-day=MMdd
 * # 기본값: yyyy-MM-dd'T'HH:mm:ss.SSSZ
 * pattern.offset-date-time=yyyy-MM-dd HH:mm:ss.SSSZ
 * # 기본값: HH:mm:ss.SSSZ
 * pattern.offset-time=HHmmssSSSZ
 * # 기본값: yyyy
 * pattern.year=yy
 * # 기본값: yyyy-MM
 * pattern.year-month=yyyy-MM
 * # 기본값: yyyy-MM-dd'T'HH:mm:ss.SSS.Z
 * pattern.zoned-date-time=yyyy-MM-dd HH:mm:ss.SSS Z
 * ```
 *
 * @receiver 날짜 및 시간 형식 문자열
 * @return 파싱된 [DateTimeFormatter] 인스턴스
 * @throws IllegalArgumentException 날짜 포맷이 유효하지 않은 경우
 * @since 0.7.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toDateTimeFormatter
 */
fun String.toDateTimeFormatter(): DateTimeFormatter {
    return when (this) {
        JavaTimeExtensionConfiguration.PATTERN_LOCAL_DATE -> JavaTimeExtensionConfiguration.FORMATTER_LOCAL_DATE
        JavaTimeExtensionConfiguration.PATTERN_LOCAL_DATE_TIME -> JavaTimeExtensionConfiguration.FORMATTER_LOCAL_DATE_TIME
        JavaTimeExtensionConfiguration.PATTERN_LOCAL_TIME -> JavaTimeExtensionConfiguration.FORMATTER_LOCAL_TIME
        JavaTimeExtensionConfiguration.PATTERN_MONTH_DAY -> JavaTimeExtensionConfiguration.FORMATTER_MONTH_DAY
        JavaTimeExtensionConfiguration.PATTERN_OFFSET_DATE_TIME -> JavaTimeExtensionConfiguration.FORMATTER_OFFSET_DATE_TIME
        JavaTimeExtensionConfiguration.PATTERN_OFFSET_TIME -> JavaTimeExtensionConfiguration.FORMATTER_OFFSET_TIME
        JavaTimeExtensionConfiguration.PATTERN_YEAR -> JavaTimeExtensionConfiguration.FORMATTER_YEAR
        JavaTimeExtensionConfiguration.PATTERN_YEAR_MONTH -> JavaTimeExtensionConfiguration.FORMATTER_YEAR_MONTH
        JavaTimeExtensionConfiguration.PATTERN_ZONED_DATE_TIME -> JavaTimeExtensionConfiguration.FORMATTER_ZONED_DATE_TIME
        else -> DateTimeFormatter.ofPattern(this)
    }
}

/**
 * [String]을 날짜 및 시간 형식으로 해석하고 [DateTimeFormatter]으로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * [String]이 라이브러리 기본 형식과 일치하는 경우 새롭게 생성하지 않고,
 * 싱글톤 객체를 반환합니다.
 *
 * 기본 형식은 `src/main/resources/java-time-extensions.properties` 파일에서 재정의 할 수 있습니다.
 *
 * java-time-extensions.properties 파일의 예시:
 *
 * ```properties
 * # 기본값: yyyy-MM-dd
 * pattern.local-date=yyyyMMdd
 * # 기본값: yyyy-MM-dd'T'HH:mm:ss
 * pattern.local-date-time=yyyy-MM-dd HH:mm:ss
 * # 기본값: HH:mm:ss
 * pattern.local-time=HHmmss
 * # 기본값: MM-dd
 * pattern.month-day=MMdd
 * # 기본값: yyyy-MM-dd'T'HH:mm:ss.SSSZ
 * pattern.offset-date-time=yyyy-MM-dd HH:mm:ss.SSSZ
 * # 기본값: HH:mm:ss.SSSZ
 * pattern.offset-time=HHmmssSSSZ
 * # 기본값: yyyy
 * pattern.year=yy
 * # 기본값: yyyy-MM
 * pattern.year-month=yyyy-MM
 * # 기본값: yyyy-MM-dd'T'HH:mm:ss.SSS.Z
 * pattern.zoned-date-time=yyyy-MM-dd HH:mm:ss.SSS Z
 * ```
 *
 * @receiver 날짜 및 시간 형식 문자열
 * @return 파싱된 [DateTimeFormatter] 인스턴스 또는 `null`
 * @since 0.7.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toDateTimeFormatterOrNull
 */
fun String.toDateTimeFormatterOrNull(): DateTimeFormatter? {
    return try {
        toDateTimeFormatter()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 연도(`year`)로 해석하고 [Year]로 파싱합니다.
 *
 * [String]은 라이브러리 기본 형식과 일치해야 합니다.
 *
 * 기본 형식은 `src/main/resources/java-time-extensions.properties` 파일에서 재정의 할 수 있습니다.
 *
 * java-time-extensions.properties 파일의 예시:
 *
 * ```properties
 * # 기본값: yyyy
 * pattern.year=yy
 * ```
 *
 * @receiver 기본 형식의 연도 문자열
 * @return 파싱된 [Year] 인스턴스
 * @throws DateTimeParseException [String]을 [Year]로 파싱할 수 없는 경우
 * @since 0.4.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toYear
 */
fun String.toYear(): Year {
    return toYear(JavaTimeExtensionConfiguration.FORMATTER_YEAR)
}

/**
 * [String]을 연도(`year`)로 해석하고 [pattern]을 사용하여 [Year]로 파싱합니다.
 *
 * @receiver [pattern] 형식의 연도 문자열
 * @param pattern 연도 문자열의 포맷
 * @return 파싱된 [Year] 인스턴스
 * @throws IllegalArgumentException [pattern]을 [DateTimeFormatter]로 파싱할 수 없는 경우
 * @throws DateTimeParseException [String]을 [Year]로 파싱할 수 없는 경우
 * @since 0.4.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toYearWithString
 */
fun String.toYear(
    pattern: String,
): Year {
    val formatter = pattern.toDateTimeFormatter()
    return toYear(formatter)
}

/**
 * [String]을 연도(`year`)로 해석하고 [formatter]를 사용하여 [Year]로 파싱합니다.
 *
 * @receiver [formatter] 형식의 연도 문자열
 * @param formatter [String]을 파싱할 [DateTimeFormatter]
 * @return 파싱된 [Year] 인스턴스
 * @throws DateTimeParseException [String]을 [Year]로 파싱할 수 없는 경우
 * @since 0.4.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toYearWithDateTimeFormatter
 */
fun String.toYear(
    formatter: DateTimeFormatter,
): Year {
    return Year.parse(this, formatter)
}

/**
 * [String]을 연도(`year`)로 해석하고 [Year]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * [String]은 라이브러리 기본 형식과 일치해야 합니다.
 *
 * 기본 형식은 `src/main/resources/java-time-extensions.properties` 파일에서 재정의 할 수 있습니다.
 *
 * java-time-extensions.properties 파일의 예시:
 *
 * ```properties
 * # 기본값: yyyy
 * pattern.year=yy
 * ```
 *
 * @receiver 기본 형식의 연도 문자열
 * @return 파싱된 [Year] 인스턴스 또는 `null`
 * @since 0.4.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toYearOrNull
 */
fun String.toYearOrNull(): Year? {
    return try {
        toYear()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 연도(`year`)로 해석하고 [pattern]을 사용하여 [Year]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * @receiver [pattern] 형식의 연도 문자열
 * @param pattern 연도 형식 문자열
 * @return 파싱된 [Year] 인스턴스 또는 `null`
 * @since 0.4.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toYearOrNullWithString
 */
fun String.toYearOrNull(
    pattern: String,
): Year? {
    return try {
        toYear(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 연도(`year`)로 해석하고 [formatter]를 사용하여 [Year]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * @receiver [formatter] 형식의 연도 문자열
 * @param formatter [String]을 파싱할 [DateTimeFormatter]
 * @return 파싱된 [Year] 인스턴스 또는 `null`
 * @since 0.4.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toYearOrNullWithDateTimeFormatter
 */
fun String.toYearOrNull(
    formatter: DateTimeFormatter,
): Year? {
    return try {
        toYear(formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * 주어진 월 문자열을 [String]을 [Month]로 변환합니다.
 *
 * @return 변환된 [Month] 인스턴스
 * @throws NumberFormatException 문자열이 숫자로 변환할 수 없는 경우
 * @throws DateTimeException 문자열 파싱에 실패한 경우
 * @since 0.13.8
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toMonth
 */
fun String.toMonth(): Month {
    return when (this) {
        "Jan",
        "JANUARY" -> Month.JANUARY

        "Feb",
        "FEBRUARY" -> Month.FEBRUARY

        "Mar",
        "MARCH" -> Month.MARCH

        "Apr",
        "APRIL" -> Month.APRIL

        "May",
        "MAY" -> Month.MAY

        "Jun",
        "JUNE" -> Month.JUNE

        "Jul",
        "JULY" -> Month.JULY

        "Aug",
        "AUGUST" -> Month.AUGUST

        "Sep",
        "SEPTEMBER" -> Month.SEPTEMBER

        "Oct",
        "OCTOBER" -> Month.OCTOBER

        "Nov",
        "NOVEMBER" -> Month.NOVEMBER

        "Dec",
        "DECEMBER" -> Month.DECEMBER

        else -> this.toInt().toMonth()
    }
}

/**
 * 주어진 월 문자열을 [String]을 [Month]로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * @return 변환된 [Month] 인스턴스 또는 변환 실패 시 null
 * @since 0.13.8
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toMonthOrNull
 */
fun String.toMonthOrNull(): Month? {
    return try {
        toMonth()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 연도와 월(`year-month`)로 해석하고 [YearMonth]로 파싱합니다.
 *
 * [String]은 라이브러리 기본 형식과 일치해야 합니다.
 *
 * 기본 형식은 `src/main/resources/java-time-extensions.properties` 파일에서 재정의 할 수 있습니다.
 *
 * java-time-extensions.properties 파일의 예시:
 *
 * ```properties
 * # 기본값: yyyy-MM
 * pattern.year-month=yyyy-MM
 * ```
 *
 * @receiver 기본 형식의 연도와 월 문자열
 * @return 파싱한 [YearMonth] 인스턴스
 * @throws DateTimeParseException [String]을 [YearMonth]로 파싱할 수 없는 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toYearMonth
 */
fun String.toYearMonth(): YearMonth {
    return toYearMonth(JavaTimeExtensionConfiguration.FORMATTER_YEAR_MONTH)
}

/**
 * [String]을 연도와 월(`year-month`)로 해석하고 [pattern]을 사용하여 [YearMonth]로 파싱합니다.
 *
 * @receiver [pattern] 형식의 연도와 월 문자열
 * @param pattern 연도와 월 포맷 문자열
 * @return 파싱한 [YearMonth] 인스턴스
 * @throws IllegalArgumentException [pattern]을 [DateTimeFormatter]로 파싱할 수 없는 경우
 * @throws DateTimeParseException [String]을 [YearMonth]로 파싱할 수 없는 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toYearMonthWithString
 */
fun String.toYearMonth(
    pattern: String,
): YearMonth {
    val formatter = pattern.toDateTimeFormatter()
    return toYearMonth(formatter)
}

/**
 * [String]을 연도와 월(`year-month`)로 해석하고 [formatter]를 사용하여 [YearMonth]로 파싱합니다.
 *
 * @receiver [formatter] 형식의 연도와 월 문자열
 * @param formatter [String]을 파싱할 [DateTimeFormatter]
 * @return 파싱한 [YearMonth] 인스턴스
 * @throws DateTimeParseException [String]을 [YearMonth]로 파싱할 수 없는 경우
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toYearMonthWithDateTimeFormatter
 */
fun String.toYearMonth(
    formatter: DateTimeFormatter,
): YearMonth {
    return YearMonth.parse(this, formatter)
}

/**
 * [String]을 연도와 월(`year-month`)로 해석하고 [YearMonth]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * [String]은 라이브러리 기본 형식과 일치해야 합니다.
 *
 * 기본 형식은 `src/main/resources/java-time-extensions.properties` 파일에서 재정의 할 수 있습니다.
 *
 * java-time-extensions.properties 파일의 예시:
 *
 * ```properties
 * # 기본값: yyyy-MM
 * pattern.year-month=yyyy MM
 * ```
 *
 * @receiver 기본 형식의 연도와 월 문자열
 * @return 파싱한 [YearMonth] 인스턴스 또는 `null`
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toYearMonthOrNull
 */
fun String.toYearMonthOrNull(): YearMonth? {
    return try {
        toYearMonth()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 연도와 월(`year-month`)로 해석하고 [pattern]을 사용하여 [YearMonth]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * @receiver [pattern] 형식의 연도와 월 문자열
 * @param pattern 연도와 월 포맷 문자열
 * @return 파싱한 [YearMonth] 인스턴스 또는 `null`
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toYearMonthOrNullWithString
 */
fun String.toYearMonthOrNull(
    pattern: String,
): YearMonth? {
    return try {
        toYearMonth(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 연도와 월(`year-month`)로 해석하고 [formatter]를 사용하여 [YearMonth]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * @receiver [formatter] 형식의 연도와 월 문자열
 * @param formatter [String]을 파싱할 [DateTimeFormatter]
 * @return 파싱한 [YearMonth] 인스턴스 또는 `null`
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toYearMonthOrNullWithDateTimeFormatter
 */
fun String.toYearMonthOrNull(
    formatter: DateTimeFormatter,
): YearMonth? {
    return try {
        toYearMonth(formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 월과 일(`month-day`)로 해석하고 [MonthDay]로 파싱합니다.
 *
 * [String]은 라이브러리 기본 형식과 일치해야 합니다.
 *
 * 기본 형식은 `src/main/resources/java-time-extensions.properties` 파일에서 재정의 할 수 있습니다.
 *
 * java-time-extensions.properties 파일의 예시:
 *
 * ```properties
 * # 기본값: MM-dd
 * pattern.month-day=MMdd
 * ```
 *
 * @receiver 기본 형식의 월과 일 문자열
 * @return 파싱한 [MonthDay] 인스턴스
 * @throws DateTimeParseException [String]을 [MonthDay]로 파싱할 수 없는 경우
 * @since 0.8.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toMonthDay
 */
fun String.toMonthDay(): MonthDay {
    return toMonthDay(JavaTimeExtensionConfiguration.FORMATTER_MONTH_DAY)
}

/**
 * [String]을 월과 일(`month-day`)로 해석하고 [pattern]을 사용하여 [MonthDay]로 파싱합니다.
 *
 * @receiver [pattern] 형식의 월과 일 문자열
 * @param pattern 월과 일 포맷 문자열
 * @return 파싱한 [MonthDay] 인스턴스
 * @throws IllegalArgumentException [pattern]을 [DateTimeFormatter]로 파싱할 수 없는 경우
 * @throws DateTimeParseException [String]을 [MonthDay]로 파싱할 수 없는 경우
 * @since 0.8.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toMonthDayWithString
 */
fun String.toMonthDay(
    pattern: String,
): MonthDay {
    val formatter = pattern.toDateTimeFormatter()
    return toMonthDay(formatter)
}

/**
 * [String]을 월과 일(`month-day`)로 해석하고 [formatter]를 사용하여 [MonthDay]로 파싱합니다.
 *
 * @receiver [formatter] 형식의 월과 일 문자열
 * @param formatter [String]을 파싱할 [DateTimeFormatter]
 * @return 파싱한 [MonthDay] 인스턴스
 * @throws DateTimeParseException [String]을 [MonthDay]로 파싱할 수 없는 경우
 * @since 0.8.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toMonthDayWithDateTimeFormatter
 */
fun String.toMonthDay(
    formatter: DateTimeFormatter,
): MonthDay {
    return MonthDay.parse(this, formatter)
}

/**
 * [String]을 월과 일(`month-day`)로 해석하고 [MonthDay]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * [String]은 라이브러리 기본 형식과 일치해야 합니다.
 *
 * 기본 형식은 `src/main/resources/java-time-extensions.properties` 파일에서 재정의 할 수 있습니다.
 *
 * java-time-extensions.properties 파일의 예시:
 *
 * ```properties
 * # 기본값: MM-dd
 * pattern.month-day=MMdd
 * ```
 *
 * @receiver 기본 형식의 월과 일 문자열
 * @return 파싱한 [MonthDay] 인스턴스 또는 `null`
 * @since 0.8.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toMonthDayOrNull
 */
fun String.toMonthDayOrNull(): MonthDay? {
    return try {
        toMonthDay()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 월과 일(`month-day`)로 해석하고 [pattern]을 사용하여 [MonthDay]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * @receiver [pattern] 형식의 월과 일 문자열
 * @param pattern 월과 일 포맷 문자열
 * @return 파싱한 [MonthDay] 인스턴스 또는 `null`
 * @since 0.8.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toMonthDayOrNullWithString
 */
fun String.toMonthDayOrNull(
    pattern: String,
): MonthDay? {
    return try {
        toMonthDay(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 월과 일(`month-day`)로 해석하고 [formatter]를 사용하여 [MonthDay]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * @receiver [formatter] 형식의 월과 일 문자열
 * @param formatter [String]을 파싱할 [DateTimeFormatter]
 * @return 파싱한 [MonthDay] 인스턴스 또는 `null`
 * @since 0.8.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toMonthDayOrNullWithDateTimeFormatter
 */
fun String.toMonthDayOrNull(
    formatter: DateTimeFormatter,
): MonthDay? {
    return try {
        toMonthDay(formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 날짜로 해석하고 [LocalDate]로 파싱합니다.
 *
 * [String]은 라이브러리 기본 형식과 일치해야 합니다.
 *
 * 기본 형식은 `src/main/resources/java-time-extensions.properties` 파일에서 재정의 할 수 있습니다.
 *
 * java-time-extensions.properties 파일의 예시:
 *
 * ```properties
 * # 기본값: yyyy-MM-dd
 * pattern.local-date=yyyyMMdd
 * ```
 *
 * @receiver 기본 형식의 날짜 문자열
 * @return 파싱된 [LocalDate] 인스턴스
 * @throws DateTimeParseException [String]을 [LocalDate]로 파싱할 수 없는 경우
 * @since 0.7.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDate
 */
fun String.toLocalDate(): LocalDate {
    return this.toLocalDate(JavaTimeExtensionConfiguration.FORMATTER_LOCAL_DATE)
}

/**
 * [String]을 날짜로 해석하고 [pattern]을 사용하여 [LocalDate]로 파싱합니다.
 *
 * @receiver [pattern] 형식의 날짜 문자열
 * @param pattern 날짜 형식 문자열
 * @return 파싱된 [LocalDate] 인스턴스
 * @throws IllegalArgumentException [pattern]을 [DateTimeFormatter]로 파싱할 수 없는 경우
 * @throws DateTimeParseException [String]을 [LocalDate]로 파싱할 수 없는 경우
 * @since 0.7.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateWithString
 */
fun String.toLocalDate(
    pattern: String,
): LocalDate {
    val formatter = pattern.toDateTimeFormatter()
    return toLocalDate(formatter)
}

/**
 * [String]을 날짜로 해석하고 [formatter]를 사용하여 [LocalDate]로 파싱합니다.
 *
 * @receiver [formatter] 형식의 날짜 문자열
 * @param formatter [String]을 파싱할 [DateTimeFormatter]
 * @return 파싱된 [LocalDate] 인스턴스
 * @throws DateTimeParseException [String]을 [LocalDate]로 파싱할 수 없는 경우
 * @since 0.7.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateWithDateTimeFormatter
 */
fun String.toLocalDate(
    formatter: DateTimeFormatter,
): LocalDate {
    return LocalDate.parse(this, formatter)
}

/**
 * [String]을 날짜로 해석하고 [LocalDate]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * [String]은 라이브러리 기본 형식과 일치해야 합니다.
 *
 * 기본 형식은 `src/main/resources/java-time-extensions.properties` 파일에서 재정의 할 수 있습니다.
 *
 * java-time-extensions.properties 파일의 예시:
 *
 * ```properties
 * # 기본값: yyyy-MM-dd
 * pattern.local-date=yyyyMMdd
 * ```
 *
 * @receiver 기본 형식의 날짜 문자열
 * @return 파싱된 [LocalDate] 인스턴스 또는 `null`
 * @since 0.7.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateOrNull
 */
fun String.toLocalDateOrNull(): LocalDate? {
    return try {
        toLocalDate()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 날짜로 해석하고 [pattern]을 사용하여 [LocalDate]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * @receiver [pattern] 형식의 날짜 문자열
 * @param pattern 날짜 형식 문자열
 * @return 파싱된 [LocalDate] 인스턴스 또는 `null`
 * @since 0.7.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateOrNullWithString
 */
fun String.toLocalDateOrNull(
    pattern: String,
): LocalDate? {
    return try {
        toLocalDate(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 날짜로 해석하고 [formatter]를 사용하여 [LocalDate]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * @receiver [formatter] 형식의 날짜 문자열
 * @param formatter [String]을 파싱할 [DateTimeFormatter]
 * @return 파싱된 [LocalDate] 인스턴스 또는 `null`
 * @since 0.7.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateOrNullWithDateTimeFormatter
 */
fun String.toLocalDateOrNull(
    formatter: DateTimeFormatter,
): LocalDate? = try {
    toLocalDate(formatter)
} catch (e: Exception) {
    null
}

/**
 * [String]을 시간으로 해석하고 [LocalDateTime]로 파싱합니다.
 *
 * [String]은 라이브러리 기본 형식과 일치해야 합니다.
 *
 * 기본 형식은 `src/main/resources/java-time-extensions.properties` 파일에서 재정의 할 수 있습니다.
 *
 * java-time-extensions.properties 파일의 예시:
 *
 * ```properties
 * # 기본값: HH:mm:ss
 * pattern.local-time=HHmmss
 * ```
 *
 * @receiver 기본 형식의 시간 문자열
 * @return 파싱된 [LocalTime] 인스턴스
 * @throws DateTimeParseException [String]을 [LocalTime]로 파싱할 수 없는 경우
 * @since 0.2.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalTime
 */
fun String.toLocalTime(): LocalTime {
    return toLocalTime(JavaTimeExtensionConfiguration.FORMATTER_LOCAL_TIME)
}

/**
 * [String]을 시간으로 해석하고 [pattern]을 사용하여 [LocalTime]로 파싱합니다.
 *
 * @receiver [pattern] 형식의 시간 문자열
 * @param pattern 시간 형식 문자열
 * @return 파싱된 [LocalTime] 인스턴스
 * @throws IllegalArgumentException [pattern]을 [DateTimeFormatter]로 파싱할 수 없는 경우
 * @throws DateTimeParseException [String]을 [LocalTime]로 파싱할 수 없는 경우
 * @since 0.2.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalTimeWithString
 */
fun String.toLocalTime(
    pattern: String,
): LocalTime {
    val formatter = pattern.toDateTimeFormatter()
    return toLocalTime(formatter)
}

/**
 * [String]을 시간으로 해석하고 [formatter]를 사용하여 [LocalTime]로 파싱합니다.
 *
 * @receiver [formatter] 형식의 시간 문자열
 * @param formatter [String]을 파싱할 [DateTimeFormatter]
 * @return 파싱된 [LocalTime] 인스턴스
 * @throws DateTimeParseException [String]을 [LocalTime]로 파싱할 수 없는 경우
 * @since 0.2.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalTimeWithDateTimeFormatter
 */
fun String.toLocalTime(
    formatter: DateTimeFormatter,
): LocalTime {
    return LocalTime.parse(this, formatter)
}

/**
 * [String]을 시간으로 해석하고 [LocalTime]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * [String]은 라이브러리 기본 형식과 일치해야 합니다.
 *
 * 기본 형식은 `src/main/resources/java-time-extensions.properties` 파일에서 재정의 할 수 있습니다.
 *
 * java-time-extensions.properties 파일의 예시:
 *
 * ```properties
 * # 기본값: HH:mm:ss
 * pattern.local-time=HHmmss
 * ```
 *
 * @receiver 기본 형식의 시간 문자열
 * @return 파싱된 [LocalTime] 인스턴스 또는 `null`
 * @since 0.2.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalTimeOrNull
 */
fun String.toLocalTimeOrNull(): LocalTime? {
    return try {
        toLocalTime()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 시간으로 해석하고 [pattern]을 사용하여 [LocalTime]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * @receiver [pattern] 형식의 시간 문자열
 * @param pattern 시간 형식 문자열
 * @return 파싱된 [LocalTime] 인스턴스 또는 `null`
 * @since 0.2.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalTimeOrNullWithString
 */
fun String.toLocalTimeOrNull(
    pattern: String,
): LocalTime? {
    return try {
        toLocalTime(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 시간으로 해석하고 [formatter]를 사용하여 [LocalTime]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * @receiver [formatter] 형식의 시간 문자열
 * @param formatter [String]을 파싱할 [DateTimeFormatter]
 * @return 파싱된 [LocalTime] 인스턴스 또는 `null`
 * @since 0.2.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalTimeOrNullWithDateTimeFormatter
 */
fun String.toLocalTimeOrNull(
    formatter: DateTimeFormatter,
): LocalTime? {
    return try {
        toLocalTime(formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 시간과 UTC 오프셋(`offset-time`)으로 해석하고 [OffsetTime]로 파싱합니다.
 *
 * [String]은 라이브러리 기본 형식과 일치해야 합니다.
 *
 * 기본 형식은 `src/main/resources/java-time-extensions.properties` 파일에서 재정의 할 수 있습니다.
 *
 * java-time-extensions.properties 파일의 예시:
 *
 * ```properties
 * # 기본값: HH:mm:ssXXX
 * pattern.offset-time=HHmmssXXX
 * ```
 *
 * @receiver 기본 형식의 오프셋 시간 문자열
 * @return 파싱된 [OffsetTime] 인스턴스
 * @throws DateTimeParseException [String]을 [OffsetTime]로 파싱할 수 없는 경우
 * @since 0.14.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetTime
 */
fun String.toOffsetTime(): OffsetTime {
    return toOffsetTime(JavaTimeExtensionConfiguration.FORMATTER_OFFSET_TIME)
}

/**
 * [String]을 시간과 UTC 오프셋(`offset-time`)으로 해석하고 [pattern]을 사용하여 [OffsetTime]로 파싱합니다.
 *
 * @receiver [pattern] 형식의 오프셋 시간 문자열
 * @param pattern 오프셋 시간 형식 문자열
 * @return 파싱된 [OffsetTime] 인스턴스
 * @throws IllegalArgumentException [pattern]을 [DateTimeFormatter]로 파싱할 수 없는 경우
 * @throws DateTimeParseException [String]을 [OffsetTime]로 파싱할 수 없는 경우
 * @since 0.14.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetTimeWithString
 */
fun String.toOffsetTime(
    pattern: String,
): OffsetTime {
    val formatter = pattern.toDateTimeFormatter()
    return toOffsetTime(formatter)
}

/**
 * [String]을 시간과 UTC 오프셋(`offset-time`)으로 해석하고 [formatter]를 사용하여 [OffsetTime]로 파싱합니다.
 *
 * @receiver [formatter] 형식의 오프셋 시간 문자열
 * @param formatter [String]을 파싱할 [DateTimeFormatter]
 * @return 파싱된 [OffsetTime] 인스턴스
 * @throws DateTimeParseException [String]을 [OffsetTime]로 파싱할 수 없는 경우
 * @since 0.14.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetTimeWithDateTimeFormatter
 */
fun String.toOffsetTime(
    formatter: DateTimeFormatter,
): OffsetTime {
    return OffsetTime.parse(this, formatter)
}

/**
 * [String]을 시간과 UTC 오프셋(`offset-time`)으로 해석하고 [OffsetTime]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * [String]은 라이브러리 기본 형식과 일치해야 합니다.
 *
 * 기본 형식은 `src/main/resources/java-time-extensions.properties` 파일에서 재정의 할 수 있습니다.
 *
 * java-time-extensions.properties 파일의 예시:
 *
 * ```properties
 * # 기본값: HH:mm:ssXXX
 * pattern.offset-time=HHmmssXXX
 * ```
 *
 * @receiver 기본 형식의 오프셋 시간 문자열
 * @return 파싱된 [OffsetTime] 인스턴스 또는 `null`
 * @since 0.14.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetTimeOrNull
 */
fun String.toOffsetTimeOrNull(): OffsetTime? {
    return try {
        toOffsetTime()
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 시간과 UTC 오프셋(`offset-time`)으로 해석하고 [pattern]을 사용하여 [OffsetTime]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * @receiver [pattern] 형식의 오프셋 시간 문자열
 * @param pattern 오프셋 시간 형식 문자열
 * @return 파싱된 [OffsetTime] 인스턴스 또는 `null`
 * @since 0.14.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetTimeOrNullWithString
 */
fun String.toOffsetTimeOrNull(
    pattern: String,
): OffsetTime? {
    return try {
        toOffsetTime(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * [String]을 시간과 UTC 오프셋(`offset-time`)으로 해석하고 [formatter]를 사용하여 [OffsetTime]로 파싱하거나,
 * 파싱할 수 없는 경우 `null`을 반환합니다.
 *
 * @receiver [formatter] 형식의 오프셋 시간 문자열
 * @param formatter [String]을 파싱할 [DateTimeFormatter]
 * @return 파싱된 [OffsetTime] 인스턴스 또는 `null`
 * @since 0.14.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetTimeOrNullWithDateTimeFormatter
 */
fun String.toOffsetTimeOrNull(
    formatter: DateTimeFormatter,
): OffsetTime? {
    return try {
        toOffsetTime(formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * 주어진 일시 문자열을 [LocalDateTime]으로 파싱합니다. 기본 포맷 "yyyy-MM-dd'T'HH:mm:ss"를 사용합니다.
 *
 * @return 알시 문자열을 파싱한 [LocalDateTime] 인스턴스를 반환합니다.
 * @throws DateTimeParseException 문자열 분석에 실패한 경우 발생합니다.
 * @since 0.13.1
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateTime
 */
fun String.toLocalDateTime(): LocalDateTime {
    return toLocalDateTime(JavaTimeExtensionConfiguration.FORMATTER_LOCAL_DATE_TIME)
}

/**
 * 주어진 일시 문자열을 [pattern]을 사용하여 [LocalDateTime]으로 파싱합니다.
 *
 * @param pattern 일시 패턴 문자열
 * @return 패턴을 사용하여 일시 문자열을 파싱한 [LocalDateTime] 인스턴스를 반환합니다.
 * @throws IllegalArgumentException 패턴이 유효하지 않은 경우 발생합니다.
 * @throws DateTimeParseException 문자열 분석에 실패한 경우 발생합니다.
 * @since 0.13.1
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateTimeWithPattern
 */
fun String.toLocalDateTime(
    pattern: String,
): LocalDateTime {
    val formatter = pattern.toDateTimeFormatter()
    return toLocalDateTime(formatter)
}

/**
 * 주어진 일시 문자열을 [formatter]를 사용하여 [LocalDateTime]으로 파싱합니다.
 *
 * @param formatter 일시 포맷터
 * @return 포맷터를 사용하여 일시 문자열을 파싱한 [LocalDateTime] 인스턴스를 반환합니다.
 * @throws DateTimeParseException 문자열 분석에 실패한 경우 발생합니다.
 * @since 0.13.1
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateTimeWithDateTimeFormatter
 */
fun String.toLocalDateTime(
    formatter: DateTimeFormatter,
): LocalDateTime {
    return LocalDateTime.parse(this, formatter)
}

/**
 * 주어진 일시 문자열을 [LocalDateTime]으로 파싱합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * @return 일시 문자열을 파싱한 [LocalDateTime] 인스턴스를 반환합니다.
 * @since 0.13.1
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateTimeOrNull
 */
fun String.toLocalDateTimeOrNull(): LocalDateTime? {
    return try {
        toLocalDateTime()
    } catch (e: Exception) {
        null
    }
}

/**
 * 주어진 일시 문자열을 [pattern]을 사용하여 [LocalDateTime]으로 파싱합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * @param pattern 일시 패턴 문자열
 * @return 패턴을 사용하여 일시 문자열을 파싱한 [LocalDateTime] 인스턴스를 반환합니다.
 * @since 0.13.1
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateTimeOrNullWithPattern
 */
fun String.toLocalDateTimeOrNull(
    pattern: String,
): LocalDateTime? {
    return try {
        toLocalDateTime(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * 주어진 일시 문자열을 [formatter]를 사용하여 [LocalDateTime]으로 파싱합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * @param formatter 일시 포맷터
 * @return 포맷터를 사용하여 일시 문자열을 파싱한 [LocalDateTime] 인스턴스를 반환합니다.
 * @since 0.13.1
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toLocalDateTimeOrNullWithDateTimeFormatter
 */
fun String.toLocalDateTimeOrNull(
    formatter: DateTimeFormatter,
): LocalDateTime? {
    return try {
        toLocalDateTime(formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * 문자열을 [OffsetDateTime]으로 변환합니다. 기본 포맷 "yyyy-MM-dd'T'HH:mm:ssXXX"를 사용합니다.
 *
 * @return [OffsetDateTime] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetDateTime
 */
fun String.toOffsetDateTime(): OffsetDateTime {
    return toOffsetDateTime(JavaTimeExtensionConfiguration.FORMATTER_OFFSET_DATE_TIME)
}

/**
 * 문자열을 [pattern] 형식으로 [OffsetDateTime]으로 변환합니다.
 *
 * @param pattern 날짜 형식 문자열
 * @return [OffsetDateTime] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @throws IllegalArgumentException 날짜 포맷이 유효하지 않은 경우
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetDateTimeWithPattern
 */
fun String.toOffsetDateTime(
    pattern: String,
): OffsetDateTime {
    val formatter = pattern.toDateTimeFormatter()
    return toOffsetDateTime(formatter)
}

/**
 * 문자열을 [formatter]를 사용하여 [OffsetDateTime]으로 변환합니다.
 *
 * @param formatter 날짜 포맷터
 * @return [OffsetDateTime] 인스턴스
 * @throws DateTimeParseException 문자열 분석에 실패한 경우
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetDateTimeWithDateTimeFormatter
 */
fun String.toOffsetDateTime(
    formatter: DateTimeFormatter,
): OffsetDateTime {
    return OffsetDateTime.parse(this, formatter)
}

/**
 * 문자열을 [OffsetDateTime]으로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * @return [OffsetDateTime] 인스턴스
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetDateTimeOrNull
 */
fun String.toOffsetDateTimeOrNull(): OffsetDateTime? {
    return try {
        toOffsetDateTime()
    } catch (e: Exception) {
        null
    }
}

/**
 * 문자열을 [pattern] 형식으로 [OffsetDateTime]으로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * @param pattern 날짜 형식 문자열
 * @return [OffsetDateTime] 인스턴스
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetDateTimeOrNullWithPattern
 */
fun String.toOffsetDateTimeOrNull(
    pattern: String,
): OffsetDateTime? {
    return try {
        toOffsetDateTime(pattern)
    } catch (e: Exception) {
        null
    }
}

/**
 * 문자열을 [formatter]를 사용하여 [OffsetDateTime]으로 변환합니다. 변환에 실패하면 `null`을 반환합니다.
 *
 * @param formatter 날짜 포맷터
 * @return [OffsetDateTime] 인스턴스
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toOffsetDateTimeOrNullWithDateTimeFormatter
 */
fun String.toOffsetDateTimeOrNull(
    formatter: DateTimeFormatter,
): OffsetDateTime? {
    return try {
        toOffsetDateTime(formatter)
    } catch (e: Exception) {
        null
    }
}

/**
 * 주어진 문자열을 사용하여 [ZoneId] 인스턴스를 생성합니다.
 *
 * [toZoneId] 확장 함수는 [String]을 timezone ID로 해석하여 [ZoneId] 또는 [ZoneOffset]을 생성합니다.
 *
 * 파싱 과정은 다음 단계를 따릅니다:
 *
 * - 문자열이 `Z`와 같으면 [ZoneOffset.UTC]입니다.
 * - 문자열이 단일 문자로 구성되면 유효하지 않은 것으로 간주되어 [DateTimeException]이 발생합니다.
 * - 문자열이 `+` 또는 `-`로 시작하면 오프셋 ID로 간주되어 [ZoneOffset] 인스턴스를 생성합니다.
 * - 문자열이 `GMT`, `UTC` 또는 `UT`로 시작하면 동일한 ID를 가진 [ZoneId]이며 [ZoneOffset.UTC]와 동등한 규칙을 가집니다.
 * - 문자열이 `UTC+`, `UTC-`, `GMT+`, `GMT-`, `UT+` 또는 `UT-`로 시작하면 접두사가 있는 오프셋 기반 ID로 취급됩니다.
 * - 그 외의 모든 문자열은 지역 기반 시간대 ID로 파싱됩니다. 이들은 정규 표현식 `[A-Za-z][A-Za-z0-9~/._+-]+`와 일치해야 합니다.
 *
 * @return 지정된 ID를 나타내는 [ZoneId] 인스턴스
 * @throws DateTimeException 문자열의 형식이 유효하지 않은 경우
 * @throws java.time.zone.ZoneRulesException 문자열이 찾을 수 없는 지역 ID인 경우
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toZoneId
 */
fun String.toZoneId(): ZoneId {
    return ZoneId.of(this)
}

/**
 * 주어진 오프셋 ID [String]을 사용하여 [ZoneOffset] 인스턴스를 생성합니다.
 *
 * 지원되는 최대 범위는 `-18:00`에서 `+18:00`까지입니다.
 *
 * @return 지정된 오프셋을 나타내는 [ZoneOffset] 인스턴스
 * @throws DateTimeException 오프셋 ID가 유효하지 않은 경우 발생합니다.
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.StringExtensionsTest.toZoneOffset
 */
fun String.toZoneOffset(): ZoneOffset {
    return ZoneOffset.of(this)
}
