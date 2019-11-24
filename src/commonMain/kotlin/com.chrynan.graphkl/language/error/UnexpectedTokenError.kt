package com.chrynan.graphkl.language.error

import com.chrynan.graphkl.language.token.Token
import com.chrynan.graphkl.language.token.TokenKind

class UnexpectedTokenError(
        message: String? = null,
        val token: Token,
        val expectedKind: TokenKind
) : RuntimeException(message = "Unexpected Token Error: expected token with kind = $expectedKind but was actually = ${token.kind} for token = $token. Message = $message")