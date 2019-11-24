package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class UnionTypeExtensionNode(
        override val location: Location? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList(),
        val types: List<NamedTypeNode> = emptyList()
) : Node,
        TypeExtensionNode {

    override val kind: Kind = Kind.UNION_TYPE_EXTENSION
}