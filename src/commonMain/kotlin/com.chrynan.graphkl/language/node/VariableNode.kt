package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class VariableNode(
        override val location: Location? = null,
        val name: NameNode
) : Node,
        ValueNode<NameNode> {

    override val kind: Kind = Kind.VARIABLE

    override val value = name
}