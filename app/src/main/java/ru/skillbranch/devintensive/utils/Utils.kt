package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val pair = fullName?.split(" ")
        val firstName = if (pair?.getOrNull(0)?.length != 0) pair?.getOrNull(0) else null
        val lastName = if (pair?.getOrNull(1)?.length != 0) pair?.getOrNull(1) else null
        return Pair(firstName, lastName)
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var initials: String? = ""
        if (firstName != null && lastName != null) {
            if (firstName.length != 0 && firstName[0] > ' ') initials += firstName[0].toUpperCase()
            if (lastName.length != 0 && lastName[0]>' ') initials += lastName[0].toUpperCase()
        } else
            if (firstName != null)
                initials += firstName[0].toUpperCase()
            else
                if (lastName != null)
                    initials += lastName[0].toUpperCase()
                else
                    initials = null
        if(initials.equals(""))
            return null
        return initials
    }
}