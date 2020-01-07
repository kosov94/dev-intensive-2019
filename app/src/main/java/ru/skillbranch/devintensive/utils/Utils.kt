package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val pair = fullName?.split(" ")
        val firstName = if (pair?.getOrNull(0)?.length != 0) pair?.getOrNull(0) else null
        val lastName = if (pair?.getOrNull(1)?.length != 0) pair?.getOrNull(1) else null
        return Pair(firstName, lastName)
    }
}