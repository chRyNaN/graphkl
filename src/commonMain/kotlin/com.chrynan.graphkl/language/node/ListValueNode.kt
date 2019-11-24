package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class ListValueNode(
        override val location: Location? = null,
        override val value: List<ValueNode<Any?>> = emptyList()
) : Node,
        ValueNode<List<ValueNode<Any?>>> {

    override val kind: Kind = Kind.LIST
}