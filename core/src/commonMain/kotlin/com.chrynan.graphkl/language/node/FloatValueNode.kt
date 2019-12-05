package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a float value in a GraphQL Query from a [Source]. This node represents the actual value and not
 * the type definition and can be provided as an argument or input value in a mutation from a query. The [value]
 * represents the actual float value provided.
 */
data class FloatValueNode(
        override val location: Location? = null,
        override val value: Float
) : BaseNode(kind = Kind.FLOAT),
        ValueNode<Float> {

    override val childNodes: List<Node> = emptyList()
}