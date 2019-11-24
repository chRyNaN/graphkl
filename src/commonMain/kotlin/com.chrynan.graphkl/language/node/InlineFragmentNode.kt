package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

class InlineFragmentNode(
        override val location: Location? = null,
        val typeCondition: NamedTypeNode? = null,
        val directives: List<DirectiveNode> = emptyList(),
        val selectionSet: SelectionSetNode
) : Node,
        FragmentNode,
        SelectionNode {

    override val kind: Kind = Kind.INLINE_FRAGMENT
}