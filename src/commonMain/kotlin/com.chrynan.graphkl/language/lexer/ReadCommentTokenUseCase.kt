package com.chrynan.graphkl.language.lexer

import com.chrynan.graphkl.language.Source
import com.chrynan.graphkl.language.token.Token
import com.chrynan.graphkl.language.token.TokenKind
import com.chrynan.graphkl.utils.charCode
import com.chrynan.graphkl.utils.indexOfFirst

class ReadCommentTokenUseCase {

    /**
     * Reads a comment token from the source file.
     *
     * #[\u0009\u0020-\uFFFF]*
     */
    operator fun invoke(source: Source, start: Int, line: Int, column: Int, previous: Token): Token {
        val body = source.body

        val end = body.indexOfFirst(startPosition = start) {
            val charCode = it.charCode

            !charCode.isLineTerminator
        }

        return Token(
                kind = TokenKind.COMMENT,
                start = start,
                end = end,
                line = line,
                column = column,
                previous = previous,
                value = body.slice((start + 1)..end))
    }
}