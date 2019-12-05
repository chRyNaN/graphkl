package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class ObjectValueNode(
        override val location: Location? = null,
        val fields: List<ObjectFieldNode> = emptyList()
) : BaseNode(kind = Kind.OBJECT),
        ValueNode<List<ObjectFieldNode>> {

    override val value: List<ObjectFieldNode> = fields

    override val childNodes: List<Node> = fields
}