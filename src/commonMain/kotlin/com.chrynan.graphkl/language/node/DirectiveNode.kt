package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class DirectiveNode(
        override val location: Location? = null,
        val name: NameNode,
        val arguments: List<ArgumentNode> = emptyList()
) : Node {

    override val kind: Kind = Kind.DIRECTIVE
}