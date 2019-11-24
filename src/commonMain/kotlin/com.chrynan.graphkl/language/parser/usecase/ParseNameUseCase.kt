package com.chrynan.graphkl.language.parser.usecase

import com.chrynan.graphkl.language.node.NameNode
import com.chrynan.graphkl.language.parser.usecase.token.GetNextExpectedTokenUseCase
import com.chrynan.graphkl.language.token.TokenKind

class ParseNameUseCase(private val getNextExpectedToken: GetNextExpectedTokenUseCase) {

    operator fun invoke(): NameNode {
        val token = getNextExpectedToken(expectedKind = TokenKind.NAME)

        return NameNode(value = token.value!!)
    }
}