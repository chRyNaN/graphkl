package com.chrynan.graphkl.language.token

data class TokenResult(
        val token: Token,
        val lexerLine: Int,
        val lexerLineStart: Int
)