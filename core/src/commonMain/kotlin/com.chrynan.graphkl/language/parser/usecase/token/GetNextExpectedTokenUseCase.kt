package com.chrynan.graphkl.language.parser.usecase.token

import com.chrynan.graphkl.error.UnexpectedTokenError
import com.chrynan.graphkl.language.lexer.Lexer
import com.chrynan.graphkl.language.token.Token
import com.chrynan.graphkl.language.token.TokenKind

class GetNextExpectedTokenUseCase(private val lexer: Lexer) {

    operator fun invoke(expectedKind: TokenKind): Token {
        val token = lexer.readNextToken()

        if (token.kind != expectedKind) throw UnexpectedTokenError(token = token, expectedKind = expectedKind)

        return token
    }
}