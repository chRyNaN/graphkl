package com.chrynan.graphkl.language.parser.usecase

import com.chrynan.graphkl.language.node.NamedTypeNode

class ParseNamedTypeUseCase(private val parseName: ParseNameUseCase) {

    operator fun invoke() = NamedTypeNode(name = parseName())
}