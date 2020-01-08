package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Date.humanizeDiff(date:Date= Date()):String{
    return "tyt data"
}

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String{
    val dataFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dataFormat.format(this)
}