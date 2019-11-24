package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class InputValueDefinitionNode(
        override val location: Location? = null,
        val description: StringValueNode? = null,
        val name: NameNode,
        val type: TypeNode,
        val defaultValue: ValueNode<Any?>? = null,
        val directives: List<DirectiveNode> = emptyList()
) : Node {

    override val kind: Kind = Kind.INPUT_VALUE_DEFINITION
}