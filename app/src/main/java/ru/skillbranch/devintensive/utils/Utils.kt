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
            if (lastName.length != 0 && lastName[0] > ' ') initials += lastName[0].toUpperCase()
        } else
            if (firstName != null)
                initials += firstName[0].toUpperCase()
            else
                if (lastName != null)
                    initials += lastName[0].toUpperCase()
                else
                    initials = null
        if (initials.equals(""))
            return null
        return initials
    }

    fun transliteration(payload: String, divider: String = " "): String {
        var rezalt: String = ""
        for (i in payload.indices)
            when (payload[i].toLowerCase()) {
                'а' -> rezalt +=if (!payload[i].isUpperCase()) "a" else "a".toUpperCase()
                'б' -> rezalt +=if (!payload[i].isUpperCase()) "b" else "b".toUpperCase()
                'в' -> rezalt +=if (!payload[i].isUpperCase()) "v" else "v".toUpperCase()
                'г' -> rezalt +=if (!payload[i].isUpperCase()) "g" else "g".toUpperCase()
                'д' -> rezalt +=if (!payload[i].isUpperCase()) "d" else "d".toUpperCase()
                'е' -> rezalt +=if (!payload[i].isUpperCase()) "e" else "e".toUpperCase()
                'ё' -> rezalt +=if (!payload[i].isUpperCase()) "e" else "e".toUpperCase()
                'ж' -> rezalt +=if (!payload[i].isUpperCase()) "zh" else "Zh"
                'з' -> rezalt +=if (!payload[i].isUpperCase()) "z" else "z".toUpperCase()
                'и' -> rezalt +=if (!payload[i].isUpperCase()) "i" else "i".toUpperCase()
                'й' -> rezalt +=if (!payload[i].isUpperCase()) "i" else "i".toUpperCase()
                'к' -> rezalt +=if (!payload[i].isUpperCase()) "k" else "k".toUpperCase()
                'л' -> rezalt +=if (!payload[i].isUpperCase()) "l" else "l".toUpperCase()
                'м' -> rezalt +=if (!payload[i].isUpperCase()) "m" else "m".toUpperCase()
                'н' -> rezalt +=if (!payload[i].isUpperCase()) "n" else "n".toUpperCase()
                'о' -> rezalt +=if (!payload[i].isUpperCase()) "o" else "o".toUpperCase()
                'п' -> rezalt +=if (!payload[i].isUpperCase()) "p" else "p".toUpperCase()
                'р' -> rezalt +=if (!payload[i].isUpperCase()) "r" else "r".toUpperCase()
                'с' -> rezalt +=if (!payload[i].isUpperCase()) "s" else "s".toUpperCase()
                'т' -> rezalt +=if (!payload[i].isUpperCase()) "t" else "t".toUpperCase()
                'у' -> rezalt +=if (!payload[i].isUpperCase()) "u" else "u".toUpperCase()
                'ф' -> rezalt +=if (!payload[i].isUpperCase()) "f" else "f".toUpperCase()
                'х' -> rezalt +=if (!payload[i].isUpperCase()) "h" else "h".toUpperCase()
                'ц' -> rezalt +=if (!payload[i].isUpperCase()) "c" else "c".toUpperCase()
                'ч' -> rezalt +=if (!payload[i].isUpperCase()) "ch" else "Ch"
                'ш' -> rezalt +=if (!payload[i].isUpperCase()) "sh" else "Sh"
                'щ' -> rezalt +=if (!payload[i].isUpperCase()) "sh'" else "Sh"
                'ъ' -> rezalt += ""
                'ы' -> rezalt +=if (!payload[i].isUpperCase()) "i" else "i".toUpperCase()
                'ь' -> rezalt += ""
                'э' -> rezalt +=if (!payload[i].isUpperCase()) "e" else "e".toUpperCase()
                'ю' -> rezalt +=if (!payload[i].isUpperCase()) "yu" else "Yu"
                'я' -> rezalt +=if (!payload[i].isUpperCase()) "ya" else "ya"
                ' ' -> rezalt += divider
                else -> rezalt += payload[i]
            }

        return rezalt
    }
}