package io.github.harryjhin.java.time.extension

import io.github.harryjhin.java.time.extension.primitive.toDateTimeFormatter
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * 날짜와 시간을 특정 형식으로 포맷팅하기 위한 클래스입니다.
 * 다양한 날짜 및 시간 유형을 문자열로 변환할 수 있는 형식 패턴을 정의합니다.
 *
 * @property yearMonthPattern [YearMonth] 객체를 문자열로 변환할 때 사용할 형식 패턴
 * @property datePattern [LocalDate] 객체를 문자열로 변환할 때 사용할 형식 패턴
 * @property timePattern [LocalTime] 객체를 문자열로 변환할 때 사용할 형식 패턴
 * @property dateTimePattern [LocalDateTime] 객체를 문자열로 변환할 때 사용할 형식 패턴
 * @see JavaTimeDisplay.Default
 */
sealed class JavaTimeDisplay(
    val locale: Locale,
    val yearMonthPattern: String,
    val datePattern: String,
    val timePattern: String,
    val dateTimePattern: String,
) {

    /**
     * [YearMonth] 객체를 문자열로 변환할 때 사용할 [DateTimeFormatter] 객체입니다.
     *
     * @return [DateTimeFormatter] 객체
     */
    val yearMonthFormatter: DateTimeFormatter = yearMonthPattern.toDateTimeFormatter(locale)

    /**
     * [LocalDate] 객체를 문자열로 변환할 때 사용할 [DateTimeFormatter] 객체입니다.
     *
     * @return [DateTimeFormatter] 객체
     */
    val dateFormatter: DateTimeFormatter = datePattern.toDateTimeFormatter(locale)

    /**
     * [LocalTime] 객체를 문자열로 변환할 때 사용할 [DateTimeFormatter] 객체입니다.
     *
     * @return [DateTimeFormatter] 객체
     */
    val timeFormatter: DateTimeFormatter = timePattern.toDateTimeFormatter(locale)

    /**
     * [LocalDateTime] 객체를 문자열로 변환할 때 사용할 [DateTimeFormatter] 객체입니다.
     *
     * @return [DateTimeFormatter] 객체
     */
    val dateTimeFormatter: DateTimeFormatter = dateTimePattern.toDateTimeFormatter(locale)

    /**
     * 기본 날짜 및 시간 형식을 정의하는 객체입니다.
     *
     * @property yearMonthPattern 기본 [YearMonth] 형식: "y년 M월"
     * @property datePattern 기본 [LocalDate] 형식: "y년 M월 d일 (E)"
     * @property timePattern 기본 [LocalTime] 형식: "H시 m분 s초"
     * @property dateTimePattern 기본 [LocalDateTime] 형식: "y년 M월 d일 (E) H시 m분 s초"
     */
    companion object Default : JavaTimeDisplay(
        locale = Locale.KOREA,
        yearMonthPattern = "y년 M월",
        datePattern = "y년 M월 d일 (E)",
        timePattern = "H시 m분 s초",
        dateTimePattern = "y년 M월 d일 (E) H시 m분 s초",
    )

    /**
     * [YearMonth] 객체를 지정된 형식으로 포맷팅하여 문자열로 반환합니다.
     *
     * example:
     * ```kotlin
     * val yearMonth = YearMonth.of(2022, 1)
     * val formatted: String = JavaTimeDisplay.format(yearMonth)
     * ```
     *
     * @param yearMonth 포맷팅할 [YearMonth] 객체
     * @return 포맷팅된 문자열
     */
    fun format(yearMonth: YearMonth): String = yearMonth.format(yearMonthFormatter)

    /**
     * [LocalDate] 객체를 지정된 형식으로 포맷팅하여 문자열로 반환합니다.
     *
     * example:
     * ```kotlin
     * val date = LocalDate.of(2022, 1, 1)
     * val formatted: String = JavaTimeDisplay.format(date)
     * ```
     *
     * @param date 포맷팅할 [LocalDate] 객체
     * @return 포맷팅된 문자열
     */
    fun format(date: LocalDate): String = date.format(dateFormatter)

    /**
     * [LocalTime] 객체를 지정된 형식으로 포맷팅하여 문자열로 반환합니다.
     *
     * example:
     * ```kotlin
     * val time = LocalTime.of(0, 0, 0)
     * val formatted: String = JavaTimeDisplay.format(time)
     * ```
     *
     * @param time 포맷팅할 [LocalTime] 객체
     * @return 포맷팅된 문자열
     */
    fun format(time: LocalTime): String = time.format(timeFormatter)

    /**
     * [LocalDateTime] 객체를 지정된 형식으로 포맷팅하여 문자열로 반환합니다.
     *
     * example:
     * ```kotlin
     * val dateTime = LocalDateTime.of(2022, 1, 1, 0, 0, 0)
     * val formatted: String = JavaTimeDisplay.format(dateTime)
     * ```
     *
     * @param dateTIme 포맷팅할 [LocalDateTime] 객체
     * @return 포맷팅된 문자열
     */
    fun format(dateTIme: LocalDateTime): String = dateTIme.format(dateTimeFormatter)
}

