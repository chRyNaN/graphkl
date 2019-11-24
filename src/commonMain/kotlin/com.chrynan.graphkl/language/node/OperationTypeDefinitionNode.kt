package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class OperationTypeDefinitionNode(
        override val location: Location? = null,
        val operation: OperationTypeNode,
        val type: NamedTypeNode
) : BaseNode(kind = Kind.OPERATION_TYPE_DEFINITION)