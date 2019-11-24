package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class InlineFragmentNode(
        override val location: Location? = null,
        val typeCondition: NamedTypeNode? = null,
        val directives: List<DirectiveNode> = emptyList(),
        val selectionSet: SelectionSetNode
) : BaseNode(kind = Kind.INLINE_FRAGMENT),
        FragmentNode,
        SelectionNode