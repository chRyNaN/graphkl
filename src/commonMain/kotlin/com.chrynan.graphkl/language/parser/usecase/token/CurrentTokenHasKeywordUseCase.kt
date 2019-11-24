package com.chrynan.graphkl.language.parser.usecase.token

import com.chrynan.graphkl.language.token.TokenKind

class CurrentTokenHasKeywordUseCase(
        private val getCurrentToken: GetCurrentTokenUseCase,
        private val advanceToNextToken: AdvanceToNextTokenUseCase
) {

    operator fun invoke(keyword: String): Boolean {
        val token = getCurrentToken()

        if (token.kind == TokenKind.NAME && token.value == keyword) {
            advanceToNextToken()
            return true
        }

        return false
    }
}