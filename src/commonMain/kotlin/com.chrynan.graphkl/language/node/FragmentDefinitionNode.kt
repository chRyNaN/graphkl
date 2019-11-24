package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class FragmentDefinitionNode(
        override val location: Location? = null,
        val name: NameNode,
        val variableDefinitions: List<VariableDefinitionNode> = emptyList(),
        val typeCondition: NamedTypeNode,
        val directives: List<DirectiveNode> = emptyList(),
        val selectionSet: SelectionSetNode
) : BaseNode(kind = Kind.FRAGMENT_DEFINITION),
        ExecutableDefinitionNode