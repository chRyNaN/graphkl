package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class ScalarTypeExtensionNode(
        override val location: Location? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList()
) : Node,
        TypeExtensionNode {

    override val kind: Kind = Kind.SCALAR_TYPE_EXTENSION
}