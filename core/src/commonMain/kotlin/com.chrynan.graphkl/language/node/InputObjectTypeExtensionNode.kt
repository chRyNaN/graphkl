package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class InputObjectTypeExtensionNode(
        override val location: Location? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList(),
        val values: List<EnumValueDefinitionNode> = emptyList()
) : BaseNode(kind = Kind.INPUT_OBJECT_TYPE_EXTENSION),
        TypeExtensionNode {

    override val childNodes: List<Node> = listOf(name) + directives + values
}