package com.chrynan.graphkl.language.lexer

import com.chrynan.graphkl.language.*
import com.chrynan.graphkl.error.SyntaxError
import com.chrynan.graphkl.language.token.Token
import com.chrynan.graphkl.language.token.TokenKind
import com.chrynan.graphkl.utils.getCharCodeAt
import com.chrynan.graphkl.utils.isStartOfName

class ReadNumberTokenUseCase {

    /**
     * Reads a number token from the source file, either a float
     * or an int depending on whether a decimal point appears.
     *
     * Int:   -?(0|[1-9][0-9]*)
     * Float: -?(0|[1-9][0-9]*)(\.[0-9]+)?((E|e)(+|-)?[0-9]+)?
     */
    operator fun invoke(source: Source, start: Int, firstCode: CharCode, line: Int, column: Int, previous: Token): Token {
        val body = source.body
        var code = firstCode
        var position = start
        var isFloat = false

        if (code == Minus || code == Plus) {
            // -
            code = body.getCharCodeAt(index = ++position)
        }

        if (code.value == '0') {
            // 0
            code = body.getCharCodeAt(index = ++position)

            // Number after zero (should not have zero prefix)
            if (code is Digits) throw SyntaxError(source = source, position = position, message = "Invalid number, unexpected digit after 0: ${code.value}.")
        } else {
            // Get the index of the last digit value before a non-digit value
            position = readDigits(source = source, start = position, firstCode = code)
            code = body.getCharCodeAt(index = position)
        }

        if (code == Period) {
            // .
            isFloat = true

            code = body.getCharCodeAt(index = ++position)
            position = readDigits(source, position, code)
            code = body.getCharCodeAt(index = position)
        }

        if (code.value == 'e' || code.value == 'E') {
            // E e
            isFloat = true

            code = body.getCharCodeAt(index = ++position)

            if (code == Minus || code == Plus) {
                // + -
                code = body.getCharCodeAt(index = ++position)
            }

            position = readDigits(source = source, start = position, firstCode = code)
            code = body.getCharCodeAt(index = position)
        }

        // Numbers cannot be followed by . or the start of a name
        if (code == Period || code.isStartOfName) throw SyntaxError(source = source, position = position, message = "Invalid number, expected digit but got: ${code.value}.")

        return Token(
                kind = if (isFloat) TokenKind.FLOAT else TokenKind.INT,
                start = start,
                end = position,
                line = line,
                column = column,
                previous = previous,
                value = body.slice(start..position))
    }

    /**
     * Returns the new position in the source after reading digits.
     */
    private fun readDigits(source: Source, start: Int, firstCode: CharCode): Int {
        val body = source.body
        var position = start
        var code = firstCode

        if (code is Digits) {
            // 0 - 9
            do {
                code = body.getCharCodeAt(index = ++position)
            } while (code is Digits) // 0 - 9

            return position
        }

        throw SyntaxError(source = source, position = position, message = "Invalid number, expected digit but got: ${code.value}.")
    }
}