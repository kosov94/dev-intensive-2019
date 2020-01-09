package ru.skillbranch.devintensive.extensions

fun String.truncate(length: Int = 16): String {
    val string: String = this.trim()
    var str = ""

    if (string.length <= length) {
        for (element in string)
            str += element
    } else {
        for (i in 0 until length)
            str += string[i]
        str = str.trim()
        str += "..."
    }
    return str
}

fun String.stripHtml(): String {
    var str = ""
    val string: String = this.trim()
    var i: Int = 0
    while (i < string.length) {
        when {
            string[i] == '<' -> {
                while (string[i] != '>')
                    i++
                i++
            }
            string[i] == ' ' -> while (string[i + 1] == ' ')
                i++
            string[i] == '&' -> {
                while (string[i] != ';')
                    i++
                i++
            }
        }

        if (i < string.length)
            str += string[i]
        i++
    }
    return str

}
