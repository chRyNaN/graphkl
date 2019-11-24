package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class NonNullTypeNode(
        override val location: Location? = null,
        val type: NamedTypeNode
) : Node,
        TypeNode {

    override val kind: Kind = Kind.NON_NULL_TYPE
}