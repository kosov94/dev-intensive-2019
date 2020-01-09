package ru.skillbranch.devintensive.extensions

fun String.truncate(length: Int = 16): String {
    val string: String = this.trim()
    var str = ""

    if (string.length <= length) {
        for (element in string)
            str += element
    }
    else{
        for(i in 0 until length)
            str+=string[i]
        str=str.trim()
        str+="..."
    }
    return str
}