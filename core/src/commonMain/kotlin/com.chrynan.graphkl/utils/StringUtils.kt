package com.chrynan.graphkl.utils

fun String.indexOfFirst(startPosition: Int, predicate: (Char) -> Boolean): Int {
    for (index in startPosition until length) {
        if (predicate(this[index])) {
            return index
        }
    }

    return -1
}

fun getBlockStringIndentation(lines: List<String>): Int =
        lines.map { it.leadingWhitespace() }
                .minBy { it } ?: 0

fun String.leadingWhitespace(): Int = indexOfFirst { !it.isWhitespace() }

fun String.removeBlockStringIndents(): String {
    val lines = this.split(regex = Regex(pattern = "/\\r\\n|[\\n\\r]/g"))

    val commonIndent = getBlockStringIndentation(lines = lines)

    val linesWithoutIndent = if (commonIndent > 0) lines.map { it.slice(0..commonIndent) } else lines

    return linesWithoutIndent.joinToString(separator = "\n")
}