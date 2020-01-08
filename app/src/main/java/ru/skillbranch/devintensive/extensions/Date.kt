package ru.skillbranch.devintensive.extensions

import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*


const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dataFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dataFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits): Date {
    var time = this.time
    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }

    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
    var time = ""
    val interval = Date().time - this.time

    when (abs(interval)) {
        in 0 * SECOND..1 * SECOND -> return "только что"
        in 1 * SECOND..45 * SECOND -> time = "несколько секунд"
        in 45 * SECOND..75 * SECOND -> time = "минуту"
        in 75 * SECOND..45 * MINUTE -> {
            val minute: Int = (abs(interval) / MINUTE).toInt()
            time = when (minute % 10) {
                1 -> "$minute минуту"
                2, 3, 4 -> "$minute минуты"
                else -> "$minute минут"
            }
        }
        in 45 * MINUTE..75 * MINUTE -> time = "час"
        in 75 * MINUTE..22 * HOUR -> {
            val hour: Int = (abs(interval) / HOUR).toInt()
            time = when (hour % 10) {
                1 -> "$hour час"
                2, 3, 4 -> "$hour часа"
                else -> "$hour часов"
            }
        }
        in 22 * HOUR..26 * HOUR -> time = "день"
        in 26 * HOUR..360 * DAY -> {
            val day: Int = (abs(interval) / DAY).toInt()
            time = when (day % 10) {
                1 -> "$day день"
                2, 3, 4 -> "$day дня"
                else -> "$day дней"
            }
        }
        else -> {
            if (interval > 0) return "более года назад" else return "более чем через год"
        }
    }
    val rezult = if (interval > 0) "$time назад" else "через $time"
    return rezult
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;

    fun plural(value: Int): String =
        when (this) {
            SECOND -> when (value % 10) {
                1 -> "$value секунду"
                2, 3, 4 -> "$value секунды"
                else -> "$value секунд"
            }
            MINUTE->when (value % 10) {
                1 -> "$value минуту"
                2, 3, 4 -> "$value минуты"
                else -> "$value минут"
            }
            HOUR->when (value % 10) {
                1 -> "$value час"
                2, 3, 4 -> "$value часа"
                else -> "$value часов"
            }
            DAY->when (value % 10) {
                1 -> "$value день"
                2, 3, 4 -> "$value дня"
                else -> "$value дней"
            }
        }

}

