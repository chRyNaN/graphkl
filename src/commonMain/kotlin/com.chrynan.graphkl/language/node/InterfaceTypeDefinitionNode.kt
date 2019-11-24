package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class InterfaceTypeDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val interfaces: List<NamedTypeNode> = emptyList(),
        val directives: List<DirectiveNode> = emptyList(),
        val fields: List<FieldDefinitionNode> = emptyList()
) : BaseNode(kind = Kind.INTERFACE_TYPE_DEFINITION),
        TypeDefinitionNode