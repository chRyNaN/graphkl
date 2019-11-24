package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class ScalarTypeDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList()
) : Node,
        TypeDefinitionNode {

    override val kind: Kind = Kind.SCALAR_TYPE_DEFINITION
}