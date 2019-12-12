package com.chrynan.graphkl.error

import com.chrynan.graphkl.language.token.Token
import com.chrynan.graphkl.language.token.TokenKind

/**
 * A [GraphQLError] indicating that an unexpected token was reached when parsing the tokens from the lexer.
 *
 * @author chRyNaN
 */
class UnexpectedTokenError(
        message: String,
        val token: Token,
        val expectedKind: TokenKind
) : GraphQLThrowableError(message = "UnexpectedTokenError: message = $message; token = $token; expectedKind = $expectedKind")