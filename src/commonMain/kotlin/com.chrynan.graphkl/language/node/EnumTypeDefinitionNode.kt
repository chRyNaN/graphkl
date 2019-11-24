package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class EnumTypeDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList(),
        val values: List<EnumValueDefinitionNode> = emptyList()
) : Node,
        TypeDefinitionNode {

    override val kind: Kind = Kind.ENUM_TYPE_DEFINITION
}