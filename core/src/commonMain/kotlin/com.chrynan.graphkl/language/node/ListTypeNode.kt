package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a list type in a GraphQL Schema from a [Source]. For example, consider the following GraphQL
 * type definition:
 *
 * type Character {
 *     name: String!
 *     appearsIn: [Episode]!
 * }
 *
 * In the above GraphQL, the 'appearsIn' field, in type 'Character', is a list type. The field returns a list of type
 * 'Episode'. The exclamation mark denotes that the list is non-nullable (see [NonNullTypeNode]). A list type node
 * consists of braces ('[]') containing the type name of the list ('Episode'). This [Node] represents that whole
 * sequence. The [type] property represents the type of this list ('Episode').
 *
 * Note that this does not represent a list value that is passed in to a query. That is represented by the
 * [ListValueNode].
 */
data class ListTypeNode(
        override val location: Location? = null,
        val type: TypeNode
) : BaseNode(kind = Kind.LIST_TYPE),
        TypeNode {

    override val childNodes: List<Node> = listOf(type)
}