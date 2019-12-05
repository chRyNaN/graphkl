package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a non-null type in a Schema from a [Source]. For example, consider the following GraphQL
 * Schema:
 *
 * type Character {
 *     name: String!
 *     appearsIn: [Episode]!
 * }
 *
 * In the above Schema, both the 'name' and 'appearsIn' fields are non-null fields of object type 'Character'. A
 * non-null type is declared using the exclamation point ('!') after the types name (e.g. 'String'). By default, all
 * types are nullable. But by adding the exclamation point after the types name ('String!'), the type is non-null. This
 * means that if the field of the object were to be queried, it would have to return a non-null value.
 */
data class NonNullTypeNode(
        override val location: Location? = null,
        val type: NamedTypeNode
) : BaseNode(kind = Kind.NON_NULL_TYPE),
        TypeNode {

    override val childNodes: List<Node> = listOf(type)
}