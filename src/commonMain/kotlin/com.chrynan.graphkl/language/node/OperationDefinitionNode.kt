package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class OperationDefinitionNode(
        override val location: Location? = null,
        val operation: OperationTypeNode,
        val name: NameNode,
        val variableDefinitions: List<VariableDefinitionNode> = emptyList(),
        val directives: List<DirectiveNode> = emptyList(),
        val selectionSet: SelectionSetNode
) : BaseNode(kind = Kind.OPERATION_DEFINITION),
        ExecutableDefinitionNode