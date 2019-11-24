package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class ObjectValueNode(
        override val location: Location? = null,
        val fields: List<ObjectFieldNode> = emptyList()
) : Node,
        ValueNode<List<ObjectFieldNode>> {

    override val kind: Kind = Kind.OBJECT

    override val value: List<ObjectFieldNode> = emptyList()
}