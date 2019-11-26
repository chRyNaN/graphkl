package com.chrynan.graphkl.language.parser.usecase.token

import com.chrynan.graphkl.language.error.UnexpectedTokenError
import com.chrynan.graphkl.language.lexer.Lexer
import com.chrynan.graphkl.language.token.Token
import com.chrynan.graphkl.language.token.TokenKind

class GetNextExpectedTokenByKeywordUseCase(private val lexer: Lexer) {

    operator fun invoke(keyword: String): Token {
        val token = lexer.readNextToken()

        if (token.kind != TokenKind.NAME || token.value != keyword) throw UnexpectedTokenError(
                token = token,
                expectedKind = TokenKind.NAME,
                message = "Expected Token with value = $keyword")

        return token
    }
}