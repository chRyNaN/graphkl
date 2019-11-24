package com.chrynan.graphkl.language.lexer

import com.chrynan.graphkl.language.*
import com.chrynan.graphkl.language.token.TokenPositionResult
import com.chrynan.graphkl.utils.getCharCodeAt

class GetPositionAfterWhitespaceUseCase(private val getColumnFromPosition: GetColumnFromPositionUseCase) {

    /**
     * Reads from body starting at start until it finds a non-whitespace
     * character, then returns the position of that character for lexing.
     */
    operator fun invoke(body: String, start: Int, line: Int, lineStart: Int): TokenPositionResult {
        val bodyLength = body.length
        var position = start
        var lexerLine = line
        var lexerLineStart = lineStart

        while (position < bodyLength) {
            val code = body.getCharCodeAt(index = position)

            // tab | space | comma | BOM
            if (code is Tab || code is Space || code is Comma) {
                ++position
            } else if (code is NewLine) {
                // new line
                ++position
                ++lexerLine
                lexerLineStart = position
            } else if (code is CarriageReturn) {
                // carriage return
                if (body.getCharCodeAt(index = position + 1) is NewLine) {
                    position += 2
                } else {
                    ++position
                }

                ++lexerLine
                lexerLineStart = position
            } else {
                break
            }
        }

        val column = getColumnFromPosition(position = position, lineStart = lineStart)

        return TokenPositionResult(position = position, lexerLine = lexerLine, lexerLineStart = lexerLineStart, lexerColumn = column)
    }
}