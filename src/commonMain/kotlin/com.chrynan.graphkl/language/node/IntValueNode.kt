package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing an integer value in a GraphQL Query from a [Source]. This represents the actual integer value
 * and not the type definition. The [value] property represents the actual integer value provided.
 */
data class IntValueNode(
        override val location: Location? = null,
        override val value: Int
) : BaseNode(kind = Kind.INT),
        ValueNode<Int>