package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class ListTypeNode(
        override val location: Location? = null,
        val type: TypeNode
) : Node,
        TypeNode {

    override val kind: Kind = Kind.LIST_TYPE
}