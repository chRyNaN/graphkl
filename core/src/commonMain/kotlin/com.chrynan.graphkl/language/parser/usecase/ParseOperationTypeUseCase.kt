package com.chrynan.graphkl.language.parser.usecase

import com.chrynan.graphkl.language.node.OperationTypeNode
import com.chrynan.graphkl.language.parser.usecase.token.GetNextExpectedTokenUseCase
import com.chrynan.graphkl.language.token.TokenKind

class ParseOperationTypeUseCase(private val getNextExpectedToken: GetNextExpectedTokenUseCase) {

    operator fun invoke(): OperationTypeNode {
        val token = getNextExpectedToken(expectedKind = TokenKind.NAME)

        return OperationTypeNode.values().firstOrNull { it.value == token.value } ?: OperationTypeNode.QUERY
    }
}