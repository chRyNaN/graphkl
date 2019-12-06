package com.chrynan.graphkl.language.parser.usecase.token

import com.chrynan.graphkl.language.lexer.Lexer

class AdvanceToNextTokenUseCase(private val lexer: Lexer) {

    operator fun invoke() {
        lexer.advance()
    }
}