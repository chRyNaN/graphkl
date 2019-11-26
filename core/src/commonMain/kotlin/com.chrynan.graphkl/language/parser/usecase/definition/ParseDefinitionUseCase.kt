package com.chrynan.graphkl.language.parser.usecase.definition

import com.chrynan.graphkl.language.node.DefinitionNode
import com.chrynan.graphkl.language.parser.usecase.token.PeekNextTokenUseCase
import com.chrynan.graphkl.language.parser.usecase.extension.ParseTypeSystemExtensionUseCase

class ParseDefinitionUseCase(
        private val peekNextToken: PeekNextTokenUseCase,
        private val parseOperationDefinition: ParseOperationDefinitionUseCase,
        private val parseFragmentDefinition: ParseFragmentDefinitionUseCase,
        private val parseTypeSystemDefinition: ParseTypeSystemDefinitionUseCase,
        private val parseTypeSystemExtension: ParseTypeSystemExtensionUseCase
) {

    operator fun invoke(): DefinitionNode = TODO()
}