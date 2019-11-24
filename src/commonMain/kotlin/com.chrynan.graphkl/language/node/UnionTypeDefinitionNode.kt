package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class UnionTypeDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList(),
        val types: List<NamedTypeNode> = emptyList()
) : BaseNode(kind = Kind.UNION_TYPE_DEFINITION),
        TypeDefinitionNode