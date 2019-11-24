package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class FragmentSpreadNode(
        override val location: Location? = null,
        val name: NameNode,
        val directives: List<DirectiveNode> = emptyList()
) : Node,
        FragmentNode,
        SelectionNode {

    override val kind: Kind = Kind.FRAGMENT_SPREAD
}