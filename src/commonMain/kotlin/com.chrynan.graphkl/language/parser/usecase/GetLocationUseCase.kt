package com.chrynan.graphkl.language.parser.usecase

import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.lexer.Lexer
import com.chrynan.graphkl.language.parser.ParseOptions
import com.chrynan.graphkl.language.parser.usecase.token.GetCurrentTokenUseCase
import com.chrynan.graphkl.language.token.Token

class GetLocationUseCase(
        private val getCurrentToken: GetCurrentTokenUseCase,
        private val lexer: Lexer,
        private val options: ParseOptions
) {

    operator fun invoke(token: Token): Location? = if (options.noLocation != true) {
        Location(
                startToken = getCurrentToken(),
                endToken = token,
                source = lexer.source)
    } else {
        null
    }
}