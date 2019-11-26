package com.chrynan.graphkl.language.parser.usecase.definition

import com.chrynan.graphkl.language.node.DirectiveDefinitionNode
import com.chrynan.graphkl.language.parser.usecase.ParseDescriptionUseCase
import com.chrynan.graphkl.language.parser.usecase.ParseDirectiveLocationUseCase
import com.chrynan.graphkl.language.parser.usecase.ParseNameUseCase
import com.chrynan.graphkl.language.parser.usecase.token.GetCurrentTokenUseCase
import com.chrynan.graphkl.language.parser.usecase.token.GetNextExpectedTokenByKeywordUseCase
import com.chrynan.graphkl.language.parser.usecase.token.GetNextExpectedTokenUseCase
import com.chrynan.graphkl.language.token.TokenKind

class ParseDirectiveDefinitionUseCase(
        private val parseDescription: ParseDescriptionUseCase,
        private val parseName: ParseNameUseCase,
        private val parseArgumentDefinitions: ParseArgumentDefinitionsUseCase,
        private val parseDirectiveLocation: ParseDirectiveLocationUseCase,
        private val getNextExpectedToken: GetNextExpectedTokenUseCase,
        private val getNextExpectedTokenByKeyword: GetNextExpectedTokenByKeywordUseCase,
        private val getCurrentToken: GetCurrentTokenUseCase
) {

    companion object {

        private const val KEYWORD_DIRECTIVE = "directive"
    }

    operator fun invoke(): DirectiveDefinitionNode {
        val start = getCurrentToken()
        val description = parseDescription()
        getNextExpectedTokenByKeyword(keyword = KEYWORD_DIRECTIVE)
        getNextExpectedToken(expectedKind = TokenKind.AT)
        val name = parseName()
        val args = parseArgumentDefinitions()

        TODO()
    }
}