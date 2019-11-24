package com.chrynan.graphkl.language.lexer

class GetColumnFromPositionUseCase {

    operator fun invoke(position: Int, lineStart: Int) = 1 + position - lineStart
}