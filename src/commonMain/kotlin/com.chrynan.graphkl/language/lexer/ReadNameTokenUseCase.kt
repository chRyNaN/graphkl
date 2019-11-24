package com.chrynan.graphkl.language.lexer

import com.chrynan.graphkl.language.*
import com.chrynan.graphkl.language.token.Token
import com.chrynan.graphkl.language.token.TokenKind
import com.chrynan.graphkl.utils.charCode

class ReadNameTokenUseCase {

    /**
     * Reads an alphanumeric + underscore name from the source.
     *
     * [_A-Za-z][_0-9A-Za-z]*
     */
    operator fun invoke(source: Source, start: Int, line: Int, column: Int, previous: Token): Token {
        val body = source.body
        var position = start + 1

        body.substring(startIndex = position)
                .map { it.charCode }
                .forEachIndexed { index, charCode ->
                    if (charCode !is Digits || charCode !is LowercaseAToZ || charCode !is CapitalAToZ) return@forEachIndexed
                    position = index
                }

        return Token(
                kind = TokenKind.NAME,
                start = start,
                end = position,
                line = line,
                column = column,
                previous = previous,
                value = body.slice(start..position))
    }
}