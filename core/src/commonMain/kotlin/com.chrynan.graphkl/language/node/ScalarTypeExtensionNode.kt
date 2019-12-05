package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class ScalarTypeExtensionNode(
        override val location: Location? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList()
) : BaseNode(kind = Kind.SCALAR_TYPE_EXTENSION),
        TypeExtensionNode {

    override val childNodes: List<Node> = listOf(name) + directives
}