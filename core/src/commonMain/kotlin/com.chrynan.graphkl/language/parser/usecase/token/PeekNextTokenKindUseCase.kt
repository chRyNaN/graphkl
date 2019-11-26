package com.chrynan.graphkl.language.parser.usecase.token

import com.chrynan.graphkl.language.token.TokenKind

class PeekNextTokenKindUseCase(private val peekNextTokenUseCase: PeekNextTokenUseCase) {

    operator fun invoke(tokenKind: TokenKind) = peekNextTokenUseCase().kind == tokenKind
}