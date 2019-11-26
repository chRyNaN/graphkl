package com.chrynan.graphkl.utils

import com.chrynan.graphkl.language.*

private val digitsRegex = Regex(pattern = "[0-9]")
private val lowerCaseRegex = Regex(pattern = "[a-z]")
private val capitalRegex = Regex(pattern = "[A-Z]")

private val Char.isDigit: Boolean
    get() = digitsRegex matches "$this"

private val Char.isLowerCase: Boolean
    get() = lowerCaseRegex matches "$this"

private val Char.isCapital: Boolean
    get() = capitalRegex matches "$this"

private val staticCharCodeValues: List<CharCode>
    get() = listOf(
            Bang,
            HashTag,
            Dollar,
            Amp,
            ParenL,
            ParenR,
            Colon,
            Equals,
            At,
            BracketL,
            BracketR,
            BraceL,
            BraceR,
            Pipeline,
            Minus,
            Plus,
            Underscore,
            Space,
            Comma,
            Period,
            ForwardSlash,
            BackSlash,
            NewLine,
            CarriageReturn,
            Backspace,
            Tab)

val CharCode.isStartOfName
    get() = (this == Underscore || this is CapitalAToZ || this is LowercaseAToZ)

val Char.charCode: CharCode
    get() = staticCharCodeValues.firstOrNull { this == it.value } ?: when {
        isDigit -> Digits(value = this)
        isLowerCase -> LowercaseAToZ(value = this)
        isCapital -> CapitalAToZ(value = this)
        else -> Other(value = this)
    }

fun String.getCharCodeAt(index: Int): CharCode = this[index].charCode