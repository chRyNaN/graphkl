package com.chrynan.graphkl.language.parser.usecase.token

import com.chrynan.graphkl.language.lexer.Lexer

class PeekNextTokenUseCase(private val lexer: Lexer) {

    operator fun invoke() = lexer.lookahead()?.token
}