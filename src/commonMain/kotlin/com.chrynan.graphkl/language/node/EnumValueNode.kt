package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing an enum value in a GraphQL Query from a [Source]. This represents the actual enum value and not
 * the enum type definition. The [value] property is the String representation of the enum value (e.g. the enum value
 * name).
 */
data class EnumValueNode(
        override val location: Location? = null,
        override val value: String
) : BaseNode(kind = Kind.ENUM),
        ValueNode<String>