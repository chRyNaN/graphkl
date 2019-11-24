package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] that represents the definition of a GraphQL Schema from a [Source]. A Schema is the root of a GraphQL type
 * system. All other defined types that can be queried will be children of the Schema definition either in the query,
 * mutation, subscription, or directive fields. For example, the following is an example of a Schema definition:
 *
 * schema {
 *     query: Query
 *     mutation: Mutation
 * }
 *
 * In a GraphQL Schema, the 'query' field is mandatory and all other fields are optional. A Schema definition begins
 * with the 'schema' keyword and followed by brackets containing the field definitions. This [Node] represents that
 * whole definition sequence. The [directives] property represents the list of any directives on the Schema object. The
 * [operationTypes] property represents all the defined operation types ('query', 'mutation', etc).
 */
data class SchemaDefinitionNode(
        override val location: Location? = null,
        val directives: List<DirectiveNode> = emptyList(),
        val operationTypes: List<OperationTypeDefinitionNode> = emptyList()
) : BaseNode(kind = Kind.SCHEMA_DEFINITION),
        TypeSystemDefinitionNode