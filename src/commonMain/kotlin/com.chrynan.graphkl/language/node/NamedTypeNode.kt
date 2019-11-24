package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] that represents a GraphQL types name from a [Source]. This could be in a field definition, type definition,
 * or in an argument definition (input value definition), etc. This represents the use of a named GraphQL type. For
 * example, consider the following GraphQL Schema definition:
 *
 * schema {
 *     query: Query
 *     mutation: Mutation
 * }
 *
 * In the above Schema definition, there are two fields of the root 'schema' object: 'query' and 'mutation'. Each of
 * these fields are defined with their name ('query', 'mutation') and their type ('Query', 'Mutation'). The type name
 * (e.g. 'Query') is represented by this [Node]. The [name] property represents the name of this type.
 *
 * Note that this is a type and differs from the [NameNode] which strictly represents a name.
 */
data class NamedTypeNode(
        override val location: Location? = null,
        val name: NameNode
) : BaseNode(kind = Kind.NAMED_TYPE),
        TypeNode