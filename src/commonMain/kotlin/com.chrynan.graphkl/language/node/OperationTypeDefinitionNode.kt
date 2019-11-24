package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class OperationTypeDefinitionNode(
        override val location: Location? = null,
        val operation: OperationTypeNode,
        val type: NamedTypeNode
) : Node {

    override val kind: Kind = Kind.OPERATION_TYPE_DEFINITION
}