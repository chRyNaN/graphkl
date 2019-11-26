package com.chrynan.graphkl.language

sealed class CharCode(
        val value: Char,
        val isEscapeSequence: Boolean = false,
        val isLineTerminator: Boolean = false
)

object Bang : CharCode(value = '!')
object HashTag : CharCode(value = '#')
object Dollar : CharCode(value = '$')
object Amp : CharCode(value = '&')
object ParenL : CharCode(value = '(')
object ParenR : CharCode(value = ')')
object Colon : CharCode(value = ':')
object Equals : CharCode(value = '=')
object At : CharCode(value = '@')
object BracketL : CharCode(value = '[')
object BracketR : CharCode(value = ']')
object BraceL : CharCode(value = '{')
object BraceR : CharCode(value = '}')
object Pipeline : CharCode(value = '|')
object Minus : CharCode(value = '-')
object Plus : CharCode(value = '+')
object Underscore : CharCode(value = '_')
object Space : CharCode(value = ' ')
object Comma : CharCode(value = ',')
object Period : CharCode(value = '.')
object ForwardSlash : CharCode(value = '/')
object BackSlash : CharCode(value = '\\', isEscapeSequence = true)
object NewLine : CharCode(value = '\n', isEscapeSequence = true, isLineTerminator = true)
object CarriageReturn : CharCode(value = '\r', isEscapeSequence = true, isLineTerminator = true)
object Backspace : CharCode(value = '\b', isEscapeSequence = true)
object Tab : CharCode(value = '\t', isEscapeSequence = true)
object Quote : CharCode(value = '\"', isEscapeSequence = true)
class CapitalAToZ(value: Char) : CharCode(value = value) // A-Z
class LowercaseAToZ(value: Char) : CharCode(value = value) // a-z
class Digits(value: Char) : CharCode(value = value) // 0-9
class Other(value: Char) : CharCode(value = value) // Anything else