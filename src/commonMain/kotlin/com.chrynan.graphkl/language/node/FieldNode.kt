package com.chrynan.graphkl.language.node

import com.chrynan.graphkl.language.Kind
import com.chrynan.graphkl.language.Location

data class FieldNode(
        override val location: Location? = null,
        val alias: NameNode? = null,
        val name: NameNode,
        val arguments: List<ArgumentNode> = emptyList(),
        val directives: List<DirectiveNode> = emptyList(),
        val selectionSet: SelectionSetNode? = null
) : BaseNode(kind = Kind.FIELD),
        SelectionNode