package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a list value in a GraphQL Query from a [Source]. This represents the actual value passed into a
 * query. For the list type used in a Schema refer to the [ListTypeNode].
 */
data class ListValueNode(
        override val location: Location? = null,
        override val value: List<ValueNode<Any?>> = emptyList()
) : BaseNode(kind = Kind.LIST),
        ValueNode<List<ValueNode<Any?>>>