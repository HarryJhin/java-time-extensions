package io.github.harryjhin.java.time.extension

import java.io.InvalidObjectException
import java.io.ObjectInputStream
import java.io.Serializable
import java.time.Clock
import java.time.DateTimeException
import java.time.Duration
import java.time.LocalTime
import java.time.ZoneId
import java.time.chrono.Chronology
import java.time.chrono.IsoChronology
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoField
import java.time.temporal.ChronoUnit
import java.time.temporal.Temporal
import java.time.temporal.TemporalAccessor
import java.time.temporal.TemporalAdjuster
import java.time.temporal.TemporalAmount
import java.time.temporal.TemporalField
import java.time.temporal.TemporalQueries
import java.time.temporal.TemporalQuery
import java.time.temporal.TemporalUnit
import java.time.temporal.UnsupportedTemporalTypeException
import java.time.temporal.ValueRange

/**
 * A time-based amount representing an hour within a day.
 *
 * This class represents a single hour in the range 0 to 23.
 * It can be used to represent and manipulate hour values in isolation.
 * The [HourOfDay] class is immutable and thread-safe.
 *
 * @since 0.2.0
 * @see java.time.LocalTime
 * @see java.time.temporal.ChronoField.HOUR_OF_DAY
 */
class HourOfDay private constructor(
    val value: Int,
) : Temporal, TemporalAdjuster, Comparable<HourOfDay>, Serializable {

    /**
     * Gets the [TemporalAmount] representation of this hour.
     *
     * This returns a duration of the number of hours.
     *
     * @return [TemporalAmount] instance
     */
    val amounts: TemporalAmount by lazy { Duration.ofHours(value.toLong()) }

    companion object {
        @Suppress("ConstPropertyName")
        @java.io.Serial
        private const val serialVersionUID: Long = 5681996350812234538L

        private val PARSER: DateTimeFormatter = DateTimeFormatterBuilder()
            .parseLenient()
            .appendPattern("HH")
            .toFormatter()

        /**
         * Obtains the current hour from the system clock in the default time-zone.
         *
         * This will query the [java.time.Clock.systemDefaultZone] clock in the default
         * time-zone to obtain the current hour.
         *
         * @return the current hour using the system clock, not null
         */
        fun now(): HourOfDay {
            return now(clock = Clock.systemDefaultZone())
        }

        /**
         * Obtains the current hour from the system clock in the specified time-zone.
         *
         * This will query the [java.time.Clock.system] clock to obtain the current hour.
         *
         * @param zoneId  the zone ID to use, not null
         * @return the current hour using the system clock, not null
         */
        fun now(zoneId: ZoneId): HourOfDay {
            return now(clock = Clock.system(zoneId))
        }

        /**
         * Obtains the current hour from the specified clock.
         *
         * This will query the specified clock to obtain the current hour.
         *
         * @param clock  the clock to use, not null
         * @return the current hour, not null
         */
        fun now(clock: Clock): HourOfDay {
            val now = LocalTime.now(clock)
            return of(hour = now.hour)
        }

        /**
         * Obtains an instance of [HourOfDay] from an hour-of-day value.
         *
         * @param hour  the hour-of-day to represent, from 0 to 23
         * @return the hour, not null
         * @throws DateTimeException if the hour value is invalid
         */
        fun of(hour: Int): HourOfDay {
            ChronoField.HOUR_OF_DAY.checkValidValue(hour.toLong())
            return HourOfDay(value = hour)
        }

        /**
         * Obtains an instance of [HourOfDay] from a temporal object.
         *
         * @param temporalAccessor  the temporal object to convert, not null
         * @return the hour, not null
         * @throws DateTimeException if unable to convert to an [HourOfDay]
         */
        fun from(temporalAccessor: TemporalAccessor): HourOfDay {
            if (temporalAccessor is HourOfDay) {
                return temporalAccessor
            }
            return try {
                if (IsoChronology.INSTANCE != Chronology.from(temporalAccessor)) {
                    return of(LocalTime.from(temporalAccessor).hour)
                }
                of(temporalAccessor[ChronoField.HOUR_OF_DAY])
            } catch (ex: DateTimeException) {
                throw DateTimeException(
                    "Unable to obtain Hour from TemporalAccessor: $temporalAccessor of type ${temporalAccessor.javaClass.name}",
                    ex,
                )
            }
        }

        /**
         * Obtains an instance of [HourOfDay] from a text string.
         *
         * @param text  the text to parse such as "13", not null
         * @return the parsed hour, not null
         * @throws DateTimeParseException if the text cannot be parsed
         */
        fun parse(text: CharSequence): HourOfDay {
            return parse(text = text, formatter = PARSER)
        }

        /**
         * Obtains an instance of [HourOfDay] from a text string using a specific formatter.
         *
         * @param text  the text to parse, not null
         * @param formatter  the formatter to use, not null
         * @return the parsed hour, not null
         * @throws DateTimeParseException if the text cannot be parsed
         */
        fun parse(text: CharSequence, formatter: DateTimeFormatter): HourOfDay {
            return formatter.parse(text, HourOfDay::from)
        }
    }

    /**
     * Checks if the specified field is supported.
     *
     * This checks if this hour can be queried for the specified field.
     * If false, then calling the [range], [get] and [with] methods will throw an exception.
     *
     * If the field is a [ChronoField] then the query is implemented here.
     * The supported fields are:
     * - [ChronoField.HOUR_OF_AMPM]
     * - [ChronoField.CLOCK_HOUR_OF_AMPM]
     * - [ChronoField.HOUR_OF_DAY]
     * - [ChronoField.CLOCK_HOUR_OF_DAY]
     *
     * All other [ChronoField] instances will return false.
     *
     * If the field is not a [ChronoField], then the result of this method
     * is obtained by invoking [TemporalField.isSupportedBy] passing `this` as the argument.
     * Whether the field is supported is determined by the field.
     *
     * @param field  the field to check, null returns false
     * @return true if the field can be queried, false if not
     */
    override fun isSupported(field: TemporalField?): Boolean {
        if (field is ChronoField) {
            return field in arrayOf(
                ChronoField.HOUR_OF_AMPM,
                ChronoField.CLOCK_HOUR_OF_AMPM,
                ChronoField.HOUR_OF_DAY,
                ChronoField.CLOCK_HOUR_OF_DAY,
            )
        }
        return field != null && field.isSupportedBy(this)
    }

    /**
     * Checks if the specified unit is supported.
     *
     * This checks if the specified unit can be added to this hour.
     * If false, then calling the [plus] and [minus] methods will throw an exception.
     *
     * If the unit is a [ChronoUnit] then the query is implemented here.
     * The supported units are:
     * - [ChronoUnit.HOURS]
     *
     * All other [ChronoUnit] instances will return false.
     *
     * If the unit is not a [ChronoUnit], then the result of this method
     * is obtained by invoking [TemporalUnit.isSupportedBy] passing `this` as the argument.
     * Whether the unit is supported is determined by the unit.
     *
     * @param unit  the unit to check, null returns false
     * @return true if the unit can be added, false if not
     */
    override fun isSupported(unit: TemporalUnit?): Boolean {
        if (unit is ChronoUnit) {
            return unit == ChronoUnit.HOURS
        }
        return unit != null && unit.isSupportedBy(this)
    }

    /**
     * Gets the range of valid values for the specified field.
     *
     * The range object expresses the minimum and maximum valid values for a field.
     * This hour is used to enhance the accuracy of the returned range.
     * If it is not possible to return the range, because the field is not supported
     * or for some other reason, an exception is thrown.
     *
     * If the field is a [ChronoField] then the query is implemented here.
     * The [isSupported] will return appropriate range instances.
     * All other [ChronoField] instances will throw an [UnsupportedTemporalTypeException].
     *
     * If the field is not a [ChronoField], then the result of this method
     * is obtained by invoking [TemporalField.rangeRefinedBy]
     * passing `this` as the argument.
     * Whether the range can be obtained is determined by the field.
     *
     * @param field  the field to query the range for, not null
     * @return the range of valid values for the field, not null
     * @throws DateTimeException if the range for the field cannot be obtained
     * @throws UnsupportedTemporalTypeException if the field is not supported
     */
    override fun range(field: TemporalField?): ValueRange {
        return when (field) {
            ChronoField.HOUR_OF_DAY -> ValueRange.of(0, 23)
            ChronoField.CLOCK_HOUR_OF_DAY -> ValueRange.of(1, 24)
            ChronoField.HOUR_OF_AMPM -> ValueRange.of(0, 11)
            ChronoField.CLOCK_HOUR_OF_AMPM -> ValueRange.of(1, 12)
            else -> super.range(field)
        }
    }

    /**
     * Gets the value of the specified field from this hour as an [Int].
     *
     * This queries this hour for the value for the specified field.
     * The returned value will always be within the valid range of values for the field.
     * If it is not possible to return the value, because the field is not supported
     * or for some other reason, an exception is thrown.
     *
     * If the field is a [ChronoField] then the query is implemented here.
     * The [isSupported] will return valid values based on this hour.
     * All other [ChronoField] instances will throw an [UnsupportedTemporalTypeException].
     *
     * If the field is not a [ChronoField], then the result of this method
     * is obtained by invoking [TemporalField.getFrom]
     * passing `this` as the argument.
     * Whether the value can be obtained, and what the value represents, is determined by the field.
     *
     * @param field  the field to get, not null
     * @return the value for the field, within the valid range of the field
     * @throws DateTimeException if a value for the field cannot be obtained or
     *         the value is outside the range of valid values for the field
     * @throws UnsupportedTemporalTypeException if the field is not supported or
     *         the range of values exceeds an [Int]
     * @throws ArithmeticException if numeric overflow occurs
     */
    override fun get(field: TemporalField): Int {
        return range(field).checkValidIntValue(getLong(field), field)
    }

    override fun getLong(field: TemporalField): Long {
        if (field is ChronoField) {
            return when (field) {
                ChronoField.HOUR_OF_AMPM -> value % 12L
                ChronoField.CLOCK_HOUR_OF_AMPM -> (value % 12L) + 1
                ChronoField.HOUR_OF_DAY -> value.toLong()
                ChronoField.CLOCK_HOUR_OF_DAY -> value + 1L
                else -> throw UnsupportedTemporalTypeException("Unsupported field: $field")
            }
        }
        return field.getFrom(this)
    }

    override fun with(adjuster: TemporalAdjuster): HourOfDay {
        return adjuster.adjustInto(this) as HourOfDay
    }

    override fun with(field: TemporalField, newValue: Long): Temporal {
        if (field is ChronoField) {
            field.checkValidValue(newValue)
            return when (field) {
                ChronoField.HOUR_OF_AMPM -> of((value % 12 + newValue).toInt())
                ChronoField.CLOCK_HOUR_OF_AMPM -> of((value % 12 + newValue - 1).toInt())
                ChronoField.HOUR_OF_DAY -> of(newValue.toInt())
                ChronoField.CLOCK_HOUR_OF_DAY -> of((newValue - 1).toInt())
                else -> throw UnsupportedTemporalTypeException("Unsupported field: $field")
            }
        }
        return field.adjustInto(this, newValue)
    }

    override fun plus(amountToAdd: TemporalAmount): HourOfDay {
        return amountToAdd.addTo(this) as HourOfDay
    }

    override fun plus(amountToAdd: Long, unit: TemporalUnit): HourOfDay {
        if (unit is ChronoUnit) {
            return when (unit) {
                ChronoUnit.HOURS -> plusHours(hoursToAdd = amountToAdd)
                ChronoUnit.MINUTES -> plusHours(hoursToAdd = amountToAdd / 60)
                ChronoUnit.SECONDS -> plusHours(hoursToAdd = amountToAdd / 3600)
                ChronoUnit.MILLIS -> plusHours(hoursToAdd = amountToAdd / 3_600_000)
                ChronoUnit.MICROS -> plusHours(hoursToAdd = amountToAdd / 3_600_000_000)
                ChronoUnit.NANOS -> plusHours(hoursToAdd = amountToAdd / 3_600_000_000_000)
                else -> throw UnsupportedTemporalTypeException("Unsupported unit: $unit")
            }
        }
        return unit.addTo(this, amountToAdd)
    }

    private fun plusHours(hoursToAdd: Long): HourOfDay {
        if (hoursToAdd == 0L) {
            return this
        }
        return of(hour = ChronoField.HOUR_OF_DAY.checkValidIntValue(value + hoursToAdd))
    }

    override fun minus(amountToSubtract: TemporalAmount): HourOfDay {
        return amountToSubtract.subtractFrom(this) as HourOfDay
    }

    override fun minus(amountToSubtract: Long, unit: TemporalUnit): HourOfDay {
        return plus(amountToAdd = -amountToSubtract, unit = unit)
    }

    private fun minusHours(hoursToSubtract: Long): HourOfDay {
        return plusHours(hoursToAdd = -hoursToSubtract)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <R> query(query: TemporalQuery<R>): R {
        return when (query) {
            TemporalQueries.chronology() -> IsoChronology.INSTANCE as R
            TemporalQueries.precision() -> ChronoUnit.HOURS as R
            else -> super.query(query)
        }
    }

    override fun adjustInto(temporal: Temporal): Temporal {
        if (Chronology.from(temporal) != IsoChronology.INSTANCE) {
            throw DateTimeException("Adjustment only supported on ISO date-time")
        }
        return temporal.with(ChronoField.HOUR_OF_DAY, value.toLong())
    }

    override fun until(endExclusive: Temporal, unit: TemporalUnit): Long {
        val end = from(endExclusive)
        if (unit is ChronoUnit) {
            val hoursUntil: Long = end.value.toLong() - value
            return when (unit) {
                ChronoUnit.HOURS -> hoursUntil
                else -> throw UnsupportedTemporalTypeException("Unsupported unit: $unit")
            }
        }
        return unit.between(this, end)
    }

    fun format(formatter: DateTimeFormatter): String {
        return formatter.format(this)
    }

    override fun compareTo(other: HourOfDay): Int {
        return value - other.value
    }

    /**
     * Checks if this hour is after the specified hour.
     *
     * @param other  the other hour to compare to, not null
     * @return true if this is after the specified hour
     */
    fun isAfter(other: HourOfDay): Boolean {
        return value > other.value
    }

    /**
     * Checks if this hour is before the specified hour.
     *
     * @param other  the other hour to compare to, not null
     * @return true if this is before the specified hour
     */
    fun isBefore(other: HourOfDay): Boolean {
        return value < other.value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other is HourOfDay) {
            return value == other.value
        }
        return false
    }

    override fun hashCode(): Int {
        return value
    }

    /**
     * Outputs this hour as a [String].
     *
     * @return a string representation of this hour, not null
     */
    override fun toString(): String {
        return "%02d".format(value)
    }

    @Suppress("UNUSED_PARAMETER")
    @java.io.Serial
    private fun readObject(s: ObjectInputStream) {
        throw InvalidObjectException("Deserialization via serialization delegate")
    }
}