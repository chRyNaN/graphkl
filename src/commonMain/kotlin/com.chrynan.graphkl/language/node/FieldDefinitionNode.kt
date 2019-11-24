package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class FieldDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val arguments: List<InputValueDefinitionNode> = emptyList(),
        val type: TypeNode,
        val directives: List<DirectiveNode> = emptyList()
) : Node {

    override val kind: Kind = Kind.FIELD_DEFINITION
}