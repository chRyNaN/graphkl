package com.chrynan.graphkl.language.lexer

import com.chrynan.graphkl.language.*
import com.chrynan.graphkl.language.error.SyntaxError
import com.chrynan.graphkl.language.token.Token
import com.chrynan.graphkl.language.token.TokenKind
import com.chrynan.graphkl.utils.getCharCodeAt

class ReadStringTokenUseCase {

    /**
     * Reads a string token from the source file.
     *
     * "([^"\\\u000A\u000D]|(\\(u[0-9a-fA-F]{4}|["\\/bfnrt])))*"
     */
    operator fun invoke(source: Source, start: Int, line: Int, column: Int, previous: Token): Token {
        val body = source.body
        var position = start + 1
        var chunkStart = position
        var value = ""

        while (position < body.length && !body.getCharCodeAt(index = position).isLineTerminator) {
            val charCode = body.getCharCodeAt(index = position)

            if (charCode.isLineTerminator) break

            if (charCode is Quote) {
                value += body.slice(chunkStart..position)

                return Token(
                        kind = TokenKind.STRING,
                        start = start,
                        end = position + 1,
                        line = line,
                        column = column,
                        previous = previous,
                        value = value)
            }

            ++position

            if (charCode is BackSlash) {
                value += body.slice(chunkStart until position)

                val nextCharCode = body.getCharCodeAt(index = position)

                when {
                    nextCharCode == BackSlash ||
                            nextCharCode == ForwardSlash ||
                            nextCharCode is Quote ||
                            nextCharCode.isEscapeSequence -> value += nextCharCode.value
                    else -> throw SyntaxError(source = source, position = position, message = "Invalid character escape sequence: \\${nextCharCode.value}.")
                }

                ++position
                chunkStart = position
            }
        }

        throw SyntaxError(source = source, position = position, message = "Unterminated string.")
    }
}