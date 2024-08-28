package io.github.harryjhin.java.time.extension

import java.time.Duration
import java.time.Period
import java.time.ZonedDateTime

/**
 * [ZonedDateTime]의 연도 값만을 사용하여 [Period] 인스턴스를 생성합니다.
 *
 * @return [ZonedDateTime]의 연도를 나타내는 [Period] 인스턴스를 반환합니다.
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.ZonedDateTimeExtensionsTest.years
 */
val ZonedDateTime.years: Period
    get() = Period.ofYears(year)

/**
 * [ZonedDateTime]의 월 값만을 사용하여 [Period] 인스턴스를 생성합니다.
 *
 * @return [ZonedDateTime]의 월을 나타내는 [Period] 인스턴스를 반환합니다.
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.ZonedDateTimeExtensionsTest.months
 */
val ZonedDateTime.months: Period
    get() = Period.ofMonths(monthValue)

/**
 * [ZonedDateTime]의 일 값만을 사용하여 [Period] 인스턴스를 생성합니다.
 *
 * @return [ZonedDateTime]의 일을 나타내는 [Period] 인스턴스를 반환합니다.
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.ZonedDateTimeExtensionsTest.days
 */
val ZonedDateTime.days: Period
    get() = Period.ofDays(dayOfMonth)

/**
 * [ZonedDateTime]의 시간 값만을 사용하여 [Duration] 인스턴스를 생성합니다.
 *
 * @return [ZonedDateTime]의 시간을 나타내는 [Duration] 인스턴스를 반환합니다.
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.ZonedDateTimeExtensionsTest.hours
 */
val ZonedDateTime.hours: Duration
    get() = Duration.ofHours(hour.toLong())

/**
 * [ZonedDateTime]의 분 값만을 사용하여 [Duration] 인스턴스를 생성합니다.
 *
 * @return [ZonedDateTime]의 분을 나타내는 [Duration] 인스턴스를 반환합니다.
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.ZonedDateTimeExtensionsTest.minutes
 */
val ZonedDateTime.minutes: Duration
    get() = Duration.ofMinutes(minute.toLong())

/**
 * [ZonedDateTime]의 초 값만을 사용하여 [Duration] 인스턴스를 생성합니다.
 *
 * @return [ZonedDateTime]의 초를 나타내는 [Duration] 인스턴스를 반환합니다.
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.ZonedDateTimeExtensionsTest.seconds
 */
val ZonedDateTime.seconds: Duration
    get() = Duration.ofSeconds(second.toLong())

/**
 * [ZonedDateTime]의 나노초 값만을 사용하여 밀리초 단위의 [Duration] 인스턴스를 생성합니다.
 *
 * @return [ZonedDateTime]의 밀리초를 나타내는 [Duration] 인스턴스를 반환합니다.
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.ZonedDateTimeExtensionsTest.milliseconds
 */
val ZonedDateTime.milliseconds: Duration
    get() = Duration.ofMillis(nano.toLong() / 1_000_000)

/**
 * [ZonedDateTime]의 나노초 값만을 사용하여 마이크로초 단위의 [Duration] 인스턴스를 생성합니다.
 *
 * @return [ZonedDateTime]의 마이크로초를 나타내는 [Duration] 인스턴스를 반환합니다.
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.ZonedDateTimeExtensionsTest.microseconds
 */
val ZonedDateTime.microseconds: Duration
    get() = Duration.ofNanos(nano.toLong() / 1_000)

/**
 * [ZonedDateTime]의 나노초 값을 사용하여 [Duration] 인스턴스를 생성합니다.
 *
 * @return [ZonedDateTime]의 나노초를 나타내는 [Duration] 인스턴스를 반환합니다.
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.ZonedDateTimeExtensionsTest.nanoseconds
 */
val ZonedDateTime.nanoseconds: Duration
    get() = Duration.ofNanos(nano.toLong())

/**
 * 두 [ZonedDateTime] 사이의 시간 차이를 [Duration]으로 계산합니다.
 *
 * 이 [between] 중위 함수는 리시버 `this`부터 [endZonedDateTime]까지의 시간 차이를 계산합니다.
 *
 * @receiver 시간 간격을 계산할 시작 시점
 * @param endZonedDateTime 시간 간격을 계산할 종료 시점
 * @return 두 [ZonedDateTime] 사이의 시간 차이를 나타내는 [Duration] 인스턴스를 반환합니다.
 * @throws java.lang.ArithmeticException 계산 결과가 [Duration]으로 표현할 수 없는 경우 발생합니다.
 * @since 0.13.0
 * @sample io.github.harryjhin.java.time.extension.ZonedDateTimeExtensionsTest.between
 */
infix fun ZonedDateTime.between(
    endZonedDateTime: ZonedDateTime,
): Duration {
    return Duration.between(this, endZonedDateTime)
}