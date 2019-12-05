package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] that represents a boolean value ('true' or 'false') within a GraphQL Query from a [Source]. This value can
 * be provided in an argument for a field or as an input value for a mutation for a boolean type. The [value] is the
 * value provided ('true' or 'false').
 */
data class BooleanValueNode(
        override val location: Location? = null,
        override val value: Boolean
) : BaseNode(kind = Kind.BOOLEAN),
        ValueNode<Boolean>{

    override val childNodes: List<Node> = emptyList()
}