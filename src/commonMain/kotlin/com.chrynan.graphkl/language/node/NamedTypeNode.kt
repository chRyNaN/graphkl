package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class NamedTypeNode(
        override val location: Location? = null,
        val name: NameNode
) : Node,
        TypeNode {

    override val kind: Kind = Kind.NAMED_TYPE
}