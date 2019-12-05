package com.chrynan.graphkl.language.parser.usecase

import com.chrynan.graphkl.language.DirectiveLocation
import com.chrynan.graphkl.error.UnexpectedTokenError
import com.chrynan.graphkl.language.node.NameNode
import com.chrynan.graphkl.language.parser.usecase.token.GetCurrentTokenUseCase
import com.chrynan.graphkl.language.token.TokenKind

class ParseDirectiveLocationUseCase(
        private val getCurrentToken: GetCurrentTokenUseCase,
        private val parseName: ParseNameUseCase
) {

    operator fun invoke(): NameNode {
        val token = getCurrentToken()
        val name = parseName()

        return if (DirectiveLocation.values().firstOrNull { it.name == name.value } != null) {
            name
        } else {
            throw UnexpectedTokenError(token = token, expectedKind = TokenKind.NAME)
        }
    }
}