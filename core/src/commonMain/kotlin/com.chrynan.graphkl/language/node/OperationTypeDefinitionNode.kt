package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] that represents one of the default GraphQL object types in the top level of a Schema, from a [Source]. For
 * example:
 *
 * schema {
 *     query: Query
 *     mutation: Mutation
 * }
 *
 * In the above Schema, the 'query' and 'mutation' type are special types for a GraphQL Schema that define the entry
 * point for the query. An operation type definition contains the name ('query') and the type ('Query'). The name for an
 * operation type definition can only be one of three values: query, mutation, or subscription. But the type returned
 * can be any type. This [Node] represents that whole sequence. The [operation] property represents the name of the
 * operation. The [type] property represents the name of the actual type returned by the operation.
 *
 * Note that for a GraphQL Query, the operation is defined by [OperationDefinitionNode].
 */
data class OperationTypeDefinitionNode(
        override val location: Location? = null,
        val operation: OperationTypeNode,
        val type: NamedTypeNode
) : BaseNode(kind = Kind.OPERATION_TYPE_DEFINITION)