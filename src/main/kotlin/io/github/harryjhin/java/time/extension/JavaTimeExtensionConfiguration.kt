package io.github.harryjhin.java.time.extension

import java.time.format.DateTimeFormatter
import java.util.Properties

/**
 * [JavaTimeExtensionConfiguration] 오브젝트는 날짜와 시간, 그리고 시간대의 형식을 지정하기 위해 다양한 패턴을 정의하고
 * 이 패턴에 따라 [DateTimeFormatter]를 제공하는 구성 객체입니다.
 *
 * 이 오브젝트는 `java-time-extensions.properties` 파일을 읽어와서 패턴을 정의하며, 파일이 존재하지 않는 경우 기본값을 사용합니다.
 *
 * 패턴 종류:
 *
 * - `yyyy`: 연도. 예) `2021`
 * - `MM`: 월. 예) `01`
 * - `dd`: 일. 예) `01`
 * - `HH`: 시간. 예) `12`
 * - `mm`: 분. 예) `30`
 * - `ss`: 초. 예) `30`
 * - `SSS`: 밀리초. 예) `500`
 * - `z`: 시간대 이름. 예) `KST`
 * - `Z`: 시간대 오프셋. 예) `+0900`
 * - `O`: 지역화된 시간대 오프셋. 예) `GMT+9`
 * - `XXX`: 시간대 오프셋. 예) `+09:00`
 * - `VV`: 시간대 ID. 예) `Asia/Seoul`
 *
 * @since 0.13.7
 */
internal object JavaTimeExtensionConfiguration {

    private val properties: Properties = Properties().apply {
        JavaTimeExtensionConfiguration::class.java.getResourceAsStream("/java-time-extensions.properties")?.run {
            load(this)
        }
    }

    /**
     * `LocalDate` 형식을 지정하는 패턴입니다. 기본값은 `yyyy-MM-dd`입니다.
     */
    val PATTERN_LOCAL_DATE: String = properties.getProperty("pattern.local-date")
        ?: "yyyy-MM-dd"

    /**
     * `LocalDateTime` 형식을 지정하는 패턴입니다. 기본값은 `yyyy-MM-dd['T'][ ]HH:mm[:ss][.SSS]`입니다.
     */
    val PATTERN_LOCAL_DATE_TIME: String = properties.getProperty("pattern.local-date-time")
        ?: "yyyy-MM-dd['T'][ ]HH:mm[:ss][.SSS]"

    /**
     * `LocalTime` 형식을 지정하는 패턴입니다. 기본값은 `HH:mm[:ss][.SSS]`입니다.
     */
    val PATTERN_LOCAL_TIME: String = properties.getProperty("pattern.local-time")
        ?: "HH:mm[:ss][.SSS]"

    /**
     * `MonthDay` 형식을 지정하는 패턴입니다. 기본값은 `[--]MM-dd`입니다.
     */
    val PATTERN_MONTH_DAY: String = properties.getProperty("pattern.month-day")
        ?: "[--]MM-dd"

    /**
     * `OffsetDateTime` 형식을 지정하는 패턴입니다. 기본값은 `yyyy-MM-dd['T'][ ]HH:mm[:ss][.SSS]XXX`입니다.
     */
    val PATTERN_OFFSET_DATE_TIME: String = properties.getProperty("pattern.offset-date-time")
        ?: "yyyy-MM-dd['T'][ ]HH:mm[:ss][.SSS]XXX"

    /**
     * `OffsetTime` 형식을 지정하는 패턴입니다. 기본값은 `HH:mm[:ss][.SSS]XXX`입니다.
     */
    val PATTERN_OFFSET_TIME: String = properties.getProperty("pattern.offset-time")
        ?: "HH:mm[:ss][.SSS]XXX"

    /**
     * `Year` 형식을 지정하는 패턴입니다. 기본값은 `yyyy`입니다.
     */
    val PATTERN_YEAR: String = properties.getProperty("pattern.year")
        ?: "yyyy"

    /**
     * `YearMonth` 형식을 지정하는 패턴입니다. 기본값은 `yyyy-MM`입니다.
     */
    val PATTERN_YEAR_MONTH: String = properties.getProperty("pattern.year-month")
        ?: "yyyy-MM"

    /**
     * `ZonedDateTime` 형식을 지정하는 패턴입니다. 기본값은 `yyyy-MM-dd['T'][ ]HH:mm[:ss][.SSS]XXX'['VV']'`입니다.
     */
    val PATTERN_ZONED_DATE_TIME: String = properties.getProperty("pattern.zoned-date-time")
        ?: "yyyy-MM-dd['T'][ ]HH:mm[:ss][.SSS]XXX'['VV']'"

    /**
     * `LocalDate` 형식을 지정하는 [DateTimeFormatter]입니다. 기본값은 `yyyy-MM-dd`입니다.
     */
    val FORMATTER_LOCAL_DATE: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_LOCAL_DATE)
    }

    /**
     * `LocalDateTime` 형식을 지정하는 [DateTimeFormatter]입니다. 기본값은 `yyyy-MM-dd['T'][ ]HH:mm[:ss][.SSS]`입니다.
     */
    val FORMATTER_LOCAL_DATE_TIME: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_LOCAL_DATE_TIME)
    }

    /**
     * `LocalTime` 형식을 지정하는 [DateTimeFormatter]입니다. 기본값은 `HH:mm[:ss][.SSS]`입니다.
     */
    val FORMATTER_LOCAL_TIME: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_LOCAL_TIME)
    }

    /**
     * `MonthDay` 형식을 지정하는 [DateTimeFormatter]입니다. 기본값은 `[--]MM-dd`입니다.
     */
    val FORMATTER_MONTH_DAY: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_MONTH_DAY)
    }

    /**
     * `OffsetDateTime` 형식을 지정하는 [DateTimeFormatter]입니다. 기본값은 `yyyy-MM-dd['T'][ ]HH:mm[:ss][.SSS]XXX`입니다.
     */
    val FORMATTER_OFFSET_DATE_TIME: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_OFFSET_DATE_TIME)
    }

    /**
     * `OffsetTime` 형식을 지정하는 [DateTimeFormatter]입니다. 기본값은 `HH:mm[:ss][.SSS]XXX`입니다.
     */
    val FORMATTER_OFFSET_TIME: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_OFFSET_TIME)
    }

    /**
     * `Year` 형식을 지정하는 [DateTimeFormatter]입니다. 기본값은 `yyyy`입니다.
     */
    val FORMATTER_YEAR: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_YEAR)
    }

    /**
     * `YearMonth` 형식을 지정하는 [DateTimeFormatter]입니다. 기본값은 `yyyy-MM`입니다.
     */
    val FORMATTER_YEAR_MONTH: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_YEAR_MONTH)
    }

    /**
     * `ZonedDateTime` 형식을 지정하는 [DateTimeFormatter]입니다. 기본값은 `yyyy-MM-dd['T'][ ]HH:mm[:ss][.SSS]XXX'['VV']'`입니다.
     */
    val FORMATTER_ZONED_DATE_TIME: DateTimeFormatter by lazy {
        DateTimeFormatter.ofPattern(PATTERN_ZONED_DATE_TIME)
    }
}