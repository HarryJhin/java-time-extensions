package io.github.harryjhin.java.time.extension

import java.time.DateTimeException
import java.time.Duration
import java.time.Instant
import java.time.LocalDateTime
import java.time.Month
import java.time.Period
import java.time.Year
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime

/**
 * [Long]을 연도(`year`)로 해석하고 [Period]로 변환합니다.
 *
 * 지원 범위:
 * - `2147483647L` ~ `-2147483648L`
 *
 * @return 지정된 연 기간을 나타내는 [Period] 인스턴스
 * @throws ArithmeticException [Long]이 [Int] 범위를 벗어난 경우 발생합니다.
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.LongExtensionsTest.years
 */
val Long.years: Period
    get() = this.toIntExact().years

/**
 * [Long]을 월(`month`)로 해석하고 [Period]로 변환합니다.
 *
 * 지원 범위:
 * - `2147483647L` ~ `-2147483648L`
 *
 * @return 지정된 월 기간을 나타내는 [Period] 인스턴스
 * @throws ArithmeticException [Long]이 [Int] 범위를 벗어난 경우 발생합니다.
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.LongExtensionsTest.months
 */
val Long.months: Period
    get() = this.toIntExact().months

/**
 * [Long]을 일(`day`)로 해석하고 [Period]로 변환합니다.
 *
 * 지원 범위:
 * - `2147483647L` ~ `-2147483648L`
 *
 * @return 지정된 일 기간을 나타내는 [Period] 인스턴스
 * @throws ArithmeticException [Long]이 [Int] 범위를 벗어난 경우 발생합니다.
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.LongExtensionsTest.days
 */
val Long.days: Period
    get() = this.toIntExact().days

/**
 * [Long]을 시(`hour`)로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 시 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.LongExtensionsTest.hours
 */
val Long.hours: Duration
    get() = Duration.ofHours(this)

/**
 * [Long]을 분(`minute`)으로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 분 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.LongExtensionsTest.minutes
 */
val Long.minutes: Duration
    get() = Duration.ofMinutes(this)

/**
 * [Long]을 초(`second`)로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 초 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.LongExtensionsTest.seconds
 */
val Long.seconds: Duration
    get() = Duration.ofSeconds(this)

/**
 * [Long]을 밀리초(`millisecond`)로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 밀리초 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.LongExtensionsTest.milliseconds
 */
val Long.milliseconds: Duration
    get() = Duration.ofMillis(this)

/**
 * [Long]을 마이크로초(`microsecond`)로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 마이크로초 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.LongExtensionsTest.microseconds
 */
val Long.microseconds: Duration
    get() = Duration.ofNanos(this * 1_000)

/**
 * [Long]을 나노초(`nanosecond`)로 해석하고 [Duration]으로 변환합니다.
 *
 * @return 지정된 나노초 기간을 나타내는 [Duration] 인스턴스
 * @since 0.3.0
 * @sample io.github.harryjhin.java.time.extension.LongExtensionsTest.nanoseconds
 */
val Long.nanoseconds: Duration
    get() = Duration.ofNanos(this)

/**
 * [Long]을 [Year]로 변환합니다.
 *
 * @return 지정된 연도를 나타내는 [Year] 인스턴스
 * @since 0.5.0
 * @sample io.github.harryjhin.java.time.extension.YearExtensionsTest.longToYear
 * @sample io.github.harryjhin.java.time.extension.YearExtensionsTest.longToYearFail
 */
fun Long.toYear(): Year {
    return this.toIntExact().toYear()
}

/**
 * [Long]을 [Year]로 변환합니다.
 *
 * 변환 중에 예외가 발생하면 `null`을 반환합니다.
 *
 * @return 지정된 연도를 나타내는 [Year] 인스턴스
 * @since 0.5.0
 * @sample io.github.harryjhin.java.time.extension.YearExtensionsTest.longToYearOrNull
 */
fun Long.toYearOrNull(): Year? {
    return this.toIntExact().toYearOrNull()
}

/**
 * [Long]을 [Month]로 변환합니다.
 *
 * @return 지정된 월을 나타내는 [Month] 인스턴스
 * @since 0.5.0
 * @sample io.github.harryjhin.java.time.extension.MonthExtensionsTest.longToMonth
 * @sample io.github.harryjhin.java.time.extension.MonthExtensionsTest.longToMonthFail
 */
fun Long.toMonth(): Month {
    return this.toIntExact().toMonth()
}

/**
 * [Long]을 [Month]로 변환합니다.
 *
 * 변환 중에 예외가 발생하면 `null`을 반환합니다.
 *
 * @return 지정된 월을 나타내는 [Month] 인스턴스
 * @since 0.5.0
 * @sample io.github.harryjhin.java.time.extension.MonthExtensionsTest.longToMonthOrNull
 */
