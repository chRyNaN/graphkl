package com.chrynan.graphkl.language.parser.usecase

import com.chrynan.graphkl.language.node.VariableNode
import com.chrynan.graphkl.language.parser.usecase.token.GetNextExpectedTokenUseCase
import com.chrynan.graphkl.language.token.TokenKind

class ParseVariableUseCase(
        private val getNextExpectedToken: GetNextExpectedTokenUseCase,
        private val parseName: ParseNameUseCase
) {

    operator fun invoke(): VariableNode {
        val token = getNextExpectedToken(expectedKind = TokenKind.DOLLAR)

        return VariableNode(name = parseName())
    }
}