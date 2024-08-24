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

class SecondOfMinute private constructor(
    val value: Int,
) : Temporal, TemporalAdjuster, Comparable<SecondOfMinute>, Serializable {

    val amounts: TemporalAmount by lazy { Duration.ofSeconds(value.toLong()) }

    companion object {
        @Suppress("ConstPropertyName")
        @java.io.Serial
        private const val serialVersionUID: Long = 5189672178772154826L

        private val PARSER: DateTimeFormatter = DateTimeFormatterBuilder()
            .parseLenient()
            .appendPattern("ss")
            .toFormatter()

        fun now(): SecondOfMinute {
            return now(clock = Clock.systemDefaultZone())
        }

        fun now(zoneId: ZoneId): SecondOfMinute {
            return now(clock = Clock.system(zoneId))
        }

        fun now(clock: Clock): SecondOfMinute {
            val now = LocalTime.now(clock)
            return of(second = now.second)
        }

        fun of(second: Int): SecondOfMinute {
            ChronoField.SECOND_OF_MINUTE.checkValidValue(second.toLong())
            return SecondOfMinute(value = second)
        }

        fun from(temporalAccessor: TemporalAccessor): SecondOfMinute {
            if (temporalAccessor is SecondOfMinute) {
                return temporalAccessor
            }
            return try {
                if (IsoChronology.INSTANCE != Chronology.from(temporalAccessor)) {
                    return of(second = LocalTime.from(temporalAccessor).second)
                }
                of(second = temporalAccessor[ChronoField.SECOND_OF_MINUTE])
            } catch (ex: DateTimeException) {
                throw DateTimeException(
                    "Unable to obtain SecondOfMinute from TemporalAccessor: $temporalAccessor of type ${temporalAccessor.javaClass.name}",
                    ex,
                )
            }
        }

        fun parse(text: CharSequence): SecondOfMinute {
            return parse(text = text, formatter = PARSER)
        }

        fun parse(text: CharSequence, formatter: DateTimeFormatter): SecondOfMinute {
            return formatter.parse(text, ::from)
        }
    }

    override fun isSupported(field: TemporalField?): Boolean {
        if (field is ChronoField) {
            return field == ChronoField.SECOND_OF_MINUTE
        }
        return field != null && field.isSupportedBy(this)
    }

    override fun isSupported(unit: TemporalUnit?): Boolean {
        if (unit is ChronoUnit) {
            return unit == ChronoUnit.SECONDS
        }
        return unit != null && unit.isSupportedBy(this)
    }

    override fun range(field: TemporalField?): ValueRange {
        return when (field) {
            ChronoField.SECOND_OF_MINUTE -> ValueRange.of(0, 59)
            else -> throw DateTimeException("Unsupported field: $field")
        }
    }

    override fun get(field: TemporalField): Int {
        return range(field).checkValidIntValue(getLong(field), field)
    }

    override fun getLong(field: TemporalField?): Long {
        return when (field) {
            ChronoField.SECOND_OF_MINUTE -> value.toLong()
            else -> throw DateTimeException("Unsupported field: $field")
        }
    }

    override fun with(adjuster: TemporalAdjuster): SecondOfMinute {
        return adjuster.adjustInto(this) as SecondOfMinute
    }

    override fun with(field: TemporalField, newValue: Long): SecondOfMinute {
        if (field is ChronoField) {
            field.checkValidValue(newValue)
            return when (field) {
                ChronoField.SECOND_OF_MINUTE -> of(second = newValue.toInt())
                else -> throw DateTimeException("Unsupported field: $field")
            }
        }
        return field.adjustInto(this, newValue) as SecondOfMinute
    }

    override fun plus(amountToAdd: TemporalAmount): SecondOfMinute {
        return amountToAdd.addTo(this) as SecondOfMinute
    }

    override fun plus(amountToAdd: Long, unit: TemporalUnit): SecondOfMinute {
        return if (unit is ChronoUnit) {
            when (unit) {
                ChronoUnit.SECONDS -> plusSeconds(secondsToAdd = amountToAdd)
                else -> throw DateTimeException("Unsupported unit: $unit")
            }
        } else {
            unit.addTo(this, amountToAdd)
        }
    }

    private fun plusSeconds(secondsToAdd: Long): SecondOfMinute {
        if (secondsToAdd == 0L) {
            return this
        }
        return of(second = ChronoField.SECOND_OF_MINUTE.checkValidIntValue(value + secondsToAdd))
    }

    override fun minus(amountToSubtract: TemporalAmount): SecondOfMinute {
        return amountToSubtract.subtractFrom(this) as SecondOfMinute
    }

    override fun minus(amountToSubtract: Long, unit: TemporalUnit): SecondOfMinute {
        return plus(amountToAdd = -amountToSubtract, unit = unit)
    }

    private fun minusSeconds(secondsToSubtract: Long): SecondOfMinute {
        return plusSeconds(secondsToAdd = -secondsToSubtract)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <R> query(query: TemporalQuery<R>): R {
        return when (query) {
            TemporalQueries.chronology() -> IsoChronology.INSTANCE as R
            TemporalQueries.precision() -> ChronoUnit.SECONDS as R
            else -> super.query(query)
        }
    }

    override fun adjustInto(temporal: Temporal): Temporal {
        if (Chronology.from(temporal) != IsoChronology.INSTANCE) {
            throw DateTimeException("Adjustment only supported on ISO date-time")
        }
        return temporal.with(ChronoField.SECOND_OF_MINUTE, value.toLong())
    }

    override fun until(endExclusive: Temporal, unit: TemporalUnit): Long {
        val end = from(temporalAccessor = endExclusive)
        if (unit is ChronoUnit) {
            val secondsUntil: Long = (end.value - value).toLong()
            return when (unit) {
                ChronoUnit.SECONDS -> secondsUntil
                else -> throw DateTimeException("Unsupported unit: $unit")
            }
        }
        return unit.between(this, end)
    }

    fun format(formatter: DateTimeFormatter): String {
        return formatter.format(this)
    }

    override fun compareTo(other: SecondOfMinute): Int {
        return value - other.value
    }

    fun isAfter(other: SecondOfMinute): Boolean {
        return value > other.value
    }

    fun isBefore(other: SecondOfMinute): Boolean {
        return value < other.value
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other is SecondOfMinute) {
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