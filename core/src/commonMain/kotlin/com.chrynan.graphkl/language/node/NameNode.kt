package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location
import com.chrynan.graphkl.language.Source

/**
 * A [Node] that represents the name of a GraphQL Component in a [Source]. This can be used to represent the name of a
 * field, an argument, a type, etc. The [value] property represents the String name value.
 *
 * Note that this is different than the [NamedTypeNode] which more specifically represents the use of a type name.
 */
data class NameNode(
        override val location: Location? = null,
        val value: String
) : BaseNode(kind = Kind.NAME) {

    override val childNodes: List<Node> = emptyList()
}