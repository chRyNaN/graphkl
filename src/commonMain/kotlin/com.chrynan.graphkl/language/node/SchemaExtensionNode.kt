package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class SchemaExtensionNode(
        override val location: Location? = null,
        val directives: List<DirectiveNode> = emptyList(),
        val operationTypes: List<OperationTypeDefinitionNode> = emptyList()
) : Node,
        TypeSystemExtensionNode {

    override val kind: Kind = Kind.SCHEMA_EXTENSION
}