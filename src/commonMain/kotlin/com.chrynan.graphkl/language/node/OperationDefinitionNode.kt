package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class OperationDefinitionNode(
        override val location: Location? = null,
        val operation: OperationTypeNode,
        val name: NameNode,
        val variableDefinitions: List<VariableDefinitionNode> = emptyList(),
        val directives: List<DirectiveNode> = emptyList(),
        val selectionSet: SelectionSetNode
) : Node,
        ExecutableDefinitionNode {

    override val kind: Kind = Kind.OPERATION_DEFINITION
}