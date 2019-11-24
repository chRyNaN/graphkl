package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class EnumTypeExtensionMode(
        override val location: Location? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList(),
        val values: List<EnumValueDefinitionNode> = emptyList()
) : BaseNode(kind = Kind.ENUM_TYPE_EXTENSION),
        TypeExtensionNode