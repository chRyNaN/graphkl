package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class DirectiveDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val arguments: List<InputValueDefinitionNode> = emptyList(),
        val repeatable: Boolean,
        val locations: List<NameNode> = emptyList()
) : BaseNode(kind = Kind.DIRECTIVE_DEFINITION),
        TypeSystemDefinitionNode