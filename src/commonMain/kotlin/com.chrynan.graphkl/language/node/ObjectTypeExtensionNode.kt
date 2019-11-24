package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class ObjectTypeExtensionNode(
        override val location: Location? = null,
        val name: NameNode,
        val interfaces: List<NamedTypeNode> = emptyList(),
        val directives: List<DirectiveNode> = emptyList(),
        val fields: List<FieldDefinitionNode> = emptyList()
) : Node,
        TypeExtensionNode {

    override val kind: Kind = Kind.OBJECT_TYPE_EXTENSION
}