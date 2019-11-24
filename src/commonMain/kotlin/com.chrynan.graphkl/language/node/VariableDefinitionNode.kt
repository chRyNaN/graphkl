package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class VariableDefinitionNode(
        override val location: Location? = null,
        val variable: VariableNode,
        val type: TypeNode,
        val defaultValue: ValueNode<Any?>? = null,
        val directives: List<DirectiveNode> = emptyList()
) : Node {

    override val kind: Kind = Kind.VARIABLE_DEFINITION
}