/**
 * 제공된 [JavaTimeDisplay] 인스턴스를 기반으로, 사용자 정의 형식을 적용한 새로운 [JavaTimeDisplay] 인스턴스를 생성합니다.
 *
 * 예시:
 * ```kotlin
 * val customTimeDisplay = JavaTimeDisplay {
 *     yearMonthPattern = "yyyy년 MM월"
 *     datePattern = "yyyy년 MM월 dd일"
 *     timePattern = "HH시 mm분 ss초"
 *     dateTimePattern = "yyyy년 MM월 dd일 (E) HH시 mm분 ss초"
 * }
 * ```
 *
 * @param from 기본적으로 사용할 [JavaTimeDisplay] 객체 (기본값은 [JavaTimeDisplay.Default])
 * @param builderToAction 사용자 정의 형식을 적용할 [JavaTimeDisplayBuilder]를 구성하는 람다 함수
 * @return 사용자 정의 형식이 적용된 새로운 [JavaTimeDisplay] 객체
 */
fun JavaTimeDisplay(
    from: JavaTimeDisplay = JavaTimeDisplay,
    builderToAction: JavaTimeDisplayBuilder.() -> Unit,
): JavaTimeDisplay {
    val builder = JavaTimeDisplayBuilder(from)
    builder.builderToAction()
    return builder.build()
}

private class JavaTimeDisplayImpl(
    locale: Locale,
    yearMonthPattern: String,
    datePattern: String,
    timePattern: String,
    dateTimePattern: String,
) : JavaTimeDisplay(
    locale = locale,
    yearMonthPattern = yearMonthPattern,
    datePattern = datePattern,
    timePattern = timePattern,
    dateTimePattern = dateTimePattern,
)

/**
 * [JavaTimeDisplay] 객체를 빌드하기 위한 클래스입니다.
 * 사용자가 원하는 형식을 설정하고 [JavaTimeDisplay] 객체를 생성할 수 있습니다.
 *
 * 예시:
 * ```kotlin
 * val customTimeDisplay = JavaTimeDisplay {
 *     locale = Locale.KOREA
 *     yearMonthPattern = "yyyy년 MM월"
 *     datePattern = "yyyy년 MM월 dd일"
 *     timePattern = "HH시 mm분 ss초"
 *     dateTimePattern = "yyyy년 MM월 dd일 (E) HH시 mm분 ss초"
 * }
 * ```
 *
 * @param javaTimeDisplay 초기 값을 설정할 [JavaTimeDisplay] 객체
 */
class JavaTimeDisplayBuilder internal constructor(
    javaTimeDisplay: JavaTimeDisplay,
) {
    /**
     * [JavaTimeDisplay] 객체를 생성할 때 사용할 로케일입니다.
     *
     * 기본값은 [Locale.KOREA]입니다.
     */
    var locale: Locale = javaTimeDisplay.locale

    /**
     * [YearMonth] 객체를 문자열로 변환할 때 사용할 형식 패턴입니다.
     *
     * 기본값은 "y년 M월"입니다.
     *
     * 예시:
     * ```kotlin
     * yearMonthPattern = "yyyy년 MM월"
     * ```
     */
    var yearMonthPattern: String = javaTimeDisplay.yearMonthPattern
        set(value) {
            value.toDateTimeFormatter()
            field = value
        }

    /**
     * [LocalDate] 객체를 문자열로 변환할 때 사용할 형식 패턴입니다.
     *
     * 기본값은 "y년 M월 d일 (E)"입니다.
     *
     * 예시:
     * ```kotlin
     * datePattern = "yyyy년 MM월 dd일"
     * ```
     */
    var datePattern: String = javaTimeDisplay.datePattern
        set(value) {
            value.toDateTimeFormatter()
            field = value
        }

    /**
     * [LocalTime] 객체를 문자열로 변환할 때 사용할 형식 패턴입니다.
     *
     * 기본값은 "H시 m분 s초"입니다.
     *
     * 예시:
     * ```kotlin
     * timePattern = "HH시 mm분 ss초"
     * ```
     */
    var timePattern: String = javaTimeDisplay.timePattern
        set(value) {
            value.toDateTimeFormatter()
            field = value
        }

    /**
     * [LocalDateTime] 객체를 문자열로 변환할 때 사용할 형식 패턴입니다.
     *
     * 기본값은 "y년 M월 d일 (E) H시 m분 s초"입니다.
     *
     * 예시:
     * ```kotlin
     * dateTimePattern = "yyyy년 MM월 dd일 (E) HH시 mm분 ss초"
     * ```
     */
    var dateTimePattern: String = javaTimeDisplay.dateTimePattern
        set(value) {
            value.toDateTimeFormatter()
            field = value
        }

    /**
     * 설정된 형식 패턴을 사용하여 새로운 [JavaTimeDisplay] 객체를 생성합니다.
     *
     * @return 사용자 정의 형식이 적용된 새로운 [JavaTimeDisplay] 객체
     */
    internal fun build(): JavaTimeDisplay = JavaTimeDisplayImpl(
        locale = locale,
        yearMonthPattern = yearMonthPattern,
        datePattern = datePattern,
        timePattern = timePattern,
        dateTimePattern = dateTimePattern,
    )
}