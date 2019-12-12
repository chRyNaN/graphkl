package com.chrynan.graphkl.error

import com.chrynan.graphkl.execution.GraphQLQueryResult
import com.chrynan.graphkl.language.Source
import com.chrynan.graphkl.language.SourceLocation
import com.chrynan.graphkl.language.node.Node

/**
 * A [GraphQLError] that is also a Kotlin [Throwable] and can be thrown when encountered. This is useful for scenarios
 * when an error was encountered and should cause the application to throw immediately. [GraphQLError]s are useful for
 * returning errors in a [GraphQLQueryResult]. All [GraphQLError]s are capable of returning an instance of this class
 * by calling the [GraphQLError.asThrowable] function.
 *
 * @author chRyNaN
 */
open class GraphQLThrowableError(
        override val message: String,
        override val locations: List<SourceLocation> = emptyList(),
        override val nodes: List<Node> = emptyList(),
        override val originalError: Throwable? = null,
        override val source: Source? = null,
        override val positions: List<Int> = emptyList()
) : RuntimeException("GraphQLThrowableError: message = $message; locations = $locations; positions = $positions; nodes = $nodes; source = $source; originalError = $originalError"),
        GraphQLError {

    override fun asThrowable(): GraphQLThrowableError = this
}