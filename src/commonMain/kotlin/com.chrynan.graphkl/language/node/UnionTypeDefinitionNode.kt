package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class UnionTypeDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList(),
        val types: List<NamedTypeNode> = emptyList()
) : Node,
        TypeDefinitionNode {

    override val kind: Kind = Kind.UNION_TYPE_DEFINITION
}