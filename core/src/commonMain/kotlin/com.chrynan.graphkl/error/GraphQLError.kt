package com.chrynan.graphkl.error

import com.chrynan.graphkl.language.Source
import com.chrynan.graphkl.language.SourceLocation
import com.chrynan.graphkl.language.node.Node

/**
 * An error that can occur during the validation or execution of a GraphQL Schema or Query.
 *
 * @author chRyNaN
 */
interface GraphQLError {

    /**
     * A message describing the error for debugging purposes.
     */
    val message: String

    /**
     * The source GraphQL document for the first location of this error.
     *
     * Note that if this error represents more than one mode, the source may not represent nodes after the first node.
     */
    val source: Source?

    /**
     * A [List] of character offsets within the [source] GraphQL document
     * which correspond to this error.
     */
    val positions: List<Int>

    /**
     * A [List] of [SourceLocation] ({ line, column }) within the [source] GraphQL document
     * which correspond to this error.
     *
     * Errors during validation often contain multiple locations, for example to
     * point out two things with the same name. Errors during execution include a
     * single location, the field which produced the error.
     */
    val locations: List<SourceLocation>

    /**
     * An array of GraphQL AST Nodes corresponding to this error.
     */
    val nodes: List<Node>

    /**
     * The original error thrown from a field resolver during execution.
     */
    val originalError: Throwable?

    /**
     * Converts this [GraphQLError] instance into a [Throwable] that can be thrown.
     */
    fun asThrowable(): GraphQLThrowableError
}