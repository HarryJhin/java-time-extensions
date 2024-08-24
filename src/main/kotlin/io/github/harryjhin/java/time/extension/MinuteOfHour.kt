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
import java.time.temporal.ValueRange

class MinuteOfHour private constructor(
    val value: Int,
) : Temporal, TemporalAdjuster, Comparable<HourOfDay>, Serializable {

    val amounts: TemporalAmount by lazy { Duration.ofMinutes(value.toLong()) }

    companion object {
        @Suppress("ConstPropertyName")
        @java.io.Serial
        private const val serialVersionUID: Long = 5189672178772154825L

        private val PARSER: DateTimeFormatter = DateTimeFormatterBuilder()
            .parseLenient()
            .appendPattern("mm")
            .toFormatter()

        fun now(): MinuteOfHour {
            return now(clock = Clock.systemDefaultZone())
        }

        fun now(zoneId: ZoneId): MinuteOfHour {
            return now(clock = Clock.system(zoneId))
        }

        fun now(clock: Clock): MinuteOfHour {
            val now = LocalTime.now(clock)
            return of(minute = now.minute)
        }

        fun of(minute: Int): MinuteOfHour {
            ChronoField.MINUTE_OF_HOUR.checkValidValue(minute.toLong())
            return MinuteOfHour(value = minute)
        }

        fun from(temporalAccessor: TemporalAccessor): MinuteOfHour {
            if (temporalAccessor is MinuteOfHour) {
                return temporalAccessor
            }
            return try {
                if (IsoChronology.INSTANCE != Chronology.from(temporalAccessor)) {
                    return of(minute = LocalTime.from(temporalAccessor).minute)
                }
                of(minute = temporalAccessor[ChronoField.MINUTE_OF_HOUR])
            } catch (ex: DateTimeException) {
                throw DateTimeException(
                    "Unable to obtain MinuteOfHour from TemporalAccessor: $temporalAccessor of type ${temporalAccessor.javaClass.name}",
                    ex,
                )
            }
        }

        fun parse(text: CharSequence): MinuteOfHour {
            return parse(text = text, formatter = PARSER)
        }

        fun parse(text: CharSequence, formatter: DateTimeFormatter): MinuteOfHour {
            return formatter.parse(text, ::from)
        }
    }

    override fun isSupported(field: TemporalField?): Boolean {
        if (field is ChronoField) {
            return field == ChronoField.MINUTE_OF_HOUR
        }
        return field != null && field.isSupportedBy(this)
    }

    override fun isSupported(unit: TemporalUnit?): Boolean {
        if (unit is ChronoUnit) {
            return unit == ChronoUnit.MINUTES
        }
        return unit != null && unit.isSupportedBy(this)
    }

    override fun range(field: TemporalField?): ValueRange {
        return when (field) {
            ChronoField.MINUTE_OF_HOUR -> ValueRange.of(0, 59)
            else -> throw DateTimeException("Unsupported field: $field")
        }
    }

    override fun get(field: TemporalField): Int {
        return range(field).checkValidIntValue(getLong(field), field)
    }

    override fun getLong(field: TemporalField?): Long {
        return when (field) {
            ChronoField.MINUTE_OF_HOUR -> value.toLong()
            else -> throw DateTimeException("Unsupported field: $field")
        }
    }

    override fun with(adjuster: TemporalAdjuster): MinuteOfHour {
        return adjuster.adjustInto(this) as MinuteOfHour
    }

    override fun with(field: TemporalField, newValue: Long): MinuteOfHour {
        if (field is ChronoField) {
            field.checkValidValue(newValue)
            return when (field) {
                ChronoField.MINUTE_OF_HOUR -> of(minute = newValue.toInt())
                else -> throw DateTimeException("Unsupported field: $field")
            }
        }
        return field.adjustInto(this, newValue) as MinuteOfHour
    }

    override fun plus(amountToAdd: TemporalAmount): MinuteOfHour {
        return amountToAdd.addTo(this) as MinuteOfHour
    }

    override fun plus(amountToAdd: Long, unit: TemporalUnit): MinuteOfHour {
        return if (unit is ChronoUnit) {
            when (unit) {
                ChronoUnit.MINUTES -> plusMinutes(minutesToAdd = amountToAdd)
                else -> throw DateTimeException("Unsupported unit: $unit")
            }
        } else {
            unit.addTo(this, amountToAdd)
        }
    }

    private fun plusMinutes(minutesToAdd: Long): MinuteOfHour {
        if (minutesToAdd == 0L) {
            return this
        }
        return of(minute = ChronoField.MINUTE_OF_HOUR.checkValidIntValue(value + minutesToAdd))
    }

    override fun minus(amountToSubtract: TemporalAmount): MinuteOfHour {
        return amountToSubtract.subtractFrom(this) as MinuteOfHour
    }

    override fun minus(amountToSubtract: Long, unit: TemporalUnit): MinuteOfHour {
        return plus(amountToAdd = -amountToSubtract, unit = unit)
    }

    private fun minusMinutes(minutesToSubtract: Long): MinuteOfHour {
        return plusMinutes(minutesToAdd = -minutesToSubtract)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <R> query(query: TemporalQuery<R>): R {
        return when (query) {
            TemporalQueries.chronology() -> IsoChronology.INSTANCE as R
            TemporalQueries.precision() -> ChronoUnit.MINUTES as R
            else -> super.query(query)
        }
    }

    override fun adjustInto(temporal: Temporal): Temporal {
        if (Chronology.from(temporal) != IsoChronology.INSTANCE) {
            throw DateTimeException("Adjustment only supported on ISO date-time")
        }
        return temporal.with(ChronoField.MINUTE_OF_HOUR, value.toLong())
    }

    override fun until(endExclusive: Temporal, unit: TemporalUnit): Long {
        val end = from(temporalAccessor = endExclusive)
        if (unit is ChronoUnit) {
            val minutesUntil: Long = (end.value - value).toLong()
            return when (unit) {
                ChronoUnit.MINUTES -> minutesUntil
                else -> throw DateTimeException("Unsupported unit: $unit")
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

    fun isAfter(other: HourOfDay): Boolean {
        return value > other.value
    }

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

    override fun toString(): String {
        return "%02d".format(value)
    }

    @Suppress("UNUSED_PARAMETER")
    @java.io.Serial
    private fun readObject(s: ObjectInputStream) {
        throw InvalidObjectException("Deserialization via serialization delegate")
    }
}