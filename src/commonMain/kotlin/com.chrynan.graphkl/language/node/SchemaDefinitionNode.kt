package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class SchemaDefinitionNode(
        override val location: Location? = null,
        val directives: List<DirectiveNode> = emptyList(),
        val operationTypes: List<OperationTypeDefinitionNode> = emptyList()
) : BaseNode(kind = Kind.SCHEMA_DEFINITION),
        TypeSystemDefinitionNode