package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class InputObjectTypeDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList(),
        val fields: List<InputValueDefinitionNode> = emptyList()
) : Node,
        TypeDefinitionNode {

    override val kind: Kind = Kind.INPUT_OBJECT_TYPE_DEFINITION
}