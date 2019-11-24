package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class ObjectTypeDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val arguments: List<InputValueDefinitionNode> = emptyList(),
        val type: TypeNode,
        val directives: List<DirectiveNode> = emptyList()
) : BaseNode(kind = Kind.OBJECT_TYPE_DEFINITION),
        TypeDefinitionNode