fun Long.toMonthOrNull(): Month? {
    return this.toIntExact().toMonthOrNull()
}

/**
 * 전체 오프셋(초단위)[Long]을 사용하여 [ZoneOffset] 인스턴스를 생성합니다.
 *
 * 전체 오프셋은 `-18:00`에서 `+18:00` 범위 내에 있어야 하며, 이는 `-64_800L`에서 `64_800L` 사이의 값입니다.
 *
 * @return 지정된 오프셋을 나타내는 [ZoneOffset] 인스턴스를 반환합니다.
 * @throws ArithmeticException 오프셋이 [Int] 범위를 벗어난 경우 발생합니다.
 * @throws DateTimeException 오프셋이 지정된 범위 내에 있지 않은 경우 발생합니다.
 * @since 0.12.0
 * @sample io.github.harryjhin.java.time.extension.LongExtensionsTest.toZoneOffset
 */
fun Long.toZoneOffset(): ZoneOffset {
    return ZoneOffset.ofTotalSeconds(this.toIntExact())
}

/**
 * Unix Epoch 시간([Long])을 사용하여 [LocalDateTime] 인스턴스를 생성합니다.
 *
 * [toLocalDateTime] 확장 함수는 [Long]을 Unix Epoch(1970년 1월 1일 00:00:00 UTC) 시간으로부터 경과한 밀리초로 해석하여
 * 해당하는 [LocalDateTime] 인스턴스를 생성합니다.
 *
 * @receiver Unix Epoch 시간을 나타내는 [Long] 값
 * @return Unix Epoch 시간을 나타내는 [LocalDateTime] 인스턴스.
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.LongExtensionsTest.toLocalDateTime
 */
fun Long.toLocalDateTime(): LocalDateTime {
    val instant: Instant = Instant.ofEpochMilli(this)
    return LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
}

/**
 * Unix Epoch 시간([Long])을 사용하여 [ZonedDateTime] 인스턴스를 생성합니다.
 *
 * [toZonedDateTime] 확장 함수는 [Long]을 Unix Epoch(1970년 1월 1일 00:00:00 UTC) 시간으로부터 경과한 밀리초로 해석하여
 * 해당하는 [ZonedDateTime] 인스턴스를 생성합니다.
 *
 * @receiver Unix Epoch 시간을 나타내는 [Long] 값
 * @param zoneId 생성할 [ZonedDateTime]의 [ZoneId].
 *               기본값은 시스템의 기본 시간대입니다.
 * @return Unix Epoch 시간을 나타내는 [ZonedDateTime] 인스턴스.
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.LongExtensionsTest.toZonedDateTimeWithString
 */
fun Long.toZonedDateTime(
    zoneId: String,
): ZonedDateTime {
    val instant: Instant = Instant.ofEpochMilli(this)
    return instant.atZone(zoneId.toZoneId())
}

/**
 * Unix Epoch 시간([Long])을 사용하여 [ZonedDateTime] 인스턴스를 생성합니다.
 *
 * [toZonedDateTime] 확장 함수는 [Long]을 Unix Epoch(1970년 1월 1일 00:00:00 UTC) 시간으로부터 경과한 밀리초로 해석하여
 * 해당하는 [ZonedDateTime] 인스턴스를 생성합니다.
 *
 * @receiver Unix Epoch 시간을 나타내는 [Long] 값
 * @param zoneId 생성할 [ZonedDateTime]의 [ZoneId].
 *               기본값은 시스템의 기본 시간대입니다.
 * @return Unix Epoch 시간을 나타내는 [ZonedDateTime] 인스턴스.
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.LongExtensionsTest.toZonedDateTime
 */
fun Long.toZonedDateTime(
    zoneId: ZoneId = ZoneId.systemDefault(),
): ZonedDateTime {
    val instant: Instant = Instant.ofEpochMilli(this)
    return instant.atZone(zoneId)
}

/**
 * [Long]을 [Int]로 변환합니다.
 *
 * 변환 중에 [Int] 범위를 벗어나면 예외를 발생시킵니다.
 *
 * @return 변환된 [Int] 값
 * @throws ArithmeticException [Int] 범위를 벗어난 경우
 * @since 0.8.1
 * @sample io.github.harryjhin.java.time.extension.LongExtensionsTest.toIntExact
 */
internal fun Long.toIntExact(): Int {
    val value: Int = this.toInt()

    if (this != value.toLong()) {
        throw ArithmeticException("long overflow: $this")
    }

    return value
}