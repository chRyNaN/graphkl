package com.chrynan.graphkl.error

import com.chrynan.graphkl.language.Source

/**
 * A [GraphQLError] indicating that there was a GraphQL syntax error in a Query or Schema.
 */
class SyntaxError(message: String, position: Int, source: Source) : GraphQLThrowableError(
        message = message,
        positions = listOf(position),
        source = source
)