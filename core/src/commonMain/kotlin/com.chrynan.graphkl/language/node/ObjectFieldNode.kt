package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class ObjectFieldNode(
        override val location: Location? = null,
        val name: NameNode,
        val value: ValueNode<Any?>
) : BaseNode(kind = Kind.OBJECT_FIELD) {

    override val childNodes: List<Node> = listOf(name, value)
}