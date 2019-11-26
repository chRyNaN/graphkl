package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] representing a String value in a GraphQL Query from a [Source]. This represents the actual value and not the
 * type definition. A String value can either be block String or a single line String value. Also, String values are
 * used for the ID scalar type as well. The [value] property represents the actual String value. The [block] property
 * represents whether this is a block String or not.
 */
data class StringValueNode(
        override val location: Location? = null,
        override val value: String,
        val block: Boolean = false
) : BaseNode(kind = Kind.STRING),
        ValueNode<String>