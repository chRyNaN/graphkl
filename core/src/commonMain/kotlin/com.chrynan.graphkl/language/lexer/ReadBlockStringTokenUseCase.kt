package com.chrynan.graphkl.language.lexer

import com.chrynan.graphkl.language.*
import com.chrynan.graphkl.error.SyntaxError
import com.chrynan.graphkl.language.token.Token
import com.chrynan.graphkl.language.token.TokenKind
import com.chrynan.graphkl.language.token.TokenResult
import com.chrynan.graphkl.utils.getCharCodeAt
import com.chrynan.graphkl.utils.removeBlockStringIndents

class ReadBlockStringTokenUseCase {

    /**
     * Reads a block string token from the source file.
     *
     * """("?"?(\\"""|\\(?!=""")|[^"\\]))*"""
     */
    operator fun invoke(source: Source, start: Int, line: Int, column: Int, previous: Token, lineStart: Int): TokenResult {
        val body = source.body
        var position = start + 3
        var chunkStart = position
        var rawValue = ""
        var newLexerLine = line
        var newLexerLineStart = lineStart

        while (position < body.length) {
            val charCode = body.getCharCodeAt(index = position)

            // Closing Triple-Quote (""")
            if (charCode is Quote &&
                    body.getCharCodeAt(index = position + 1) is Quote &&
                    body.getCharCodeAt(index = position + 2) is Quote) {
                rawValue += body.slice(chunkStart..position)

                val token = Token(
                        kind = TokenKind.BLOCK_STRING,
                        start = start,
                        end = position + 3,
                        line = line,
                        column = column,
                        previous = previous,
                        value = rawValue.removeBlockStringIndents())

                return TokenResult(token = token, lexerLine = newLexerLine, lexerLineStart = newLexerLineStart)
            }

            if (charCode is NewLine) {
                // new line
                ++position
                ++newLexerLine
                newLexerLineStart = position
            } else if (charCode is CarriageReturn) {
                // carriage return
                if (body.getCharCodeAt(index = position + 1) is NewLine) {
                    position += 2
                } else {
                    ++position
                }
                ++newLexerLine
                newLexerLineStart = position
            } else if (
            // Escape Triple-Quote (\""")
                    charCode == BackSlash &&
                    body.getCharCodeAt(index = position + 1) is Quote &&
                    body.getCharCodeAt(index = position + 2) is Quote &&
                    body.getCharCodeAt(index = position + 3) is Quote
            ) {
                rawValue += body.slice(chunkStart..position) + "\"\"\""
                position += 4
                chunkStart = position
            } else {
                ++position
            }
        }

        throw SyntaxError(source = source, position = position, message = "Unterminated string.")
    }
}