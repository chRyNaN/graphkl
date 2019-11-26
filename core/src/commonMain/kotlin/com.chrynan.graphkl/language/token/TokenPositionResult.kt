package com.chrynan.graphkl.language.token

data class TokenPositionResult(
        val position: Int,
        val lexerLine: Int,
        val lexerLineStart: Int,
        val lexerColumn: Int
)