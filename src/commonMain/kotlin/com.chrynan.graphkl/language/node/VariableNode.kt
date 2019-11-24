package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class VariableNode(
        override val location: Location? = null,
        val name: NameNode
) : BaseNode(kind = Kind.VARIABLE),
        ValueNode<NameNode> {

    override val value = name
}