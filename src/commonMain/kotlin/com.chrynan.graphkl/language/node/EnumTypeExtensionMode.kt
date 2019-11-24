package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class EnumTypeExtensionMode(
        override val location: Location? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList(),
        val values: List<EnumValueDefinitionNode> = emptyList()
) : Node,
        TypeExtensionNode {

    override val kind: Kind = Kind.ENUM_TYPE_EXTENSION
}